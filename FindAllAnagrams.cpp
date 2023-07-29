class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        map<char,int> pS; 
        map<char,int> sS; 
        map<char, int> matches; 
        vector<int> result; 

        for(int i = 0; i < p.size(); i++) {
            pS[p[i]]++;
        }

        int anagramSize = p.size(); 
        int start = 0; 

        for(int i = 0; i < s.size(); i++) {
            matches[s[i]]++;
            //cout << "start is: " << start << "   end is: " << i << endl; 
            if(i - start + 1 == anagramSize) {
                if(mapsEqual(matches, pS)) {
                    result.push_back(start);
                    cout << "start is: " << start << endl; 
                } 
                matches[s[start]]--;
                if(matches[s[start]] == 0) matches.erase(s[start]);
                start++; 
            }
        }

        return result;            
    }

    bool mapsEqual(map<char,int> matches, map<char,int> pS) {
        for(auto it : matches) {
            if(pS.find(it.first) != pS.end()) {
                if(pS[it.first] != it.second) return false; 
            } else return false;     
        }

        return true; 
    }
};