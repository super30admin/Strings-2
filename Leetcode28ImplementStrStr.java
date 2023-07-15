// class Solution {
//     public int strStr(String haystack, String needle) {
//         int m = haystack.length();
//         int n = needle.length();
//         if(m<n) return -1;
//         long needleHash = 0;
//         long k = 26l;
//         long kn = (long)Math.pow(k,n);
//         for(int i=0;i<n;i++){
//             char c = needle.charAt(i);
//             needleHash = needleHash*k +(c-'a'+1);
//         }
//         long currHash = 0;
//         for(int i=0;i<m;i++){
//             // in
//             char in = haystack.charAt(i);
//             currHash = currHash*k +(in -'a' +1);
//             if(i>=n){
//                 char out = haystack.charAt(i-n);
//                 currHash = currHash - (out - 'a' + 1)*kn;
//             }
//             if(currHash == needleHash){
//                 return i - n + 1;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(); int n = needle.length();
        long k = 26l;
        long target = 0;
        for(int i=0;i<n;i++){ 
            char c = needle.charAt(i); 
            target = target*k + (c - 'a' + 1);
        }
        long res = 0;
        long temp = (long)Math.pow(k,n);
        for(int i=0;i<m;i++){
            // incoming
            char in = haystack.charAt(i);
            res = res*k + (in - 'a' + 1);
            // outgoing
            if(i>=n){
                char out = haystack.charAt(i-n);
                res = res - (out - 'a' + 1) *temp;
            }
            if(res == target) return i-n+1;
        }
        return -1;
    }
}

// class Solution {
//     public int strStr(String haystack, String needle) {
//         int m = haystack.length(); int n = needle.length();
//         int i = 0;
//         while(i < m-n+1){
//             int k = i; int j = 0;
//             while(haystack.charAt(k) == needle.charAt(j)){
//                 if(j == n-1) return i;
//                 k++; j++;
//             }
//             i++;
//         }
//         return -1;
//     }
// }