// t-c: s
// s-c: 1
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> alphabets = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        long long int  match = 1;
        vector<int> result;
        for(long long int i = 0; i < p.size(); i++)
            match = (match + ( int(p[i]) * (alphabets[p[i] - 'a'])));
        
        long long int i = 0, j = 0, pp = 1;
        while(i < s.size() && j < s.size())
        {
            pp = (pp + ( int(s[j]) * alphabets[s[j] - 'a']));
            if(j-i == p.size()-1)
            {
                if(match == pp)
                    result.push_back(i);
                pp -= (int(s[i]) * alphabets[s[i] - 'a']);
                i++;
            }
            j++;
        }
        return result;
    }
};
