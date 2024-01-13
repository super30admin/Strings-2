class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();

        if(m<n) return -1;

        int i = 0, j = 0;
        while(i<m-n)
        {
            int k = i;
            while( haystack.at(i) == needle.at(i) )
            {
                k++; j++;
                if(j == n) return i;
            }
            i++;
            j=0;
        }
        return -1;
    }
};