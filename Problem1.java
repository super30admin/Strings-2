
// Time Complexity: O(m + n) where m is the length of haystack and n is the length of needle
// Space Complexity: O(1)


// We will use Rabin Karp algorithm to find the first occurrence of needle in haystack
// We will calculate the hash value of needle and the hash value of the first n characters of haystack
// We will then slide the window over haystack and update the hash value of the current window
// We use a prime number to avoid collisions
// If the hash values match, we will check the actual substring to avoid false positives
// If we find a match, we return the starting index of the match


class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        long pHash = 0;
        int prime = 100001;
        long posFac = 1;

        for(int i = 0; i < n; i++){
            posFac = (posFac * 26) % prime;
        }

        for(int i = 0; i < n; i++){
            char c = needle.charAt(i);
            pHash = (pHash * 26 + (c - 'a' + 1)) % prime;
        }

        long currHash = 0;

        for(int i = 0; i < m; i++){
            char in = haystack.charAt(i);
            currHash = (currHash * 26 + (in - 'a' + 1)) % prime;

            if(i >= n){
                char out = haystack.charAt(i - n);
                currHash = (currHash - (posFac * (out - 'a' + 1)) % prime) % prime;
            }

            // To handle negative values
            if(currHash < 0) currHash = currHash + prime;

            if(currHash == pHash) {
                if(i >= n - 1){
                    if(haystack.substring(i - n + 1, i + 1).equals(needle)) { 
                        return i - n + 1;
                    }
                }
            }
        }

        return -1;
    }
}
