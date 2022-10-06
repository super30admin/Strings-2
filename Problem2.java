class Problem2 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        // Optimized version:
        int i = 0;
        int j = 0;
        int returnValue = -1;
        int[] lps = runKMP(needle);
        while(i < haystack.length()){
            // If there is a match
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                // Check whether the needle is found entirely and return the index from the common part began.
                if(j == needle.length()){
                    returnValue = i - needle.length();
                    return returnValue;
                }
            }
            // When corresponding characters don't match put j back that many indices which lps list suggests.
            // Since each element of lps gives the longest common sequence of that substring
            // between prefix barring last element and suffix barring first element.
            else if(haystack.charAt(i) != needle.charAt(j) && j>0){
                j = lps[j-1];
            }
            else if(haystack.charAt(i)!= needle.charAt(j) && j==0){
                i++;
            }

        }
        return returnValue;

    }

    private int[] runKMP(String needle){
        int j = 0;
        int i = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        while(i < needle.length()){
            // We have different situations to consider in this algo.
            // Case 1:
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
                lps[i] = j;
                i++;
            }
            // Case 2:
            else if(needle.charAt(j) != needle.charAt(i) && j>0){
                j = lps[j-1];
            }
            else if(needle.charAt(j) != needle.charAt(i) && j==0){
                lps[i]=0;
                i++;
            }
        }

        return lps;
    }

    // Brute force way:
    //     int i, j, k;
    //     int m = needle.length();
    //     int n = haystack.length();
    //     for(i=0;i<=n-m;i++){
    //         // char c = haystack.charAt(i);
    //         // Assigning j to currentindex
    //         j = i;
    //         boolean flag = true;
    //         for(k=0;k<needle.length();k++){
    //             if(needle.charAt(k)==haystack.charAt(j)){
    //                 j++;
    //             }
    //             else{
    //                 flag = false;
    //                 break;
    //             }
    //         }
    //         if(flag){
    //             return i;
    //         }

    //     }
    //     // if we reach here it means we have not found a matching index;
    //     return -1;
    // }

}