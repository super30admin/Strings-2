// Time Complexity : O(m + n) , m, n are string lengths
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to use Rabin Karp's algorithm by computing hash for both needle and haystack and the index at
which the hashes get equal is the first occurence. To do that, first we compute hash of needle string by having
formula hash = hash*26+incoming char's value. As per problem constraint, it has only 26 letters, so we multiply
with 26.Now, we do the same for haystack string as well, but, we need to do only until needle's length, if it crosses,
we need to push some characters out at the start as kind of sliding window.So, we subtract that outgoing char's
hash by using similar formula but we multiply with position factor of 26^n as it also has contributed to the total sum.
If at any point, hashes become equal, we return i - n +1 index. To handle out of bounds scenario, we use Big Integer
instead of long.
 */
import java.math.BigInteger;
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        BigInteger needleHash = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(26);

        for(char ch : needle.toCharArray()) {
            BigInteger val = BigInteger.valueOf(ch - 'a' + 1);
            needleHash = needleHash.multiply(base).add(val);
        }

        BigInteger hayHash = BigInteger.ZERO;
        BigInteger posFac = base.pow(n);

        for(int i = 0 ; i < m ; i++) {
            char inChar = haystack.charAt(i);
            BigInteger val = BigInteger.valueOf(inChar - 'a' + 1);
            hayHash = hayHash.multiply(base).add(val);

            if(i >= n) {
                char outChar = haystack.charAt(i - n);
                BigInteger outCharVal = BigInteger.valueOf(outChar - 'a' + 1).multiply(posFac);
                hayHash = hayHash.subtract(outCharVal);
            }

            if(needleHash.equals(hayHash))
                return i - n + 1;
        }
        return -1;
    }
}