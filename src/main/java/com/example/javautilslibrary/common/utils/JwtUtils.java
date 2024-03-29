package com.example.javautilslibrary.common.utils;

import com.example.javautilslibrary.common.exception.AccessDeniedException;
import com.example.javautilslibrary.domain.repository.MemberRepository;
import com.example.javautilslibrary.infrastructure.entity.RedisEntity;
import com.example.javautilslibrary.infrastructure.repository.RedisRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jodd.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Jwt Utils
 */

@Component
@RequiredArgsConstructor
public class JwtUtils {

    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private MemberRepository memberRepository;

    /**
     * SignatureAlgorithm secret key
     */
    private final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Create Token
     *
     * @param id         subject
     * @param expiration token time limit
     * @return token
     */
    public String generateToken(String id, Date expiration) {
        return Jwts.builder()
                .setSubject(id)
                .setExpiration(expiration)
                .signWith(KEY)
                .compact();
    }

    /**
     * Get subject from token
     *
     * @param token token
     * @return subject
     */
    public String parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Authorization Process
     */
    public Predicate<HttpServletRequest> authorize = (request) -> {
        String authorization = request.getHeader("Authorization");
        // Check authorization parameter
        if (StringUtil.isBlank(authorization)) {
            return false;
        }
        // Check format to bearer token
        if (!authorization.contains("Bearer ")) {
            return false;
        }
        // Get id from token
        String token = authorization.substring(7);
        String id = parseToken(token);

        var member = memberRepository.fetchByAccountName(id);

        if (Objects.isNull(member)) {
            throw new AccessDeniedException("Incorrect token, Access Denied");
        }

        // Check legitimacy　subject value
        return redisRepository.compareCacheValue(RedisEntity.buildValue(id, String.valueOf(member.getMemberId())));
    };
}
