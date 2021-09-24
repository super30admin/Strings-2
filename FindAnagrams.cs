using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    class FindAnagramsLC
    {
        //TC O(m+n)
        //SC O(n)
        public List<int> FindAnagrams(string s, string p)
        {
            List<int> result = new List<int>();
            if (p == null || p.Length == 0 || s == null || s.Length == 0)
            {
                return result;
            }
            Dictionary<char, int> map = new Dictionary<char, int>();
            int match = 0;
            for (int i = 0; i < p.Length; i++)
            {
                char c = p[i];
                map.Add(c, map.GetValueOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.Length; i++)
            {
                char inVal = s[i];
                if (map.ContainsKey(inVal))
                {
                    int cnt = map[inVal];
                    cnt--;
                    if (cnt == 0)
                    {
                        match++;
                    }
                    map.Add(inVal, cnt);
                }
                if (i >= p.Length)
                {
                    char outVal = p[i - p.Length];
                    if (map.ContainsKey(outVal))
                    {
                        int cnt = map[outVal];
                        cnt++;
                        if (cnt == 1)
                        {
                            match--;
                        }
                        map.Add(outVal, cnt);
                    }
                }
                if (match == map.Count)
                {
                    result.Add(i - p.Length + 1);
                }
            }
            return result;
        }
    }
}
