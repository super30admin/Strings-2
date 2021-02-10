//Problem : 98 - Find All Anagrams in a String
//TC:  Max(O(s.length)+O(p.length))
//SC: O(Unique hashes of s.length/p.length)

/*
 1) Bruteforce: TC:O(s*p)+O(nlogn), here s is string 's' length and 'p' is string p length. Acually we are making a chunk of p size thats why O(s*p).
  Iterate over each character of string s and make pairs/chunks of p length. Then sort that chunk and if sorted chunk is equal to the anagram string then just record the starting index.

 2) Optimised : 
     //TC: Max(O(s.length)+O(p.length))
     //SC: O(Unique hashes of s.length/p.length) that will be stored in  hashmap=> O(Unique hashes of s.length), because p.length can be 1 
    Use two pointers and then generate hash of all the chucks by iterating over each character once and add the hash to the map along with index;
    Finally return those result whose prime product hash matches the anagram hash. 


*/


import java.util.*;
import java.math.BigInteger;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //TC: O(s.length)+O(p.length)
        //SC: O(Unique hashes of s.length/p.length) that will be stored in  hashmap
        
        List<Integer> result = new ArrayList<>();
        
        if(s==null || s.length()==0 || p==null || p.length()==0) return result;
        
        int sLen = s.length();
        int pLen = p.length();
        int winStart = 0;
        BigInteger primProd = BigInteger.valueOf(1);
        int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73, 79,83,89,97,101};
        Map<BigInteger,List<Integer>> map = new HashMap<>();
        
        
        for(int winEnd=0;winEnd<sLen;winEnd++){
            char ch = s.charAt(winEnd);
            primProd = primProd.multiply(BigInteger.valueOf(prime[ch-'a']));
            
            if(winEnd-winStart+1>=pLen){
               if(!map.containsKey(primProd)){
                 map.put(primProd,new ArrayList<>());   
               }
                
                map.get(primProd).add(winStart);
                char winStartCh = s.charAt(winStart);
                primProd = primProd.divide(BigInteger.valueOf(prime[winStartCh-'a']));
                winStart++;
            }
            
        }
       
        BigInteger hashP = BigInteger.valueOf(1);
        for(char ch:p.toCharArray()){
            hashP = hashP.multiply(BigInteger.valueOf(prime[ch-'a']));
        }
        
       
        return map.containsKey(hashP) ? map.get(hashP) : result;
            
    }
}

