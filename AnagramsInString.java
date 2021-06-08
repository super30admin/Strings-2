//Problem : 98 - Find All Anagrams in a String
//TC:  Max(O(s.length)+O(p.length))
//SC: O(1), because hash map will contain only 26 characters

/*
 1) Bruteforce: TC:O(s*p)*O(plogp+O(p))=>O(sp*plogp) , O(p) for comarising elements here s is string 's' length and 'p' is string p length. Acually we are making a chunk of p size thats why O(s*p).
  Iterate over each character of string s and make pairs/chunks of p length. Then sort that chunk and if sorted chunk is equal to the anagram string then just record the starting index.

 2) Optimised : 
     1) Using Sliding window and hashmap. Create frequency map for the anagram string
     Use concept of incoming and outgoing character
     For incomming:
     If incomming character is in map decrease its frequency and if its frequency becomes 0 means we utilised all its occurings, then increment the match count.

     For Outgoing :
     if sliding window size becomes greater than the anagram string length, just check whether the character at winStart is in map or not. If it is in map, just increase its frequency and if its frequency becomes 1 just decrement the match count. In addition, increment the winStart because we have to make our sliding window of size p.length;
     
     
     If match count is equal to the map size, just add the winStart in the result.
 
    2) Using prime product and sliding window
     //TC: Max(O(s.length)+O(p.length))
     //SC: O(Unique hashes of s.length/p.length) that will be stored in  hashmap=> O(Unique hashes of s.length), because p.length can be 1 
    Use two pointers and then generate hash of all the chucks by iterating over each character once and add the hash to the map along with index;
    Finally return those result whose prime product hash matches the anagram hash. 


*/


import java.util.*;
import java.math.BigInteger;
class Solution {
     //Class Solution- Sliding Window
     public List<Integer> findAnagrams(String s, String p) {
        
        //TC: O(s.length)+O(p.length)
        //SC: O(Unique hashes of s.length/p.length) that will be stored in  hashmap
        
        List<Integer> result = new ArrayList<>();
        
        if(s==null || s.length()==0 || p==null || p.length()==0) return result;
        
        
        Map<Character,Integer> map = new HashMap<>();//no need to use map
        
        for(char ch:p.toCharArray()){
           map.put(ch,map.getOrDefault(ch,0)+1);    
        }
        
        int winStart = 0;
        int match =0;
        for(int winEnd=0;winEnd<s.length();winEnd++){
        
            char in = s.charAt(winEnd);
            
            //for incomming
            if(map.containsKey(in)){
               
                int count = map.get(in);
                count--; //because have to utilise it
                if(count==0) match++;
                
                map.put(in,count);
            }
            
            //for outgoing
            //if window size increases
            if(winEnd-winStart+1>p.length()){
                char out = s.charAt(winStart);
                if(map.containsKey(out)){
                    
                    int count = map.get(out);
                    count++;
                    
                    if(count==1) match--;
                    
                    map.put(out,count);
                }
                
                winStart++;//moving start pointer
                
            }
            
            if(match==map.size()) result.add(winStart);
            
        }
        return result;
    }

    //Using Prime Product, can take longer for calculations
    //Here we can ignore map also
    /*
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
            
    }*/
}

