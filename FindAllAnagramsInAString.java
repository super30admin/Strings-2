// Time Complexity : O(n + m) where n is length of s and m is lenght of p 
// Space Complexity : O(1) as hashmap would never conatin entries more than 26
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach



class Solution {
 
    public List<Integer> findAnagrams(String s, String p) {
      
      HashMap<Character,Integer> pMap = new HashMap<>();
    
      List<Integer> output = new ArrayList<>();
      //populate the hashmap with characters and their occurences in p
      for(int i=0;i<p.length();i++)
      { 
        char a = p.charAt(i);
        if(pMap.containsKey(a))
        {
          pMap.put(a,pMap.get(a)+1);
        }
        else
        {
          pMap.put(a,1);
        }
      } 
      int l = 0;
      int r = 0;
      int count = 0;

      while(r< s.length())
      {
        int window = r - l + 1;
        char c = s.charAt(r);
        if(pMap.containsKey(c))
        {
          //decrement the frequency in hashmap for that character
          pMap.put(c,pMap.get(c)-1);
          //count incremented to compare with the size of hashmapin later parts
          if(pMap.get(c)==0)
          {
            count++;
          }
        }
        
        if(window > p.length())
        {

          char outL = s.charAt(l);
          if(pMap.containsKey(outL))
          {
            pMap.put(outL,pMap.get(outL)+1);
            
            if(pMap.get(outL)==1)
            {
              count--;
            }
          }
          l++;
        }
        //add to output the start index when we have found anagram
        if(count==pMap.size())
        {
          output.add(l);
        }
        r++;
      }
      return output;
    }
  
}