// Time Complexity : O(N) N size of string s
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Get frequency any string in hashmap and traverse other string.
// 2. Store # unique elements n while traversing and increase frequency for that char but remove char before size of fisrt string. 
// 3. If n is equal to current hashmap size(# of unique element considered till that index) store first index & finally return array after traversal


class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        map<char,int> m;
        //s=s+"E";
        for(int i=0;i<p.size();i++){
            m[p[i]]++;
        }
        int mc=0;
        vector<int> ans;
        for(int i=0;i<s.size();i++){
            if(i<p.size()){
                    if(m.find(s[i]) != m.end()){m[s[i]]--;
                        if(m[s[i]]==0){mc++;}}   
            }else{
                if( m.find(s[i-p.size()]) != m.end() ){
                    if(m[s[i-p.size()]] == 0){mc--;}
                    m[s[i-p.size()]]++;
                }
                if( m.find(s[i]) != m.end() ){m[s[i]]--;
                    if(m[s[i]]==0){mc++;}} 
                
            }
            cout<<mc<<'\n';
            if(mc==m.size()){
                ans.push_back(i-p.size()+1);
            }
        }
        return ans;
    }
};