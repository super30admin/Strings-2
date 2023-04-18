// Time Complexity : O(m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Compute the needle hash using Rabin Karp algorithm. 
 * Use sliding window approach on the haystack and check if both the hash values are equal. 
 * If yes, return the first occurance of the needle in the haystack. 
 * While computing hash, multiply with k and while removing, subtract the elements hash value. 
 * */

public class Problem2 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(); 
        int n = needle.length(); 
        long needleHash = 0l; 
        long haystackHash = 0l; 
        int k = 26; 
        long kh = (long)Math.pow(k,n);
        if( m < n)
            return -1; 
        for(int i = 0; i < n; i++){
            char ch = needle.charAt(i);
            needleHash = needleHash * k + (ch+1-'a');
        }
        for(int i = 0; i < m; i++){
            char in = haystack.charAt(i);
            haystackHash = haystackHash * k + (in+1-'a');
            if(i >= n){
                char out = haystack.charAt(i-n);
                haystackHash = haystackHash - kh * (out+1-'a');
            }
            if(haystackHash == needleHash)
                return i-n+1;
        }
        return -1;
    }
}
