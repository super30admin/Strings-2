// //two pointer
// //one at haystack, another at needle
// //TC = O(n * m), where n is length of needle, m is length of haystack
// //SC = 
// class Solution {
//     public int strStr(String haystack, String needle) {
//         //int j = 0; //pointer for needle
//         int n = needle.length();

//         int i = 0; //pointer for haystack
//         int m = haystack.length();
//         while(i <= m-n){
//             if(haystack.charAt(i) == needle.charAt(0)){
//                 int k = i; //k is for iterating over haystack
//                 int j = 0;
//                 while(haystack.charAt(k) == needle.charAt(j)){
//                     k++;
//                     j++;
//                     if(j==n){
//                         return i;
//                     }
//                 }
//             }
//             i++;
//         }
//         return -1;
//     }
// }


// //Sliding window with hashing
// //Sum or product will not work for hash
// //hash = 10*(earlier hash value) + value of element from hashmap
// //Robin-Karp Algorithm = Rolling Hash Algorithm
// //TC = O(n + m), where n is length of needle, m is length of haystack
// //SC = O(1)
// import java.math.BigInteger;
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = needle.length();
//         int m = haystack.length();
//         if(n>m) return -1;
//         BigInteger hashP = BigInteger.ZERO; //hashOfP
//         BigInteger k = BigInteger.valueOf(26); //26
//         for(int i =0; i<n; i++){
//             char c = needle.charAt(i);
//             //hashP = hashP*26 + (c - 'a' + 1)
//             hashP = hashP.multiply(k).add(BigInteger.valueOf(c-'a'+1));
//         }
//         BigInteger hash2 = BigInteger.ZERO; //source
//         for(int i =0; i<m; i++){
//             if(i>=n){ //Out
//                 hash2 = hash2.mod(k.pow(n-1)); //reducing contribution of outgoing
//             }
//             char b = haystack.charAt(i); //in
//             hash2 = hash2.multiply(k).add(BigInteger.valueOf(b-'a'+1));
//             if(hashP.equals(hash2)) return i-n+1;
//         }
//         return -1;
//     }
// }

//KMP algo
// Time: O(n + m) where n = needle.length() and m = haystack.length()
// 	•	O(n) for building LPS array
// 	•	O(m) for scanning haystack
// Space: O(n) for the LPS array
class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        int [] lps = lps(needle);
        int i=0; //haystack ptr
        int j=0; //needle ptr
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++; j++;
                if(j==n){
                    return i-n;
                }
            }else if(haystack.charAt(i)!=needle.charAt(j) && j>0){
                j=lps[j-1];
            }else if(haystack.charAt(i)!=needle.charAt(j) && j==0){
                i++;
            }
        }
        return -1;
    }
    private int [] lps(String needle){
        int [] lps = new int[needle.length()];
        lps[0] = 0;
        int j=0;
        int i=1;
        while(i<needle.length()){
            if(needle.charAt(j)==needle.charAt(i)){
                j++;
                lps[i]=j;
                i++;
            } else if(needle.charAt(j)!=needle.charAt(i) && j>0){
                j=lps[j-1];
            } else if((needle.charAt(j) != needle.charAt(i) && j==0)){
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
}