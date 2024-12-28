import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem2 {
    //Time Complexity: 0(n+m)
    // Space Complexity: 0(1)
    public List<Integer> findAnagrams(String s, String p) {

        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Character, Integer> map= new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match=0;
        for (int i=0;i<m;i++){
            char in= s.charAt(i);

            if (map.containsKey(in)){
                int freq= map.get(in);
                freq--;
                map.put(in, freq);
                if (freq==0){
                    match++;
                }
            }  if (i>=n) {
                char out= s.charAt(i);
                if (map.containsKey(out)){
                    int freq= map.get(out);
                    freq++;
                    map.put(out, freq);
                    if (freq==1){
                        match--;
                    }
                }
                if (match ==map.size()){
                    res.add(i-n+1);
                }
            }
        }


        return res;
    }

}
