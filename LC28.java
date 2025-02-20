// Approach 1: Rabin Karp
// TC: O(m+n)
// SC: O(1)
public class LC28 {
    // private final int MOD = 1000000007;
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        int hashValue = 0;
        int multiplier = 1;
        // HashValue of needle
        for(int i=n-1;i>=0;i--){
            hashValue += (needle.charAt(i)-96) * multiplier;
            multiplier *= 26;
        }
        int floatingHashValue = 0;
        multiplier = 1;
        for(int i=n-1;i>=0;i--){
            floatingHashValue += (haystack.charAt(i)-96) * multiplier;
            if(i>0) multiplier *= 26;
        }
        if(floatingHashValue == hashValue) return 0;
        for(int i=n;i<m;i++){
            int idxToRemove = i - n;
            floatingHashValue -= (haystack.charAt(idxToRemove)-96) * multiplier;
            floatingHashValue *= 26;
            floatingHashValue += (haystack.charAt(i)-96);
            if(floatingHashValue == hashValue) return idxToRemove+1;
        }
        return -1;
    }
}


// Approach 2: KMP
// TC: O(m+n)
// SC: O(m+n)
class LC28_1 {
    private int[] buildLPSArray(String s) {
        int n = s.length();
        int lps[] = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = lps[i - 1];
            while (s.charAt(x) != s.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m)
            return -1;
        int[] lps = buildLPSArray(needle + "$" + haystack);
        for (int i = 0; i <= m + n; i++) {
            if (lps[i] == n)
                return i - (2 * n);
        }
        return -1;
    }
}