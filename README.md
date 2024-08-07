# Strings-2


## Problem1 
Implement strStr() (https://leetcode.com/problems/implement-strstr/)

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Time Complexity - m is length of haystack string and n is length of needle string. O(m*n) for brute-force approach and O(m+n) for Robin-Karp Rolling hash algorithm
Space Complexity - O(1) as we are not using any extra space
Explaination - Firstly in brute-force approach we will iterate over the haystack string till m-n characters. Everytime a character matches with first character of needle we will just move both pointers in both strings one by one and check if it is matching or not. If all the characters match we will return first index otherwise we will reset our pointer to the starting for the needle and i+1 for haystack from where we started the comparision. Robin-Karp Rolling hash algorithm will be a better approach where it is a string searching algorithm which uses hashing to find set of pattern string in text. In this approach we will first calculate for needle and then using sliding window we can check for all characters in haystack until we find a match.


Approach Code -

import java.math.BigInteger;class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();

        if(n > m) {
            return -1;
        }

        // Brute-force approach

        // int i = 0;

        // while(i <= m-n) {

        //     if(haystack.charAt(i) == needle.charAt(0)) {

        //         int k = i;
        //         int j = 0;

        //         while(haystack.charAt(k) == needle.charAt(j)) {
        //             k++;
        //             j++;

        //             if(j == n) {
        //                 return i;
        //             }
        //         }

        //     }
            
        //     i++;
        // }



        // Robin-Karp Rolling Hash Algorithm
        BigInteger nHash = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(26);

        for(int i = 0; i < n; i++) {
            char c = needle.charAt(i);

            nHash = nHash.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));
        }

        BigInteger hHash = BigInteger.ZERO;

        for(int i = 0; i < m; i++) {
            if(i >= n) {
                hHash = hHash.mod(k.pow(n-1));
            }

            char c = haystack.charAt(i);

            hHash = hHash.multiply(k).add(BigInteger.valueOf(c - 'a' + 1));

            if(nHash.equals(hHash)) {
                return i - n + 1;
            }

        }

        return -1;

    }
}





## Problem2 

Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".



Time Complexity - O(m+n) where m is length of string s and n is length of string p as we are going over the string p first and then string s
Space Complexity - O(1) as in hashmap even though we will store all characters from string s/p at maximum it will be hashmap of 26 characters only
Explaination - First Approach would be we will take a prime product of string p and then take a sliding window on string s and check if the current sliding window has prime product equal to prime product of string p. If it does add up to the same number then we will simply store the starting index of the sliding window. Second approach would be first we will go over all the elements in p and store the number of occurances of each character in a hashmap. Then we will take a match variable whenever match will become equal to the size of hashmap we will store the starting index in result. Then we will go through string s and take care of the incoming letter and outgoing letter. For incoming character we will get a count from map and reduce it by 1 as a match and update that count in map. If the updated count is 0 then we will increase match variable value. Then for outgoing character we will start it after sliding window and will check if this character is present in map if it does we will increase it's count by 1 and update it in map. Whenever count becomes 1 from 0 we will decrease the match.


Approach Code -

import java.math.BigInteger;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int m = s.length();
        int n = p.length();

        if(n > m) {
            return result;
        }

        // Prime Product Solution

        // BigInteger pPrimeProduct = BigInteger.ONE;

        // HashMap<Character, BigInteger> map = createHashmap();

        // for(int i = 0; i < n; i++) {
        //     char c = p.charAt(i);
        //     BigInteger primeNum = map.get(c);

        //     pPrimeProduct = pPrimeProduct.multiply(primeNum);
        // }

        // int firstPointer = 0;
        // int secondPointer = n-1;

        // BigInteger sPrimeProduct = BigInteger.ONE;

        // for(int i = firstPointer; i <= secondPointer; i++) {
        //     char c = s.charAt(i);
        //     BigInteger primeNum = map.get(c);

        //     sPrimeProduct = sPrimeProduct.multiply(primeNum);

        // }

        // if (sPrimeProduct.equals(pPrimeProduct)) {
        //     result.add(firstPointer);
        // }

        // while(firstPointer < m-n) {
        //     char outC = s.charAt(firstPointer);
        //     char inC = s.charAt(secondPointer+1);

        //     BigInteger outPrime = map.get(outC);
        //     BigInteger inPrime = map.get(inC);

        //     sPrimeProduct = sPrimeProduct.divide(outPrime);
        //     sPrimeProduct = sPrimeProduct.multiply(inPrime);

        //     firstPointer++;
        //     secondPointer++;

        //     if(sPrimeProduct.equals(pPrimeProduct)) {
        //         result.add(firstPointer);
        //     }


        // }



        // HashMap Solution

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char c = p.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;

        for(int i = 0; i < m; i++) {
            // incoming character case
            char in = s.charAt(i);

            if(map.containsKey(in)) {
                int count = map.get(in) - 1;
                map.put(in, count);

                if(count == 0) {
                    match++;
                }
            }

            // outgoing character case
            if(i >= n) {
                char out = s.charAt(i - n);

                if(map.containsKey(out)) {
                    int count = map.get(out) + 1;
                    map.put(out, count);

                    if(count == 1) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                result.add(i - n + 1);
            }
        }

        return result;
    }

    private HashMap<Character, BigInteger> createHashmap() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
        47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z'};

        HashMap<Character, BigInteger> map = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            map.put(letters[i], BigInteger.valueOf(primes[i]));
        }

        return map;
    }
}


