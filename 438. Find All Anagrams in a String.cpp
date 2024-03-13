class Solution {
public:
    /*
    Time: O(n)
    Space: O(n)

    Use sliding window and maintain frequency
    */
    vector<int> findAnagrams(string s, string p) {
        vector<int> ret;
        if(s.length() < p.length())  return {};
        
        int match = 0;
        vector<int> freq1(26,0);
        vector<int> freq2(26,0);

        for(auto &c: p){
            freq1[c-'a']++;
        }

        //initial freq counting for 0 to p.length() 
        for(int i=0;i<p.length();i++){
            auto &c = s[i];
            freq2[c-'a']++;

            if(freq2[c-'a'] == freq1[c-'a'])  match += freq1[c-'a'];
            if(freq2[c-'a'] == freq1[c-'a'] + 1)  match -= freq1[c-'a'];
        }

        if(match == p.length())  ret.push_back({0});

        //slinding window for p.length() to s.length()
        for(int i=p.length();i<s.length();i++){
            auto &c = s[i];
            freq2[c-'a']++;
            if(freq2[c-'a'] == freq1[c-'a'])  match += freq1[c-'a'];
            if(freq2[c-'a'] == freq1[c-'a'] + 1)  match -= freq1[c-'a'];


            auto &d = s[i-p.length()];
            freq2[d-'a']--;
            if(freq2[d-'a'] == freq1[d-'a'])  match += freq1[d-'a']; 
            if(freq2[d-'a'] == freq1[d-'a']-1)  match -= freq1[d-'a'];                       

            if(match == p.length())  ret.push_back(i-p.length()+1);
        }

        return ret;
    }
};
