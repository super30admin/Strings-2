import java.math.BigInteger;
class Solution {
   //TC: O(n)
   //Rolling hash
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        //get the hash of pattern
        for(int i = 0; i < n; i++){
            char in = needle.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));
        }
        
        BigInteger currHash = BigInteger.ZERO;
        //go over source
        for(int i = 0; i<m; i++){
            //out
            if(i >= n){
                //char out = haystack.charAt(i-n);
                //reduce the contributiuon of out character
                currHash = currHash.mod(k.pow(n-1));
            }
        
            char in = haystack.charAt(i);
            currHash = currHash.multiply(k).add(BigInteger.valueOf(in - 'a' + 1));
            if(hash.equals(currHash)){
                return i - n + 1;
            }

        }
        return -1; 
    }
}