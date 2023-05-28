import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Leetcode - 438
//TimeComplexity - O(m+n)
//SpaceComplexity - O(1) - 26 chars in HashMap

public class FindAllAnagramsOfString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length(), n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++) { //O(m)
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match =0;
        for(int i=0; i<s.length();i++) { //O(n)
            //in
            char in = s.charAt(i);
            if(map.containsKey(in)) {
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++;
                map.put(in,cnt);
            }
            //out
            if(i >= m) {
                char out = s.charAt(i-m);
                if(map.containsKey(out)) {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) {
                        match--;
                    }
                    map.put(out, cnt);
                }
            }
            if(match == map.size()) {
                result.add(i-m+1);
            }
        }
        return result;
    }
}
