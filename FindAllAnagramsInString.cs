// time complexity - O(m+n)
// SpaceComplexity - O(1)
public class Solution
{
    public IList<int> FindAnagrams(string s, string p)
    {
        if (s.Length == 0 || p.Length == 0 || s.Length < p.Length)
        {
            return new List<int>();
        }
        Dictionary<char, int> dict = new Dictionary<char, int>();
        int charCount = 0;
        List<int> res = new List<int>();
        foreach (char ch in p)
        {
            if (dict.ContainsKey(ch))
            {
                dict[ch]++;
            }
            else
            {
                dict.Add(ch, 1);
            }
        }
        int j = 0;
        for (int i = 0; i < s.Length; i++)
        {
            if (dict.ContainsKey(s[i]))
            {
                dict[s[i]]--;
                if (dict[s[i]] == 0)
                {
                    charCount++;
                }
            }
            if (i >= p.Length)
            {
                if (dict.ContainsKey(s[j]))
                {
                    dict[s[j]]++;
                    if (dict[s[j]] == 1)
                    {
                        charCount--;
                    }
                }
                j++;
            }
            if (charCount == dict.Count())
            {
                res.Add(j);
            }
        }
        return res;
    }
}