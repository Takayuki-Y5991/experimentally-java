package com.example.javautilslibrary.domain.object.value;

import com.example.javautilslibrary.common.exception.DomainException;
import com.example.javautilslibrary.common.utils.Constance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder(access = AccessLevel.PRIVATE)
public class AccountName {

    private String accountName;

    public static AccountName build(String accountName) {
        return AccountName.builder()
                .accountName(isValidAccountName(accountName))
                .build();
    }

    private static String isValidAccountName(String accountName) {
        if (StringUtils.isBlank(accountName)) {
            return null;
        }
        if (!accountName.matches(Constance.ACCOUNT_NAME)) {
            throw new DomainException("Account name is invalid format, check your account name [ex: account1]");
        }
        return accountName;
    }
}
