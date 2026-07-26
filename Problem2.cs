// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
1. Create a frequency map of all characters present in p. 
2. Start iterating through characters of s, if frequency map contains ith character of s, decrement frequency map value of that character by 1. If frequency map value of the character becomes 0, 
    increment match by 1. 
3. When i becomes greater or equal to p's length, remove the character from i-p.Length index. If the character is present in the map, increment it's value by 1. If it's value becomes equal to 1, 
    decrement match by 1.
4. If match becomes equal to size of frequencyMap(total number of keys), then record i-(p.Length + 1) index in result.
*/

public class Solution
{
    public IList<int> FindAnagrams(string s, string p)
    {
        Dictionary<char, int> frequencyMap = new();
        int match = 0;
        List<int> result = new();

        for (int i = 0; i < p.Length; i++)
        {
            frequencyMap[p[i]] = frequencyMap.GetValueOrDefault(p[i], 0) + 1;
        }

        for (int i = 0; i < s.Length; i++)
        {
            // Incoming character
            if (frequencyMap.ContainsKey(s[i]))
            {
                frequencyMap[s[i]] -= 1;
                if (frequencyMap[s[i]] == 0)
                {
                    match++;
                }
            }

            // Outgoing character
            if (i >= p.Length)
            {
                if (frequencyMap.ContainsKey(s[i - p.Length]))
                {
                    frequencyMap[s[i - p.Length]] += 1;
                    if (frequencyMap[s[i - p.Length]] == 1)
                    {
                        match--;
                    }
                }
            }

            if (match == frequencyMap.Count)
            {
                result.Add(i - (p.Length - 1));
            }
        }

        return result;
    }
}