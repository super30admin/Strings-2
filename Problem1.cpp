// Time Complexity : O(N) N size of string haystack
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Using Rabin-karp algorithm we represent each string with unique number using base-26(hash=hash * 26 + new_char).
// 2. Traverse needle to get hash value than traverse haystack and add each char to hash value also start removing char from hash before current index-length of needle.
// 3. If needle has is equal to current hash value return first occurance(current index - length of needle).

class Solution {
public:
    int strStr(string haystack, string needle) {
        int m=needle.size();
        int n=haystack.size();
        long nhash=0;
        long M= 1000000007;
        long pm = 1;

        for (int i = 0; i < m; i++) {
            pm = (pm * 26) % M;
        }

        for(int i=0;i<m;i++){
            nhash = (nhash*(26)%M) + (needle[i]-'a'+1);
        }
        long mhash=0;
        for(int i=0;i<n;i++){
            mhash = ( (mhash*26) + (haystack[i]-'a'+1) )%M ;
            cout<<mhash<<' ';
            if(i>=(m)){
                mhash= (mhash  - ( pm *(haystack[i-m]-'a'+1) ) )%M ;
            }
            cout<<mhash<<'\n';
            if(mhash<0){mhash= (mhash + M);}
            if( mhash==nhash){
                return (i-m+1);
            }
        }
        return -1;
    }
};