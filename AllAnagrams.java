// Time Complexity : O(length of s)
// Space Complexity : O(length of p)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    //use sliding window
    //anagrams have same freq hashmap

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList();

        //freq map for anagrams
        HashMap<Character, Integer> map = new HashMap();

        for(int i=0; i<p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int matches = 0;

        for(int i=0; i<s.length(); i++)
        {
            //incoming char
            char inc = s.charAt(i);
            //if map contains this char, decrese freq (used up in matching)
            if(map.containsKey(inc))
            {
                map.put(inc, map.get(inc)-1);
                //if freq becomes 0, we found the match for our anagram
                if(map.get(inc) == 0)
                    matches++;
            }

            //outgoing char only when window size is equal to p len
            if(i>=p.length())
            {
                char outc = s.charAt(i-p.length());
                //if map contains this char, increase freq (not being used to match anymore)
                if(map.containsKey(outc))
                {
                    map.put(outc, map.get(outc)+1);
                    //if freq bcomes 1, decrement match count, we needed this char for anagram
                    if(map.get(outc) == 1)
                        matches--;
                }
            }

            //if matches become equal to number of unique chars(all chars and their freq matched), we found an anagram
            if(matches == map.size())
                result.add(i - p.length() + 1);
        }
        return result;
    }
}
