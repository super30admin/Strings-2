import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsInString {
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/description/



    public List<Integer> findAnagrams(String s, String p) {
        if(s==null||s.length()==0 ||p.length()>s.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int match =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i<p.length();i++){
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i<s.length();i++){
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                int count = map.get(incoming);
                count--;
                if(count==0)match++;
                map.put(incoming,count);
            }
            if(i>=p.length()){
                char outgoing = s.charAt(i-p.length());
                if(map.containsKey(outgoing)){
                    int count = map.get(outgoing);
                    count++;
                    if(count ==1) match--;
                    map.put(outgoing,count);
                }
            }
            if(match == map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
}
