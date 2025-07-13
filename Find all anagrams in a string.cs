/*
  Time complexity: O(n)
  Space complexity: O(1)

*/

public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        Dictionary<char,int> dict = new();
        int match = 0;

        foreach(char c in p)
        {
            if(!dict.ContainsKey(c))
                dict.Add(c,0);
            dict[c]++;
        }
        match = dict.Count;
        List<int> result = new();

        for(int i=0;i<s.Length;i++)
        {
            char incoming = s[i];
            if(dict.ContainsKey(incoming))
            {
                dict[incoming]--;
                if(dict[incoming]==0)
                    match--;
            }

            if(i>=p.Length)
            {
                char outgoing = s[i-p.Length];
                if(dict.ContainsKey(outgoing))
                {
                    dict[outgoing]++;
                    if(dict[outgoing]==1)
                        match++;
                }
            }

            if(match==0)
            {
                result.Add(i-p.Length+1);
            }
        }
        return result;
    }
}
