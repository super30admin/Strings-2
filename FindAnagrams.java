import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC O(m+n)
//Sc O(n)
//Store the chars of pattern in a map, Use Sliding window on source to check if each char exists in the map
//keep track of matching chars from map and if match variable is same as num of keys in map, thats one result
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(m<n) return res;
        //put all chars of p in hashMap
        char[] c = p.toCharArray();
        for(char ch : c){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int match=0;
        for(int i=0;i<m;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if(freq==0) match++;

            }

            if(i>=n){
                //the window is sliding
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if(freq==1) match--;
                }
            }
            if(match==map.size())
                res.add(i-n+1);
        }
        return res;
    }
}