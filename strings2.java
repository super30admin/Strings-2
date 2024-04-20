## Problem1 
//Implement strStr() (https://leetcode.com/problems/implement-strstr/)

// Time Complexity : O(n)
// Space Complexity : 0(1) 
// Did this code successfully run on Leetcode : yes

class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        while(i<haystack.length())
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                j++;
            }
            else
            {
                i=i-j;
                j=0;
            }
            i++;
            if(j==needle.length())
                return (i-j);
        }
        return -1;
    }
}


## Problem2 

//Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)


// Time Complexity : O(n)   n=s.length()
// Space Complexity : 0(1)  two hashmaps with contant size
// Did this code successfully run on Leetcode : yes

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if (s.length()<p.length()){
            return res;
        }
        HashMap<Character,Integer> pmap=new HashMap<>();
        HashMap<Character,Integer> smap=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }
        for(int i=0;i<p.length();i++)
        {
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        if(smap.equals(pmap))
            res.add(0);
        for(int i=p.length();i<s.length();i++)
        {
            char newc=s.charAt(i);
            char oldc=s.charAt(i-p.length());
            if(smap.get(oldc)==1)
            {
                smap.remove(oldc);
            }
            else
            {
                smap.put(oldc,smap.get(oldc)-1);
            }
            smap.put(newc,smap.getOrDefault(newc,0)+1);
            if(smap.equals(pmap))
                res.add(i-p.length()+1);
        }
        return res;
    }
}


