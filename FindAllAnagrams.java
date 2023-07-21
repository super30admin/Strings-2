import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < n; i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                int count = map.get(in) - 1;
                map.put(in, count);
                if (count == 0) {
                    match++;
                }
            }
            // if(i>=m)
            if (i >= p.length()) {
                char out = s.charAt(i - m);
                if (map.containsKey(out)) {
                    int count = map.get(out) + 1;
                    map.put(out, count);
                    if (count == 1) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllAnagrams obj = new FindAllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = obj.findAnagrams(s, p);
        System.out.println("Indices of anagrams in the string: " + result);

        s = "abab";
        p = "ab";
        result = obj.findAnagrams(s, p);
        System.out.println("Indices of anagrams in the string: " + result);
    }

}
