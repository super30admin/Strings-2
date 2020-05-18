// Time Complexity : O(n) wher n is the length of s
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] s_array =  new int[26];
        int[] p_array =  new int[26];
        
        List<Integer> out = new ArrayList<>();
        int start =0,end =0;
        int s_size = s.length();
        int p_size = p.length();
        for(Character c:p.toCharArray())
        {
            p_array[c-'a']+=1;
        }
        while(end<s_size)
        {
            Character c_start = s.charAt(start);
            Character c_end = s.charAt(end);
            int size = end-start+1;
            //case1
            if(size<p_size)
            {
                s_array[c_end-'a']+=1;
                end++;
            }
            //case2
            else if(size==p_size)
            {
                 s_array[c_end-'a']+=1;
                if(compare(s_array,p_array))
                {
                    out.add(start);
                }
                end++;               
                
            }
            //case3
            else
            {
                
                s_array[c_start-'a']-=1;
                start++;
            }
        }
        return out;
    }
    
    private boolean compare(int[] a, int[] b)
    {
        
        for(int i = 0;i<26;i++)
        {
            if(a[i]!=b[i]) return false;
        }
        
        return true;
    }
}class FindAllAnagram {
    
}