class Solution {
public:
    int strStr(string haystack, string needle) {
        int ans = -1; 
        bool flag = false; 

        if(needle.size() > haystack.size()) return -1; 

        for(int i = 0; i < haystack.size(); i++) {
            if(haystack[i] == needle[0]) {
                ans = i; 
                int nexti = i; 
                int j = 0; 
                while(j < needle.size() && i < haystack.size() && haystack[i] == needle[j]) {
                    if(!flag && i != nexti && haystack[i] == needle[0]) {
                        flag = true; 
                        nexti = i; 
                    }
                    i++;
                    j++; 
                }; 
                if(j == needle.size()) return ans;
                ans = -1; 
                if(flag) {
                    i = nexti - 1; 
                    flag = false; 
                } else i = i - 1; 
            }
        }

        return ans;     
    }
};