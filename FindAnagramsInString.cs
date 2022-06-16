using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class FindAnagramsInString
    {
        /// Time Complexity : O(n) 
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public IList<int> FindAnagrams(string s, string p)
        {
            List<int> result = new List<int>();
            if (p.Length > s.Length) return result;
            int match = 0;
            Dictionary<char, int> map = new Dictionary<char, int>();
            for (int i = 0; i < p.Length; i++)
            {
                map.Add(p.ToCharArray()[i], map.GetValueOrDefault(p.ToCharArray()[i]) + 1);
            }

            for (int j = 0; j < s.Length; j++)
            {
                char charIn = s.ToCharArray()[j];

                if (map.ContainsKey(charIn))
                {
                    int count = map.GetValueOrDefault(charIn);
                    count--;
                    map[charIn] = count;
                    if (count == 0)
                    {
                        match++;
                    }
                }
                if (j >= p.Length)
                {
                    char charOut = s.ToCharArray()[j - p.Length];
                    if (map.ContainsKey(charOut))
                    {
                        int count = map.GetValueOrDefault(charOut);
                        count++;
                        map[charOut] = count;
                        if (count == 1)
                        {
                            match--;
                        }
                    }

                }
                if (match == map.Count())
                {
                    result.Add(j - p.Length + 1);
                }
            }
            return result;
        }
    }
}
