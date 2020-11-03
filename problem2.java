// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 6ms

// Your code here along with comments explaining your approach

// Check the frequency and then sliding through the string, check if the array is equal

class Solution {
    public List findAnagrams(String s, String p) {
    
       int freq1[] = new int[26];
       int freq2[] = new int[26];
        
        List<Integer> list = new ArrayList<>();
        
        if(s.length()<p.length())
            return list;
        
        for(int i=0; i<p.length(); i++){
            freq1[s.charAt(i)-'a']++;
            freq2[p.charAt(i)-'a']++;
        }
     
        int start=0;
        
        int end=p.length();
        
        if(Arrays.equals(freq1,freq2))
            list.add(start);
        
        while(end<s.length()){
            
            freq1[s.charAt(start)-'a']--;
            freq1[s.charAt(end)-'a']++;
            
            if(Arrays.equals(freq1,freq2))
                list.add(start+1);
            
            start++;
            end++;
        }
      return list;  
    }
    }