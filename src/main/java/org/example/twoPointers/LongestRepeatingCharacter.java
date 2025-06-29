package org.example.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter
{

    public String minWindow(String s, String t) {

        String minSubString = "";

        int length = t.length();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        int start = 0, end = 0;

        while(end < s.length() && start <= end) {
            char endChar = s.charAt(end);
            if(frequencyMap.containsKey(endChar)) {
                int x = frequencyMap.get(endChar)-1;
                frequencyMap.put(endChar, x);
                if(x == 0) length--;
            }

            while(length == 0) {

                if(minSubString == "" || (end - start + 1) < minSubString.length()) {
                    minSubString = s.substring(start, end+1);
                }

                char startChar = s.charAt(start);
                if(frequencyMap.containsKey(startChar)) {
                    frequencyMap.put(startChar, frequencyMap.get(startChar)+1);
                    length++;
                }
                start++;
            }
            end++;

        }
        return minSubString;

    }
}
