//Leetcode: 438. Find All Anagrams in a String
//Time Complexity: O(max(m,n)) // m is the length of s and n is the length of p
//space Complexity: O(1) // List is an auxillary space while hashmap will be of at max 26 size.
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s==null || p==null || s.length()<p.length()) return res;
        HashMap<Character,Integer> hs= new HashMap<>();
        int i=0;
        while(i<p.length()){
            hs.put(p.charAt(i), hs.getOrDefault(p.charAt(i),0)+1);
            i++;
        }
        int low=0;
        int j=0;
        int match=0;
        while(j<s.length()){
            if(j<p.length()){       
                if(hs.containsKey(s.charAt(j))){                   
                   hs.put(s.charAt(j),hs.get(s.charAt(j))-1);
                    if(hs.get(s.charAt(j))==0) match++;
                }               
            }
            else{
                 low++;     
                 char c=s.charAt(low-1);
                 if(hs.containsKey(c) ){
                       hs.put(c,hs.get(c)+1);   
                      if(hs.get(c)==1) match--;
                } 
                if(hs.containsKey(s.charAt(j))){
                    hs.put(s.charAt(j),hs.get(s.charAt(j))-1);
                    if(hs.get(s.charAt(j))==0) match++;     
                } 
             }
              j++;
              if(hs.size()==match){
                    res.add(low);
                }
        }        
        return res;
        
    }
}