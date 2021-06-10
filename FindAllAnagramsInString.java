import java.util.*;
/*Approach: 
1. Form a map of the elements in the pattern string
2. It is importnant to not that the matchCount has been mapped to teh size of the map and not the length of the pattern string 
3. Checking for count==1 is really important. We incremented the matchcount only when the count went to 0. So we should decrement it only when the count is being changes froom 0 to 1
4. i is pointing to the fast pointer and i-p.length() is pointing to the slow pointer
5. the element being left out of the sliding window should change the values and hence the condition at line 38

Time complexity: O(N)
Space complexity: O(pattern length)
*/
class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pattern = new HashMap<>();
        int matchCount = 0; 
        List<Integer> result = new ArrayList<>();
        
        //initilaize a map with counts of elements in the pattern
        for(int i = 0; i<= p.length()-1; i++)
        {
            char c = p.charAt(i);
            pattern.put(c, pattern.getOrDefault(c,0)+1);
        }
        
        //loop through the string using sliding window of length of the pattern string
        for(int i = 0; i<= s.length()-1; i++)
        {
            char c = s.charAt(i);
            if(pattern.containsKey(c))
            {
                int count = pattern.get(c);
                count--;
                pattern.put(c,count);
                if(pattern.get(c)==0)
                     matchCount++;
            }
            
            if(i-p.length()>=0)
            {
                char out = s.charAt(i-p.length());
                if(pattern.containsKey(out))
                {
                    int count = pattern.get(out);
                    count++;
                    pattern.put(out,count);
                    if(count==1)
                        matchCount--;
                }
            }
            
            if(matchCount==pattern.size())
                result.add(i-p.length()+1);
        }
        return result;
    }
}