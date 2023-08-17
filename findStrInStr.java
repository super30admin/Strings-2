import java.math.BigInteger;
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class findStrInStr {
    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        BigInteger hashNeedle = BigInteger.valueOf(0);
        BigInteger hashHeyStack = BigInteger.valueOf(0);
        BigInteger posFac = BigInteger.valueOf((long)Math.pow(26,n-1));


        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            hashNeedle = hashNeedle.multiply(BigInteger.valueOf(26));
            hashNeedle = hashNeedle.add(BigInteger.valueOf(c-'a'+1));
        }

        for(int i=0; i<m; i++)
        {
            if(i >= n)
            {
                char out = haystack.charAt(i-n);
                BigInteger outHash = posFac.multiply(BigInteger.valueOf(out-'a'+1));
                hashHeyStack = hashHeyStack.subtract(outHash);
            }
            char in = haystack.charAt(i);
            hashHeyStack = hashHeyStack.multiply(BigInteger.valueOf(26));
            hashHeyStack = hashHeyStack.add(BigInteger.valueOf(in-'a'+1));

            if(hashHeyStack.equals(hashNeedle))
                return i-n+1;
        }
        return -1;
    }
}
