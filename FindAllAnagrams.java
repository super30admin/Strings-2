import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Time Complexity: O(S), S is the length of the String s
Space Complexity: O(N), N is the size of the HashMap, which is nothing but p.length()
Run on Leetcode: Yes
Any difficulties: No

Approach:
1. Attempted After discussed in the class-Sliding window approach
 */
public class FindAllAnagrams {
    public static List<Integer> findAllAnagrams(String s, String p){
        HashMap<Character, Integer> pMap = new HashMap<>();

        for(char c: p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0)+1);
        }
        int matchCount = 0;
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while(i<s.length()){

            // incoming character
            char c = s.charAt(i);
            if(pMap.containsKey(c)){
                int freq = pMap.get(c);
                freq-= 1;
                pMap.put(c, freq);
                if(freq == 0){
                    matchCount++;
                }
            }
            // outgoing character

            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(pMap.containsKey(out)){
                    int freq = pMap.get(out);
                    freq+= 1;
                    pMap.put(out, freq);
                    if(freq == 1){
                        matchCount--;
                    }
                }
            }

            if(matchCount == pMap.size()){
                result.add(i-p.length()+1);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Anagram indices: "+findAllAnagrams("cbaebabacd","abc"));
    }
}
