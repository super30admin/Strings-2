//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        map<char,int> m;
        for(int i=0; i<p.size(); i++){
            if(m.find(p[i])==m.end())       m[p[i]]=1;
            else                            m[p[i]]++;
        }
        int match =0;
        
        for(int i=0; i<s.size(); i++){
            if(m.find(s[i])!=m.end()){
                m[s[i]]--;
                if(m[s[i]]==0) match++;
            }
            
            if(i>p.size()-1){
                char outgoing = s[i-p.size()];
                if(m.find(outgoing)!=m.end()){
                    m[outgoing]++;
                    if(m[outgoing]==1)
                        match--;
                }
            }
            
            if(match==m.size()) {
                cout << i-p.size()+1;
                res.push_back(i-p.size()+1);
            }
                
        }
        
        return res;
    }
};