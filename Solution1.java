// Time Compexity: O(m) + O(n)
// Space Complexity: O(1)

// This code fails for this specific test case on LeetCode
// I think it is becasue of overflow problem

// haystack = "fourscoreandsevenyearsagoourfathersbroughtforthuponthiscontinentanewnation"
// needle = "ourfathersbroughtforthuponthiscontinentanewnation"


class Solution1 {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if( n > m ) return -1;
        long k = 26;
        long kn = (long)Math.pow(k, n);
        long needleHash = 0l;
        for(int i = 0; i < n; i++) {
            char ch = needle.charAt(i);
            needleHash = needleHash*k + (ch+1-'a');
        }
        double haystackHash = 0;
        for(int i = 0; i < m; i++) {
            //in
            char in = haystack.charAt(i);
            haystackHash = haystackHash*k + ( in + 1 - 'a');
            if( i >= n) {
                char out = haystack.charAt(i-n);
                haystackHash = haystackHash - kn*(out+1-'a');
            }
            if( haystackHash == needleHash ) {
                return (i-n+1);
            }
        }
        return -1;
    }
}