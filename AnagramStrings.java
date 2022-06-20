/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> output = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: p.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        int MATCH_COUNT = map.size();
        int PATTERN_LENGTH = p.length();
        int INPUT_LENGTH = s.length();
        
        int i = 0;
        int j = 0;
        
        int matchCount = 0;
        
        while(j < INPUT_LENGTH)
        {
            char incoming = s.charAt(j);
            if(map.containsKey(incoming))
            {
                int prevCount = map.get(incoming);
                prevCount--;
                map.put(incoming, prevCount);
                
                if(prevCount == 0)
                    matchCount++;
                
                
                if(matchCount == MATCH_COUNT)
                    output.add(i);
            }
            
            j++;
            
            if(j-i + 1 > PATTERN_LENGTH)
            {
                // increment i
                char outgoing = s.charAt(i);
                if(map.containsKey(outgoing))
                {
                    int prevCount = map.get(outgoing);
                    prevCount++;
                    map.put(outgoing, prevCount);
                
                    if(prevCount == 1)
                        matchCount--;
                }
                i++;
            }
        }
        
        return output;
        
    }
}