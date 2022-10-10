package com.example.javautilslibrary.domain.service;

import com.example.javautilslibrary.common.exception.AccessDeniedException;
import com.example.javautilslibrary.common.mapper.TokenMapper;
import com.example.javautilslibrary.common.utils.AuthUtils;
import com.example.javautilslibrary.common.utils.JwtUtils;
import com.example.javautilslibrary.domain.object.entity.Member;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.infrastructure.entity.RedisEntity;
import com.example.javautilslibrary.infrastructure.repository.RedisRepository;
import jodd.util.StringUtil;
import org.openapi.example.model.AuthRequest;
import org.openapi.example.model.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthUtils authUtils;
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TokenMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TokenResponse getToken(AuthRequest request) {
        /* Verify authorization */
        var member = this.processVerification(request.getAccountName(), request.getPassword());
        var token = this.generateToken(member);
        return mapper.toTokenResponse(mapper.toDomain(token));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public TokenResponse refreshToken(String authorization) {
        String parsedToken = null;

        if (StringUtil.isBlank(authorization)) {
            throw new AccessDeniedException("Incorrect token, Is Blank");
        }
        if (authorization.length() < 8) {
            throw new AccessDeniedException("Incorrect token, Too Short authorization");
        }
        // Check format to bearer token
        if (!authorization.contains("Bearer ")) {
            throw new AccessDeniedException("Incorrect token, Prefix Bearer");
        }
        // Get id from token
        String token = authorization.substring(7);

        try {
            parsedToken = jwtUtils.parseToken(token);
        } catch (Exception e) {
            throw new AccessDeniedException("Incorrect token, Access Denied");
        }
        var member = memberRepository.fetchByAccountName(parsedToken);
        if (Objects.isNull(member)) {
            throw new AccessDeniedException("Incorrect token, Access Denied");
        }
        if (!redisRepository.getBucketValue(RedisEntity.buildValue(parsedToken, String.valueOf(member.getMemberId())))) {
            throw new AccessDeniedException("Incorrect token, Access Denied");
        }
        var newToken = this.generateToken(member);
        return mapper.toTokenResponse(mapper.toDomain(newToken));
    }

    /**
     * Verification account information
     *
     * @param accountName
     * @param password
     * @return
     */
    private Member processVerification(String accountName, String password) {
        var member = memberRepository.fetchByAccountName(accountName);
        if (Objects.isNull(member)) {
            throw new AccessDeniedException("Incorrect Account name or Password, Please try again");
        }
        if (!authUtils.verifyPassword(password, member.getPassword())) {
            throw new AccessDeniedException("Incorrect Account name or Password, Please try again");
        }
        return member;
    }

    /**
     * Token Generate<br>
     * - expiration 30 minutes
     *
     * @param member
     * @return
     */

    private String generateToken(Member member) {
        /* Setting cache */
        var expiration = LocalDateTime.now().plusMinutes(30);
        redisRepository.createBucket(RedisEntity.buildValue(member.getAccountName().getAccountName(), String.valueOf(member.getMemberId())));
        /* Generate token */
        var token =
                jwtUtils.generateToken(member.getAccountName().getAccountName(), Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant()));
        return token;
    }
}
