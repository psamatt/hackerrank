package com.psamatt.hackerrank.bookshoporder.bookorder;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
public class Surname {
    String surname;

    public Surname(String surname) {
        this.surname = StringUtils.capitalize(surname);
    }
}
