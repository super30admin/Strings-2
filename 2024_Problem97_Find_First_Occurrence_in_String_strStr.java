//28. Find Index of the First Occurrence in a String - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
//Time Complexity: 0(m*n)
//Space Complexity: O(1)

//Brute Force
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int i=0;
        while(i <= m-n){
            int j=0;
            if(haystack.charAt(i) == needle.charAt(j)){
                int k=i; //temporary pointer preserving starting index
                while(haystack.charAt(k) == needle.charAt(j)){
                    //characters are equal, increment bothto check the match
                    j++;
                    k++;
                    if(j == n){ //j reaches end of the string ~ matched entire string
                        return i; //starting index
                    }
                }
            }
            i++;
        }
        return -1;
    }
}


//Time Complexity: 0(n)
//Space Complexity: O(1)
//Optimal Solution
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int prime = 1000001; //to avoid integer overflow
        // instead of considering long, BigInt, we are considering % prime

        int positionFactor = 1;
        for(int i=0; i<n; i++){
            positionFactor = (positionFactor * 26) % prime; //% prime to have the range
        }

        int patternHash = 0;
        for(int i=0; i<n; i++){
            char c = needle.charAt(i);
            patternHash = (patternHash * 26 + (c - 'a' + 1)) % prime; //% prime to have the range
        }

        int currHash = 0;
        for(int i=0; i<m; i++){
            char in = haystack.charAt(i);
            currHash = (currHash * 26 + (in - 'a' + 1)) % prime;
            if(i >= n){
                char out = haystack.charAt(i-n);
                currHash = (currHash - (positionFactor * (out - 'a' + 1))) % prime; //% prime to have the range
            }

            //to avoid negative hash
            if(currHash < 0){
                currHash += prime; //add prime number to convert negative to pisitive hash
            }

            if(currHash == patternHash){
                return i-n+1;
            }
        }
        return -1;
    }
}
