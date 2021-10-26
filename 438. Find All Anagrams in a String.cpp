/*
Time Complexity = O(n+m)
Space Complexity = O(n)
where n is the length of the string p and m is the length of the string s.
*/
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        if(p.length()==0)
            return result;
        if(s.length() < p.length())
            return result;
        int i,match=0;
        map<char,int> m;
        for(i=0;i<p.length();i++)
            m[p[i]]++;
        for(i=0;i<s.length();i++)
        {
            if(m.find(s[i])!=m.end())
            {
                int cnt = m[s[i]];
                cnt--;
                if(cnt==0)
                    match++;
                m[s[i]] = cnt;
            }
            if(i>=p.length())
            {
                if(m.find(s[i-p.length()])!=m.end())
                {
                    int cnt = m[s[i-p.length()]];
                    cnt++;
                    if(cnt==1)
                        match--;
                    m[s[i-p.length()]] = cnt;
                }
            }
            if(match==m.size())
                result.push_back(i-p.length()+1);
        }
        return result;
    }
};
