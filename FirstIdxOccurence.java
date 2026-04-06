// O(n * m) time, O(1) space
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length();
//         int m = needle.length();

//         int i = 0;
//         int j = 0;

//         while (i <= n-m) {
//             if (haystack.charAt(i) == needle.charAt(j)) {
//                 int k = i;

//                 while (haystack.charAt(k) == needle.charAt(j)) {
//                     k++;
//                     j++;

//                     if (j == m) {
//                         return i;
//                     }
//                 }
//                 j = 0;
//             }
//             i++;
//         }
//         return -1;
//     }
// }

// O(n + m) time, O(1) space
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = haystack.length();
//         int m = needle.length();
//         int prime = 100057;

//         long hashP = 0;

//         long positionFactor = 1;
//         for (int i = 0; i < m; i++) {
//             positionFactor = (positionFactor * 26) % prime;
//         }

//         for (char c : needle.toCharArray()) {
//             hashP = (hashP * 26 + (c - 'a' + 1)) % prime;
//         }

//         long currHash = 0;

//         for (int i = 0; i < n; i++) {
//             char in = haystack.charAt(i);
//             currHash = (currHash * 26 + (in - 'a' + 1)) % prime;

//             if (i >= m) {
//                 char out = haystack.charAt(i - m);
//                 currHash = (currHash - ((out - 'a' + 1) * positionFactor)) % prime;
//             }

//             if (currHash == hashP) {
//                 if (i >= m-1) {
//                     int start = i - m + 1;
//                     if (haystack.substring(start, i+1).equals(needle)) {
//                         return start;
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// }

// KMP O(n + m) time, O(n) space
class Solution {
    int[] lps;
    int n;
    int m;

    public int strStr(String haystack, String needle) {
        m = haystack.length();
        n = needle.length();

        lps = new int[n];
        calcLPS(needle);

        int i = 0;
        int j = 0;

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == n) {
                    return i - j; //starting index in haystack
                }
            }
            else if (haystack.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
            
        }
        return -1;
    }

    private void calcLPS(String needle) {
        int i = 1; //incoming char in suffix window
        int j = 0; //incoming char in prefix window

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else if (needle.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = lps[j-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}