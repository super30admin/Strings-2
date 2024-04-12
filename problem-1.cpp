// t-c: n*m
// s-c: 1
class Solution {
public:
    int strStr(string haystack, string needle) {
        long long i = 0, j = 0;
        string match = "";
        while(i < haystack.size() && j < haystack.size())
        {
            match += haystack[j];
            if(j-i == needle.size()-1)
            {
                if(needle == match) return i;
                match.erase(match.begin());
                i++;
            }
            j++;
        }
        return -1;
    }
};
