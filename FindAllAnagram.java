// Time Complexity: O(n + m) n is length of s, m is length of p
// Space Complexit: O(m) - > o(1) since max 25 unique chars
public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p == null || p.length() == 0 || s == null || s.length() == 0)
            return result;
        
        // we need hashmap to save the counts of the characters
        Map<Character, Integer> map = new HashMap<>();
        // convert the pattern into a hashmap to know the count of chars need for anagram
        for(char c : p.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // parse the string and start updating the count of characters that are part of anagram only
        int matchChar = 0;
        int slow = 0;
        for(int fast = 0 ;fast < s.length(); fast++)
        {
            char inChar = s.charAt(fast);
            // keep adding chars to map till you create a window of length p
            if(map.containsKey(inChar))
            {
                int count = map.get(inChar);
                // update count as one char seen not sure if it is a part of anagram
                count --;
                // when char count == 0 means found matching char of anagram
                if(count == 0)
                {
                    matchChar++;
                }
                // update map with count
                map.put(inChar, count);
            }
            //when window is greater than p remove char from start to add new window
            if(fast >= p.length())
            {
                // remove the beginning c har of the window
                char outChar = s.charAt(slow++);
                // update map by increasing the count back since this char is no longer in our window
                if(map.containsKey(outChar))
                {
                    int count = map.get(outChar);
                    // update count
                    count++;
                    // when char count == 1 means removing matched char of anagram
                    if(count == 1)
                    {
                        matchChar--;
                    }
                    // update map with count
                    map.put(outChar, count);
                }
            }
            // when we found one anagram add to result
            if(matchChar == map.size())
            {
                result.add(slow); 
            }
        }
        
        return result;
}