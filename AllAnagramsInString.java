import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> myMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(char c: p.toCharArray()){
            myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }
        int match = 0;
        int m = s.length();
        int n = p.length();

        for(int i=0; i < m; i++){
            if(myMap.containsKey(s.charAt(i))){
                int freq = myMap.get(s.charAt(i));
                freq--;
                myMap.put(s.charAt(i), freq);
                if(freq == 0)
                    match++;
            }

            if(i>=n){
                char out = s.charAt(i-n);
                if(myMap.containsKey(out)){
                    int freq = myMap.get(out);
                    freq++;
                    myMap.put(out, freq);
                    if(freq == 1)
                        match--;
                }
            }

            if(match == myMap.size())
                result.add(i-n+1);
        }
        return result;
    }
} AllAnagramsInString {
    
}
