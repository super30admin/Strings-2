// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Brute force approach - TC - O(m*n)
class Solution {
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        if(n > m) return -1;

        for(int i=0;i<= m-n;i++)  {
            for(int j=0;j<m;j++) {
                if(needle.charAt(j) != haystack.charAt(i+j) ) {
                    break;
                }
                if( j == n-1){
                    return i;
                }
            }
        }

        return -1;
    }
}

/**
 *  Robin Karp Rolling Hash Technique
 *  TC - O(m*n)
 */
class Solution {
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        int prm = 101;

        if(n > m) return -1;

        int currHash = 0;
        int posFactor =1;

        for(int i=0;i<n-1;i++) {
            posFactor = (posFactor * 26) % prm;
        }

        // calculate hash on the needle pattern
        int pHash =0;
        for(int i=0;i< n;i++)  {
            char c = needle.charAt(i);
            pHash = (pHash * 26 + (c-'a'+1)) % prm;
        }


        for(int i=0;i< m;i++)  {
            //out
            if(i >= n){
                char out = haystack.charAt(i-n);
                currHash = currHash - (out -'a' +1) * posFactor;
            }

            //in
            char in = haystack.charAt(i);
            currHash = (currHash * 26 + (in-'a'+1)) % prm;

            if(currHash < 0) {
                currHash = currHash + prm;
            }

            if(currHash == pHash) {
                boolean found = true;
                if(i < n-1) {
                    found = false;
                }else{
                    for(int j=0;j<n;j++) {
                        if(needle.charAt(j) != haystack.charAt(i-(n-1)+j)) {
                            found=false;
                            break;
                        }
                    }
                }
                if(found) {
                    return i-n+1;
                }
            }
        }

        return -1;
    }
}