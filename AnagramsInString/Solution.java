import java.util.*;
class AnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new ArrayList<>();
       

       HashMap<Character, Integer> hm = new HashMap<>();

       for(int i=0;i<p.length();i++){
            if(!hm.containsKey(p.charAt(i)))
                hm.put(p.charAt(i), 1);
            else
                hm.put(p.charAt(i), hm.get(p.charAt(i)) + 1);
       }

        int match = 0;
       
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // incoming char
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) == 0) match++;
            }

            //outgoing

            if(i >= p.length()){
                char x = s.charAt(i-p.length());
                if(hm.containsKey(x)){
                    hm.put(x, hm.get(x) + 1);
                    if(hm.get(x) == 1) match--;
                }
            }

            if(match == hm.size()) result.add(i-p.length()+1);
        }
       System.out.println(result);
       return result; 
    }
}
class Solution {
    public static void main(String[] args){
        System.out.println("AnagramsInString");
        AnagramsInString obj = new AnagramsInString();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
    }
}