//better - robin karp algo (rolling hash)
//best - kmp algo
// these both algo have better time comp but will work worse here
//this is easy problem so mxn time will work perfectly giving 100%

//time: O(m*n)
//space: O(1)
class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.size();
        int n = needle.size();
        if(n > h) return -1;
        int h1;
        int n1;
        for(int i = 0; i <= h-n; i++) {
            if(haystack[i] == needle[0]) {
                n1 = 1;
                h1 = i+1;
                while(n1 < n && haystack[h1] == needle[n1]) {
                    n1++;
                    h1++;
                }
                if(n1 == n) return i;
            }
        }
        return -1;
    }
};

//rolling hash - needs the use of big integer
/*
class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.size();
        int n = needle.size();
        if(n > h) return -1;
        long long nHash = 0;
        for(char c : needle) {
            nHash = nHash*10 + (c - 'a' + 1);
        }
        int i, j;
        long long hHash = 0;
        for(j = 0; j < n; j++) {
            hHash = hHash*10 + (haystack[j] - 'a' + 1);
        }
        if(hHash == nHash) return 0;
        cout<<nHash<<" "<<hHash<<endl;
        long long mul = pow(10,n-1);
        for(i = 0; i <= h-n; i++) {
            //out
            hHash = hHash - ((haystack[i] - 'a' + 1) * mul);
            //in
            cout<<j<<" ";
            //j++;
            hHash = hHash*10 + (haystack[j] - 'a' + 1);
            cout<<hHash<<endl;
            if(hHash == nHash) return i+1;
            j++;
        }
        return -1;
    }
};
*/