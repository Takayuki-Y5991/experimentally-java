package com.example.javautilslibrary.common.utils;

import java.time.LocalDateTime;

public class Constance {
    /**
     * mail format
     */
    public static final String MAIL_FORMAT = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    /**
     * contact format
     */
    public static final String CONTACT_FORMAT = "0\\d{1,4}-\\d{1,4}-\\d{4}";

    /**
     * account name format
     */
    public static final String ACCOUNT_NAME = "^[A-Za-z0-9]{4,20}$";

    /**
     * Fetch data limit
     */
    public static final long DEFAULT_FETCH_LIMIT = 10L;

    /**
     * Book return limit
     */
    public static LocalDateTime DEFAULT_BOOK_RETURN_LIMIT() {
        return LocalDateTime.now().plusDays(10L);
    }

    /**
     * Book max borrowed count
     */
    public static final int DEFAULT_BOOK_MAX_BORROWED_COUNT = 10;
}
