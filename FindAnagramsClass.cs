// TC => O(n)
// SC => O(1)

public class Solution
{
    public IList<int> FindAnagrams(string s, string p)
    {
        IList<int> result = new List<int>();
        if (p == null || p.Length == 0)
        {
            return result;
        }
        int match = 0;
        Dictionary<char, int> lookup = new Dictionary<char, int>();
        for (int i = 0; i < p.Length; i++)
        {
            lookup.TryAdd(p[i], 0);
            lookup[p[i]]++;
        }
        for (int i = 0; i < s.Length; i++)
        {
            var incoming = s[i];
            if (lookup.ContainsKey(incoming))
            {
                var count = lookup[incoming];
                count--;
                if (count == 0)
                {
                    match++;
                }
                lookup[incoming] = count;
            }
            if (i >= p.Length)
            {
                var outgoing = s[i - p.Length];
                if (lookup.ContainsKey(outgoing))
                {
                    var count = lookup[outgoing];
                    count++;
                    if (count == 1)
                    {
                        match--;
                    }
                    lookup[outgoing] = count;
                }
            }
            if (match == lookup.Count)
            {
                result.Add(i - p.Length + 1);
            }
        }
        return result;
    }
}