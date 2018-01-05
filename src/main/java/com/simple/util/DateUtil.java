package com.simple.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by S I M P L E on 2018/01/04
 */
public class DateUtil {

    public static String dateChange(String userId) {
        Date systemDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(systemDate) + userId;
    }
}
