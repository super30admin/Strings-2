//time complexity-  O(m+n) where m is length of p and n is length of s
//space complexity- O(1)
import java.util.*;
public class AllAnagramsInString {
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> sol = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for(int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                map.put(in, map.get(in)-1);
                if(map.get(in) == 0) match++;
            }

            if(i >= p.length()) {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)) {
                    map.put(out, map.get(out)+1);
                    if(map.get(out) == 1) match--;
                }
            }

            if(match == map.size()) sol.add(i-p.length()+1);
        }
        return sol;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("List of anagram index:" + findAnagrams(s, p));
    }
}
