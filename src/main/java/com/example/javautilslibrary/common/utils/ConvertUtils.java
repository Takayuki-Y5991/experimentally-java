package com.example.javautilslibrary.common.utils;

import java.sql.Date;
import java.time.LocalDate;

public class ConvertUtils {

    public static LocalDate toLocalDate(Date target) {
        return target.toLocalDate();
    }
}
