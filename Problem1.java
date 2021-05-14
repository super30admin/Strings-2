//find all anagrams of string
///tc - O(m+n)
//sc - O(26)
import java.util.*;

class Problem1{
    public static void main(String[] args){
        Problem1 p = new Problem1();
        System.out.println(p.findAnagrams("cbaebabacd", "abc"));

    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i< p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }
        int match = 0;
        List<Integer> res = new ArrayList<>();
        //check if anagram is present in s
        for(int i = 0;i< s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)-1);
                if(map.get(curr) ==0){
                    match++;
                }
            }
            
            if(i >= p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count ==1)
                        match--;
                }
            }
            if(match == map.size()){
                res.add(i-p.length()+1);
            }
        }
        return res;
        
    }


}