package org.example.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString
{
    public static String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        String minSubString = "";

        int length = t.length();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;

        while (end < s.length()) {

            char endChar = s.charAt(end);

            if (frequencyMap.containsKey(endChar)) {
                if (frequencyMap.get(endChar) > 0) {
                    length--;
                }
                frequencyMap.put(endChar, frequencyMap.get(endChar) - 1);
            }

            // shrink the window while valid
            while (length == 0) {
                // check minimum substring
                String temp = s.substring(start, end + 1);
                if (minSubString.isEmpty() || temp.length() < minSubString.length()) {
                    minSubString = temp;
                }

                char startChar = s.charAt(start);
                if (frequencyMap.containsKey(startChar)) {
                    frequencyMap.put(startChar, frequencyMap.get(startChar) + 1);
                    if (frequencyMap.get(startChar) > 0) {
                        length++;
                    }
                }

                start++; // shrink from left
            }

            end++; // expand window
        }
        return minSubString;
    }
    
    public static String minWindow2(String s, String t) {
        if(s.length() < t.length()) return "";
        
        int[] frequencyArray = new int[128];
        
        for(char c : t.toCharArray()) {
            frequencyArray[c]++;
        }
        
        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int requiredChars = t.length();
        int minStart = 0;
        
        while(right < s.length()) {
            
            if(frequencyArray[charArray[right]]-- > 0) {
                requiredChars--;
            }
            
            while(requiredChars == 0) {
                
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                
                if(++frequencyArray[charArray[left]] > 0) {
                    requiredChars++;
                }
                left++;
            }
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
}


