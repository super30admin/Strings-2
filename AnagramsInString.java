import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class AnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length()==0 || p.length() > s.length()){
            return new ArrayList<>();
        }

        int match=0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(char c : p.toCharArray()){
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            char inc = s.charAt(i);
            if(hmap.containsKey(inc)){
                int count = hmap.get(inc);
                count--;
                if(count ==0){
                    match++;
                }
                hmap.put(inc, count);
            }


            if(i >= p.length()){
                char outg = s.charAt(i-p.length());
                if(hmap.containsKey(outg)){
                    int count = hmap.get(outg);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    hmap.put(outg, count);
                }
            }
            if( match == hmap.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }

}
