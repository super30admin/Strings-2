/*
 * TC - O(m+n)
 * SC - O(1)
 */

public class FirstOccurence {
    //the % prime is to handle to overflow issue
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int pHash = 0;
        int prime = 1000001;
         
        for(int i = 0; i < n; i++){
            pHash = (pHash*26 + (needle.charAt(i)-'a' + 1)) % prime; //we have to start value in map from 1 not 0 so +1
        }

        int currHash = 0;
        int positionFactor = 1;
        for(int i =0; i < n; i++){
            positionFactor = (positionFactor * 26) % prime;
        }

        for(int i =0; i < m;i++){
            char in = haystack.charAt(i);
            currHash = (currHash*26 + (in-'a'+1)) % prime;
            
            if(i >= n){
                //window size reached, remove start
                char out = haystack.charAt(i-n);
                currHash = (currHash - (positionFactor * (out - 'a'+1))) % prime;
            }
            if(currHash < 0){
                currHash += prime;
            }

            if(currHash == pHash){
                return i-n+1;
            }
        }

        return -1;
    }


    //Rabin karp algorithm, this would cause overflowing for really big values O(n+m)
    // public int strStr(String haystack, String needle) {
    //     int m = haystack.length(), n = needle.length();
    //     long pHash = 0l;
    //     for(int i = 0; i < n; i++){
    //         pHash = pHash*26 + (needle.charAt(i)-'a' + 1); //we have to start value in map from 1 not 0 so +1
    //     }

    //     long currHash = 0l;
    //     long positionFactor = (long)Math.pow(26,n);
    //     for(int i =0; i < m;i++){
    //         char in = haystack.charAt(i);
    //         currHash = currHash*26 + (in-'a'+1);
            
    //         if(i >= n){
    //             //window size reached, remove start
    //             char out = haystack.charAt(i-n);
    //             currHash = currHash - (positionFactor * (out - 'a'+1));
    //         }

    //         if(currHash == pHash){
    //             return i-n+1;
    //         }
    //     }


    //     return -1;
    // }

    //brute force
    // public int strStr(String haystack, String needle) {
    //     int m = haystack.length(), n = needle.length();
    //     int i =0;
    //     while(i <= m-n){
    //         int j = 0;
    //         if(haystack.charAt(i) == needle.charAt(j)){
    //             int k = i;
    //             while(haystack.charAt(k) == needle.charAt(j)){
    //                 k++;
    //                 j++;
    //                 if(j == n) return i;
    //             }
    //         }
    //         i++;
    //     }
    //     return -1;
    // }
}
