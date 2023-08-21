//time O(s+p);
//Space O(p);

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        //time O(s+p);
        //Space O(p);
        vector<int> result;
        unordered_map<char,int> map;
        for(int i=0;i<p.size();i++){
            char a = p[i];
            if(map.find(a)!=map.end()){
                map[a]++;
            }
            else{
                map[a]=1;
            }
        }

        int match=0;

        for(int i=0;i<s.size();i++){
            //incoming
            if(map.find(s[i])!=map.end()){
                map[s[i]]--;
                if(map[s[i]]==0){
                    match++;
                }
            }

            //outgoing

            if(i>=p.size()){
                char out = s[i-p.size()];
                if(map.find(out)!=map.end()){
                    map[out]++;
                    if(map[out]==1){
                    match--;
                }
                }
                

            }
            if (match==map.size()){
                result.push_back(i-p.size()+1);
            }
        }

        return result;

        
        
    }
};