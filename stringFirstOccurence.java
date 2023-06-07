//Time Complexity: O(n2);
//Space Complexity: O(n);

import java.util.*;
class Solution {
    public int strStr(String hayStack, String needle) {
        if(hayStack.length() == 0 || hayStack == null) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> lis = new ArrayList<>();

        for(int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int out = 0, match = 0;

        for(int i = 0; i < hayStack.length(); i++) {
            char ch = hayStack.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                count--;
                if (count == 0)
                    match++;
                map.put(ch, count);
            }
            if(i >= needle.length()) {
                out = i - needle.length();
                char c = hayStack.charAt(out);
                if(map.containsKey(c)) {
                    int count = map.get(c);
                    count++;
                    if(count == 1) 
                        match--;
                    map.put(c, count);
                }
            }

            if(match == map.size() ) {
               lis.add(i - needle.length() + 1);
            }
        }
        System.out.println(lis);
        for(int i = 0; i < lis.size(); i++) {
            int k = 0;
            int start = lis.get(i);
            boolean toggle = true;
            for(int j = start; j < start + needle.length(); j++) {
                if(hayStack.charAt(j) != needle.charAt(k)) {
                    toggle = false;
                    break;
                }
                k++;
            }
            if(toggle) {
                return start;
            }
        }
        return -1;
    }
}
