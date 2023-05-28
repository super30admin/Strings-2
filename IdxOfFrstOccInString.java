//LeetCode - 28
//TimeComplexity - O(M+N)
//Space Complexity - O(1)
public class IdxOfFrstOccInString {

    //Rabin-Karp algorithm O(M+N)
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return -1;
        long needleHash = 0l;
        int k = 26;
        long kn = (long)Math.pow(k, n);
        for(int i=0; i<n;i++) {
            char ch = needle.charAt(i);
            needleHash = needleHash * k + (ch + 1 - 'a');
        }
        long haystackHash = 0l;
        for(int i=0;i<m;i++) {
            //in
            char in = haystack.charAt(i);
            haystackHash = haystackHash * k + (in + 1 - 'a');
            //out
            if(i >= n) {
                char out = haystack.charAt(i - n);
                haystackHash  = haystackHash - kn*(out +1 - 'a');
            }
            if(haystackHash == needleHash) {
                return i-n+1;
            }
        }
        return -1;
    }


    //Brute-force O(m*n)
    /*public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0; // pivot pointer for haystack

        while(i <= m-n) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int k=i;//pointer for moving on haystack
                int j =0; //pointer for needle
                while(haystack.charAt(k) == needle.charAt(j)) {
                    k++;j++;
                    if(j==n) {
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }*/
}
