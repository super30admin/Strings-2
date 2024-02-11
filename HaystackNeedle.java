import java.math.BigInteger;
// tc: o(n), sc: o(1)
class HaystackNeedle {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        BigInteger hash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);
        for(int i=0;i<n;i++){
            char c = needle.charAt(i);
            hash = hash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
        }
        BigInteger currHash = BigInteger.ZERO;
        for(int i=0;i<m;i++){
            //out

            if(i>=n){
                currHash = currHash.mod(k.pow(n-1)); // - (out-'a'+1)*kl;
            }
            //in
            char c = haystack.charAt(i);
            currHash = currHash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
            if(currHash.equals(hash)){
                return i-n+1;
            }
        }
        return -1;
    }
}
