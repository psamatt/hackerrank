package com.psamatt.hackerrank.bookshoporder.bookorder;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
public class BookCode {
    String code;

    public BookCode(String code) {
        this.code = StringUtils.upperCase(code);
    }
}
