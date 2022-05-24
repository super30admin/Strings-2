//Brute Force
class Solution {

    //Time Complexity: 0(m*n) where m is the length of haystack string and n is the length of needle string
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In short explain your approach:

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        while(i <= m - n){  //the while loop runs from 0 index to the difference of length of haystack and needle as if size of haystack is less than needle, then the needle cannot occur in haystack
            if(haystack.charAt(i) == needle.charAt(0)){ //checking if the character ith position is equal to the 1st character of the needle
                int j = 0;  //initializing j to run through every character of needle
                int k = i;  //duplicating value of i to to run through haystack
                while(j < n && k < m && haystack.charAt(k) == needle.charAt(j)){ //the loop runs till the index is out of bounds or if there is a mismatch
                    k++;
                    j++;
                }
                if(j == n){ //if the value of j is equal to the length of the needle, means we have found our needle
                    return i;//returning the index of i
                }
            }
            i++;    //if not, we increment the pointer in haystack and start all over again
        }
        return -1;
    }
}

//KMP method

//Time Complexity: 0(m+n) where m is the length of haystack string and n is the length of needle string
//Space Complexity: 0(n)n is the length of needle string
//Did it successfully run on leetcode: Yes
//Did you face any problem while coding: No


class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;  //acting like fast pointer
        int j = 0;  //acting like slow pointer
        int [] kmp = kmp(needle);   //we declare a kmp fuunction where we send needle
        while(i < m){//the loop runs through i
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n){
                    return i - n;   //if all the characters are equal then we return the index where the characters began from
                }
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){   //if not, and our fast pointer is ahead
                j = kmp[j-1];   //we send the fast pointer to kmp to return to the last index where the similarities began so that we do have to iterate over our haystack again to check the matching elements
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0){  //iffast pointer is at beginning of the haystack, then we increment the index of haystack to begin the search from there
                i++;
            }
        }
        return -1;
    }
    public int [] kmp(String needle){   //implementing KMP algorithm
        int[] kmp = new int [needle.length()];
        int i = 1;
        int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                kmp[i] = j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = kmp[j-1];   //if there is a mismatch and fast pointer is not at beginning of haystack, we just decrement the value of j by 1
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                i++;    //if j is at the beginning of haystack, then we increment our i pointer or another index on haystack
            }
        }
        return kmp;
    }
}