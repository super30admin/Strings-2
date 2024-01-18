// TC : O(m + n)
//SC : O(1)

package S30_Codes.Strings_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();

        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int match = 0;
        for(int i=0; i<s.length(); i++){
            //incoming
            char in = s.charAt(i);
            if(map.containsKey(in)){
                map.put(in, map.get(in)-1);
                if(map.get(in) == 0)
                    match++;
            }

            //outgoing
            if(i >= n){
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    map.put(out, map.get(out)+1);
                    if(map.get(out) == 1)
                        match--;
                }
            }

            if(match == map.size())
                res.add(i-n+1);
        }

        return res;
    }
}