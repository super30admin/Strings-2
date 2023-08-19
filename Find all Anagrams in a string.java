// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will use the sliding window approach here and keep all the characters of the string p in a hashmap with its frequency. The sliding window will be of the size of the length of string p. 
// We will only keep checking the incoming and outgoing characters instead of all the characters in the window. Only when the length of the window becomes equal to the length of string p, we will encounter an outgoing window. 
// We will maintain a match variable to keep a count of matched characters in a window. When the value of match becomes equal to the size of the hashmap, it means we have got an anagram and we will store the index of its starting point in the result. 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int m=p.length(),n=s.length(); int match=0;
        // map to store the characters and their frequencies of string p
        HashMap<Character,Integer> map=new HashMap<>();
       for (int i=0;i<m;i++)
       {
           char c=p.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
       }

        for(int i=0;i<n;i++)
        {
            //incoming
            char in=s.charAt(i);
            if(map.containsKey(in))
            {
                int count=map.get(in);
                count--;
                map.put(in,count);
                if(count==0)
                {
                    match++;
                }
            }
            //outgoing
            if(i>=m)
            {
                char out=s.charAt(i-m);
                if(map.containsKey(out))
                {
                    int count=map.get(out);
                    count++;
                    map.put(out,count);
                    if(count==1)
                    {
                        match--;
                    }
                }
            }
            if(match==map.size())
            {
                result.add(i-m+1);
            }
        }
return result;
    }
}