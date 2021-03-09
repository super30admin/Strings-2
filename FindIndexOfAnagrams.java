// time complexity : O(len(s)+plogp)
// p = length of string p
// space complexity : O(1)
// worked on leetcode : YES

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> li  = new ArrayList();
        
        
        
        if(s == null || p == null || s.length()  == 0 || p.length() == 0 || p.length() > s.length() )           {
            return li;
        }
        
        int left = 0;
        int right ;
        char [] pArr = p.toCharArray();
        // sort char array
        Arrays.sort(pArr);
        String sortedp = String.valueOf(pArr);
       
        for(right = p.length() -1; right < s.length() ; right++ ) {
            String sub = s.substring(left, right+1);
            char [] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = String.valueOf(subArr );
            if(sortedp.equals(sortedSub) ) {
                li.add(left);
            }
            left++;
        
            
        }
        return li;
    }
    
    
  
    
    
}
