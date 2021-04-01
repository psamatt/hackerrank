package com.psamatt.hackerrank.firstuniquechar;

public class NoFirstUniqueCharacterFound extends RuntimeException {

    public NoFirstUniqueCharacterFound(String s) {
        super("No first unique character found in " + s);
    }
}
