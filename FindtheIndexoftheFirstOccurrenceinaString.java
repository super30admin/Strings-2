import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if(n > m) return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        for(int i = 0; i < n; i++){
            char c = needle.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(c-'a' + 1));
        }
        BigInteger hash2 = BigInteger.ZERO;
        for(int i = 0; i < m; i++){
            if(i >= n){
                hash2 = hash2.mod(k.pow(n-1));
            }
            char b = haystack.charAt(i);
            hash2 = hash2.multiply(k).add(BigInteger.valueOf(b -'a' + 1));
            if(hash.equals(hash2)) return i - n +1;
        }
        return -1;
    }
}
