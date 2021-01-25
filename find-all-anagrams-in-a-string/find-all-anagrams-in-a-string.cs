public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        IList<int> res = new List<int>();
        int[] chararray = new int[26];
        int i=0,start=0,count=p.Length;
        
        if(s.Length==0) return res;
        if(s.Length < p.Length) return res;
        
        foreach(char c in p)
        {
            chararray[c -'a']++;
        }
        
        while(i<s.Length)
        {
            char ch = s[i];
            if(chararray[ch -'a'] > 0)
            {
                count--;
            }
            chararray[ch -'a']--;
            i++;
            
            while(count==0)
            {
                if(i-start ==p.Length)
                {
                    res.Add(start);
                }
                
                chararray[s[start] -'a']++;
                if(chararray[s[start] -'a']>0)
                {
                    count++;
                }
                start++;
            }
        }
        return res;
        
    }
}
