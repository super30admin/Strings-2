//time complexity:O(n^3)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using brute force
//any issues faced? no
//approach 1


class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int>res;
        for(int i=0; i<s.size(); i++)
        {
            for(int j=i+1; j<=s.size(); j++)
            {
                if(isanagram(p,s,i,j))
                {
                    res.push_back(i);
                }
            }
        }
        return res;
    }
    bool isanagram(string p, string s, int start, int end)
    {
        
        string tmp="";
        for(int i=start; i<end; i++)
        {
            tmp+=s[i];
        }
        sort(p.begin(),p.end());
        sort(tmp.begin(),tmp.end());
        if(p==tmp)
            return true;
        else
            return false;
    }


    //approach 2
    //time: O(n+m)
    //space: O(1)
        
        vector<int>res;
        map<char,int>smap;
        map<char,int>pmap;
        int ssize=s.size();
        int psize=p.size();
        for(char ch:p)
            pmap[ch]++;
        for(int i=0; i<ssize; i++)
        {
            smap[s[i]]++;
            if(i>=psize)
            {
                char ch=s[i-psize];
                if(smap[ch]==1)
                    smap.erase(ch);
                else
                {
                    smap[ch]--;
                }
            }
            if(smap==pmap)
                res.push_back(i-psize+1);
        }
        return res;
    }
};