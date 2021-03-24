package com.psamatt.hackerrank.firstuniquechar;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public char find(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new LinkedHashMap<>();
        for (char c : chars) {
            for (char iteratingChar : chars) {
                if (c == iteratingChar) {
                    Integer existingCounter = counter.getOrDefault(c, 0);
                    counter.put(c, existingCounter + 1);
                }
            }
        }

        return counter.entrySet().stream()
                .filter(item -> item.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new NoFirstUniqueCharacterFound(s));
    }
}
