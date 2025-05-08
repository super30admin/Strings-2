//TC:O(n)
//SC: O(1)

/*
This solution uses the Rabin-Karp rolling hash algorithm to find the first occurrence of the
`needle` in the `haystack`. It computes a hash for the `needle` and maintains a rolling hash
for substrings of the `haystack` of the same length. If the hash values match, it does a
 substring comparison to verify the match due to possible hash collisions. The rolling hash
 allows efficient updates in constant time as the window slides. This method is optimized for
 average cases but can degrade to O(m \* n) in the worst case if many hash collisions occur.

* */
class Strstr {
    public int strStr(String haystack, String needle) {

        int m=haystack.length();
        int n= needle.length();



        int pHash=0;

        int prime=101;


        int posFac=1;

        for(int i=0;i<n;i++)
        {
            posFac=(posFac*26)%prime;
        }



        for(int i=0;i<n;i++)
        {
            char c=needle.charAt(i);
            pHash=(pHash * 26 + (c - 'a' + 1)) % prime;
        }
        long currentHash=0;
        for(int i=0;i<m;i++)
        {
            char in=haystack.charAt(i);
            currentHash=(currentHash*26 + (in-'a'+1)) % prime;
            if(i>=n)
            {
                char out=haystack.charAt(i-n);
                currentHash=(currentHash - (posFac * (out - 'a' + 1))) % prime;
            }
            if(currentHash < 0)
                currentHash = currentHash + prime;
            if(currentHash==pHash)
            {
                if(i>=n-1)
                    if(haystack.substring(i-n+1,i+1).equals(needle))
                        return i-n+1;
            }

        }
        return -1;
    }
}