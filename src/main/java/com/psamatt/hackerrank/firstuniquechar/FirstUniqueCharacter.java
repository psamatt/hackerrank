package com.psamatt.hackerrank.firstuniquechar;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter {

    public char find(String s) {
        Set<Character> store = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (store.contains(c)) {
                store.remove(c);
            } else {
                store.add(c);
            }
        }

        return store.stream().findFirst().orElseThrow(() -> new NoFirstUniqueCharacterFound(s));
    }
}
