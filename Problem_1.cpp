//Time Comp: O(N)
//Space Comp: O(M)
class Solution {
private:
    vector<int> ls(string needle){
        int sz = needle.size();
        vector<int>lps(sz,0);
        lps[0] = 0;
        int i = 1; int j =0;
        while(i<needle.size()){
            if(needle.at(i) == needle.at(j)){
                j++; lps[i] = j; i++;
            }
            else if(j>0 && needle.at(i) != needle.at(j)){
                j = lps[j-1];
            }
            else if(j==0 && needle.at(i) != needle.at(j)){
                lps[i] = 0; i++;
            }
        }
        return lps;
    }
public:
   int strStr(string haystack, string needle) {
        int m = haystack.size();
        int n = needle.size();
        if(n==0) return 0;
        int i=0; int j=0;
        vector<int> lps = ls(needle);
        while(i<m){
            if(haystack.at(i) == needle.at(j)){
                i++; j++;
            }
            if(j==n) return i-n;
            if(i<m && j>0 && haystack.at(i)!=needle.at(j)){
                j= lps[j-1];
            }
            if(i<m && j==0 && haystack.at(i)!=needle.at(j)){
                i++;
            }
        }
        return -1;
    }

};