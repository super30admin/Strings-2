// This solution uses robin-karp algorithm to calculate the running hashes of the strings and spot the matched string
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0, j=0;
        int n = needle.length();

        // Calculate hash of needle
        long hash = 0;
        // Use prime value to hash the range so that there are not overflows
        long prime = 100001;
        for(char c:needle.toCharArray()) {
            hash = (hash*26%prime+(c-'a'+1))%prime;
        }

        // Calculate the power of 26 for eliminating the outgoing character from the running hash
        long pow = 1;
        for(i = 0; i < n-1; i++){
            pow = (pow * 26) % prime;
        }

        long runningHash = 0;
        i=0;
        // Iterate over the haystack with a sliding window of needle length and keep comparing with needle
        while(i<haystack.length()) {
            if(i>=n) {
                int out = i-n;
                runningHash = (runningHash - ((haystack.charAt(out)-'a'+1)*pow)) % prime;
            }

            // At any point if we get into negative range, add prime to push it back to the positive range
            if(runningHash < 0) runningHash = runningHash + prime;
            char c = haystack.charAt(i);
            runningHash = ((runningHash*26)+(c-'a'+1))%prime;

            // If hash is same also make sure the sub strings are same because of hash collisions
            if(runningHash==hash) {
                int l = i-n+1;
                if(haystack.substring(l, i+1).equals(needle)) return l;
            }
            i++;
        }
        return -1;
    }
}
