/*
Time Complexity = O(m*n)
Space Complexity = O(1)
where m is the length of the haystack and n is the length of the needle.
*/
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length()==0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        if(m<n)
            return -1;
        int i,j,k;
        for(i=0;i<m-n+1;i++)
        {
            j=i;
            k=0;
            while(k<m)
            {
                if(haystack[j]==needle[k]){
                    j++;
                    k++;
                }
                else
                    break;
                if(k==n)
                    return j-k;
            }
        }
        return -1;
    }
};


/*
Time Complexity = O(m+n)
Space Complexity = O(n)
where m is the length of the haystack and n is the length of the needle.
KMP Algorithm.
*/
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length()==0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        int i=1,j=0;
        vector<int> lps(n,0);
        //computing the lps array for needle string.
        while(i<n)
        {
            if(needle[i]==needle[j]){
                j++;
                lps[i]=j;
                i++;
            }
            else if(needle[i]!=needle[j] && j>0)
                j = lps[j-1];
            else
            {
                lps[i]=0;
                i++;
            }
        }
        //logic
        i=0,j=0;
        while(i<m){
            if(needle[j]==haystack[i]){
                j++;
                i++;
                if(j==n) return i-n;
            }
            else if(needle[j]!=haystack[i] && j>0)
                j = lps[j-1];
            else{
                i++;
            }
        }
        return -1;
    }
};
