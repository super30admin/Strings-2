//The idea here is to process only one outgoing and one incoming character as we traverse through the haystack string
//To process this, we use Robin-Karp rolling hash algorithm where find hash of a string in such a way that the hash gives the position of a character in a string
//So we find hash value of haystack and if it is not equal to the hash value of needle, then we subtract the contribution of hashvalue of outgoing character from haystack hash value and add the hashvalue of incoming hash to the haystack hash value
//We repeat this for all substrings as we iterate through the haystack string. If at any index, the hashvalues match, then we return the starting index of the substring, else we return -1 once we complete the iteration.
//Time Complexity:O(m) where m is the length of the haystack
//Space Complexity: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        long k = (long)Math.pow(26, n-1);
        long needleHash = 0;
        for(int i = 0; i<n; i++){
            char ch = needle.charAt(i);
            needleHash = needleHash * 26 + (ch - 'a' + 1); // +1 because we don't want to deal with 0's in hash values
        }

        long sourceHash = 0;
        for(int i = 0; i < m; i++){
            //out
            if(i >= n){
                char out = haystack.charAt(i-n);
                sourceHash = sourceHash - ((out-'a'+1) * k);
            }

            char in = haystack.charAt(i);
            sourceHash = sourceHash * 26 + (in - 'a' + 1);

            if(sourceHash == needleHash){
                return i-n+1;
            }
        }
        return -1;
    }
}