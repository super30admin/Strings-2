Time - O(m+n)
Space - O(1)
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int m = s.length();
        int n = p.length();
        vector<int> result;
        unordered_map<char, int> map;
        for(int i=0;i<n;i++){
            char c= p[i];
            map[c]++;
        }
        int match=0;
        for(int i=0;i<m;i++){
            //incoming char
            char in = s[i];
            if(map.count(in)){
                map[in]--;
                int count = map[in];
                if(count==0){
                    match++;
                }
                map[in]=count;
            }
            //outgoing char
            if(i>=n){
                char out = s[i-n];
                if(map.count(out)){
                    map[out]++;
                    int count =map[out]; 
                    
                    if(count==1){
                        match--;
                    }
                    map[out]=count;
                }
            }
            if(match==map.size()){
                result.push_back(i-n+1);
            }
        }
       return result; 
    }
};
