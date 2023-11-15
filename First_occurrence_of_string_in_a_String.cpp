Time - O(m*n)
Space - O()
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0;
        while(i<=m-n){
            if(haystack[i]==needle[0]){
                int k = i;
                int j = 0;
                while(haystack[k]==needle[j]){
                    k++;
                    j++;
                    if(j==n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
};
