// Time Complexity : O(n) length of s
// Space Complexity : O(1)  26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// first we create a frequency map and take a match varaible as 0 which will keep track of number of characters matched with pattern string at a point of time.
// now we iterate over the source string while we get an incoming element and if it is in the map we decrease the value and if the value becomes 0 we increment the match
// after the length of the pattern we will be having an outgoing element as well
// for that we need to increase the count of the character (it will be def present in the hashmap) when the count becomes 1 from 0 we need to decerment the match
// at each point we check if the match == map.size if they are equal then we need to return the starting index so we neeed to move 
// legnth of p steps back from i (i-p.length() +1) and add that to the result;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++) 
        {
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match =0;
        for(int i=0;i<n;i++)
        {
            char in = s.charAt(i);
            //in
            if(map.containsKey(in))
            {
                int count = map.get(in)-1;
                map.put(in,count);
                if(count==0)
                {
                    match++;
                }
            }
            //out
            if(i>=m)
            {
                char out = s.charAt(i-m);
                if(map.containsKey(out))
                {
                    int count = map.get(out)+1;
                    map.put(out,count);
                    if(count==1)
                    {
                        match--;
                    }
                }
            }

            if(match == map.size())
            {
                result.add(i-m+1);
            }
        }
        return result;
    }
}