import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Problem2 {
    public List<Integer> findAnagrams(String h, String needle) {
        int match=0;
        List<Integer> result = new ArrayList<>();

        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char j: needle.toCharArray()){
            hmap.put(j,hmap.getOrDefault(j,0)+1);
        }
        for(int i=0;i<h.length();i++){

            if(hmap.containsKey(h.charAt(i))){
                hmap.put(h.charAt(i),hmap.get(h.charAt(i))-1);
                if(hmap.get(h.charAt(i))==0){
                    match++;
                }
            }
            if(i>=needle.length()){
                char o= h.charAt(i-needle.length());
                if(hmap.containsKey(o)){
                    if(hmap.get(o)==0){
                        match--;
                    }
                    hmap.put(o,hmap.get(o)+1);
                }
            }

            if(match==hmap.size()){
                result.add(i-needle.length()+1);
            }





        }
        return result;

    }


}

// Time complexity: O(m+n) where m is the length of haystack and n is the length of needle
// Space complexity: O(1) since the hashmap will have at most 26 characters for lowercase letters