public class problem1 {

    //Time Complexity: 0(n)
    // Space Complexity: 0(n)

    int[] lps;
    public int strStr(String haystack, String needle) {

        int m= haystack.length();
        int n= needle.length();
        this.lps = new int[n];

        int i=0,j=0;
        while (i<m)
        {
            if (haystack.charAt(i) == needle.charAt(j))
            {
                i++;j++;
                if (j==n)
                {
                    return i-j;
                }
            }
            else if (haystack.charAt(i) != needle.charAt(j) && j>0)
            {
                j=lps[j-1];
            }
            else {
                i++;
            }
        }
        return -1;

    }
    private void   lpsCals(String needle) {
        lps[0] = 0;
        int i = 1, j = 0;
        while (i < needle.length())
        {
            if (needle.charAt(i) == needle.charAt(j))
            {
                j++; lps[i]=j; i++;
            } else if (needle.charAt(i) != needle.charAt(j) && j>0) {
                j=lps[j-1];

            }
            else {
                lps[i]=0;
                i++;
            }
        }
        return;


    }
// Time Complexity: o(m*n)
    //brute forec
    public int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        // Edge case: If the needle is empty, return 0
        if (n == 0) return 0;

        // Iterate through the haystack, only up to the point where needle can fit
        int i = 0;
        while (i <= m - n) {
            // Check if the current character in haystack matches the first character in needle
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                int k = i; // Pointer for the current position in haystack
                // Iterate while characters in haystack and needle match
                while (k < m && j < n && haystack.charAt(k) == needle.charAt(j)) {
                    j++;
                    k++;
                    // If the entire needle is found, return the starting index
                    if (j == n) return i;
                }
            }
            i++;
        }
        // If the needle is not found, return -1
        return -1;
    }
    // robin karp (rolling hash technique)
    public int strStr2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int prime= 1000001;
       int posFac=1;

       for (int i=0;i<n;i++)
       {
           posFac =(posFac*26) %prime;
       }
        int pHash=0;

        for (int i=0;i<n;i++)
        {
            char c= needle.charAt(i);
            pHash = (pHash*26+(c-'a' +1))%prime;
        }
        int currHash=0;

        for (int i=0;i<m;i++)
        {
            char in = haystack.charAt(i);
            currHash = (currHash*26+(in-'a'+1))%prime;
            if (i>=n)
            {
                char out  = haystack.charAt(i);
                currHash = (currHash- (posFac *(out-'a'+1)))%prime;
            }
            if (currHash<0)
            {
                currHash+=prime;
            }
            if (currHash==pHash)
            {
                return i-n+1;
            }
        }

        return -1;
    }


}
