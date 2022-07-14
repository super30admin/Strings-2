//Time Complexity- O(s.length+p.length)
//Space Complexity- O(1)

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        if(p.size()>s.size()){
            return {};
        }
        
        unordered_map<char,int> mps;
        unordered_map<char,int> mpp;
        
        for(char ch:p){
            mpp[ch]++;
        }
        
        vector<int> ans; 
        for(int i=0;i<p.size();i++){
            mps[s[i]]++;
        }
        
        for(int i=p.size();i<s.size();i++){
            if(mpp==mps){
                ans.push_back(i-p.size());
            }
            mps[s[i-p.size()]]--;
            if(mps[s[i-p.size()]]==0){
                mps.erase(s[i-p.size()]);
            }
            mps[s[i]]++;
        }
        if(mpp==mps){
            ans.push_back(s.size()-p.size());
        }
        return ans;
    }
};