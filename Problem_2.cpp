438. Find All Anagrams in a String

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;
        unordered_map<char, int> m;
        int match = 0;

        for(int i=0; i< p.size(); i++) {
            if(m.find(p.at(i)) != m.end()) {
                int temp = m.find(p.at(i))->second +1;
                m.erase(p.at(i));
                m.insert({p.at(i), temp});
            } else {
                m.insert({p.at(i), 1});
            }
        }
        //for (auto it = m.begin(); it!= m.end(); it++) {
        //    cout << it->first << it->second << endl;
        //}

        for(int i=0; i< s.size(); i++) {
            char inC = s.at(i);
            //in
            if(m.find(inC) != m.end()) {
                int count = m.find(inC)->second -1;
                m.erase(inC);
                m.insert({inC, count});
                if(count == 0) match++;
            }
            // out
            if(i >= p.size()) {
                char outC = s.at(i-p.size());
                if(m.find(outC) != m.end()) {
                    int count = m.find(outC)->second +1;
                    m.erase(outC);
                    m.insert({outC, count});
                    if(count == 1) match--;
                }
            }
            if(match == m.size()) result.push_back(i-p.size()+1);
        }
        return result;
    }
};
