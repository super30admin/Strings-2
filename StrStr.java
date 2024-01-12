import java.math.BigInteger;

public class StrStr {
//    BruteForce
    public int strStr(String haystack, String needle) {
//        TC:O(m*n)
        int m = haystack.length(); int n = needle.length();
        int j = 0;

        for(int i = 0; i <= m - needle.length(); i++){
            int count = 0;
            j = i + needle.length();
            String st = haystack.substring(i,j);
            for(int k = 0; k < st.length(); k++){
                if(st.charAt(k)==needle.charAt(k)){
                    count++;
                }
                if(count == n)
                    return i;
            }
        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
//        TC:O(m+n)
        int m = haystack.length();
        int n = needle.length();
        if (m < n) return -1;
        BigInteger hashHay = BigInteger.ZERO;
        BigInteger hashNeedle = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(26);
        BigInteger posFac = base.pow(n - 1);

        for (int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            hashNeedle = hashNeedle.multiply(base).add(BigInteger.valueOf(c - 'a' + 1));
        }

        for (int i = 0; i < m; i++) {
            if (i >= n) {
                char out = haystack.charAt(i - n);
                hashHay = hashHay.subtract(BigInteger.valueOf(out - 'a' + 1).multiply(posFac));
            }
            char in = haystack.charAt(i);
            hashHay = hashHay.multiply(base).add(BigInteger.valueOf(in - 'a' + 1));

            if (hashHay.equals(hashNeedle)) {
                return i - n + 1;
            }
        }
        return -1;
    }
}
