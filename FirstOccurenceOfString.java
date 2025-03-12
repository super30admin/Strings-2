import java.math.BigInteger;
class FirstOccurenceOfString {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();
        if(n>m)
        return -1;
        BigInteger k = BigInteger.valueOf(26);
        BigInteger needleHash = BigInteger.ZERO;
        for(int i=0;i<n;i++)
        {
            char  ch = needle.charAt(i);
            needleHash = needleHash.multiply(k).add(BigInteger.valueOf(ch -'a' +1));
        }
        BigInteger sourceHash = BigInteger.ZERO;
        for(int i=0;i<m;i++)
        {
            //out
            if(i>=n)
            {
                
                sourceHash = sourceHash.mod(k.pow(n-1));
            }
          
            //in
            char in = haystack.charAt(i);
            sourceHash = sourceHash.multiply(k).add(BigInteger.valueOf(in -'a' +1));
            if(sourceHash.equals(needleHash))
            return i-n+1;
        }
        return -1;
    }
}

//Time Complexity (TC): O(m * n)
//Space Complexity (SC): O(m + n)