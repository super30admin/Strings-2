
// Time Complexity : O(m+n)
// Space Complexity : O(1) - hashampa contians max 26 charcters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public IList<int> FindAnagrams(string s, string p) {
    
    List<int> result = new List<int>();
    if(s == null || s.Length == 0 || p == null || p.Length == 0 || p.Length > s.Length)
        return result;
    
    Dictionary<char, int> pMap = new Dictionary<char, int>();
    foreach(char ch in p)
    {
        if(pMap.ContainsKey(ch))
            pMap[ch] += 1;
        else
            pMap.Add(ch, 1);
    }
    
    int match = 0;
    for(int i = 0; i < s.Length; i++)
    {
        //incoming character, if exists in hashmap, decrease the count and increase the meatch if count is 0
        char inChar = s[i];
        if(pMap.ContainsKey(inChar))
        {
            int cnt = pMap[inChar];
            cnt--;
            if(cnt == 0)                
                match++;                                    
                        
            pMap[inChar] = cnt;
        }
        
        //outgoing character, if exists in hasmap, increase the count in hasmap, if count becomes 1, derease match by 1
        if(i >= p.Length)
        {
            char outChar = s[i - p.Length];
            if(pMap.ContainsKey(outChar))
            {
                int cnt = pMap[outChar];
                cnt++;
                if(cnt == 1)
                    match--;
            
                pMap[outChar] = cnt;
            }
        }
        
        if(match == pMap.Count)
            result.Add(i - p.Length + 1);
    }
    
    return result;
}