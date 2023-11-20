public class FindAllAnagramsString
	{
        // Time Complexity : O(n), where n is the length of s string
        // Space Complexity : O(1) - constant space as there could be maximum 26 characters in hashmap
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public IList<int> FindAnagrams(string s, string p)
        {
            IList<int> result = new List<int>();
            Dictionary<char, int> map = new Dictionary<char, int>();
            int n = p.Length;
            int m = s.Length;

            for(int i = 0; i < n; i++)
            {
                char c = p[i];
                if (!map.ContainsKey(c))
                {
                    map.Add(c, 1);
                }
                else
                {
                    map[c] = map[c] + 1;
                }
            }
            int match = 0;

            for(int i = 0; i < m; i++)
            {
                char incoming = s[i];
                //in
                if(map.ContainsKey(incoming))
                {
                    int count = map[incoming] - 1;
                    if(count == 0)
                    {
                        match++;
                    }
                    map[incoming] = count;
                }
                //there is no outgoing character until the window is of length p
                if(i >= n)
                {
                    //out
                    char outgoing = s[i - n];
                    if(map.ContainsKey(outgoing))
                    {
                        int count = map[outgoing];
                        if(count == 1)
                        {
                            match--;
                        }
                        map[outgoing] = count;
                    }
                }

                if(match == map.Count) //length of p or map size
                {
                    result.Add(i - n + 1);
                }
            }

            return result;
        }
    }
