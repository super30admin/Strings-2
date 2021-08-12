// Time Complexity : o(m+n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result=new ArrayList<>();
        
        if(s==null||s.length()==0||p.length()>s.length())
            return result;
        
        Map<Character,Integer> map=new HashMap<>();
        
        //getting pattern character counts.
        for(int i=0;i<p.length();i++)
        {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        
        int n=p.length();
        int match=0;
        
        for(int i=0;i<s.length();i++)
        {
            //in character
            char in=s.charAt(i);
            
            if(map.containsKey(in))
            {
                //decrement count
                map.put(in,map.get(in)-1);
                
                //character count exists in window
                if(map.get(in)==0)
                    match++;
                
            }
            
            //outgoing character
            if(i>=p.length())
            {
                char out=s.charAt(i-p.length());
                
                if(map.containsKey(out))
                {
                    map.put(out,map.get(out)+1);
                    
                    // character count not exsiting in window
                    
                    if(map.get(out)==1)
                        match--;
                }
            }
            // valid anagrams
            if(match==map.size())
                result.add(i-p.length()+1); // starting index of window
        }
        return result;
    }
}