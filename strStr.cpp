// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. Robin karp Double Hashing algorithm is used to find the substring in the main string.
//2. Two prime numbers are used to calculate the hash values of the needle and the window of the haystack.
//3. If the hash values of the needle and the window are equal, then we compare the substrings.
//4. If the substrings are equal, we return the starting index of the window.
//5. If the substrings are not equal, we slide the window by removing the first character and adding the next character.
//6. We calculate the hash values of the new window and compare them with the hash values of the needle.
//7. If the hash values are equal, we compare the substrings and return the starting index of the window.
//8. If the needle is not found in the haystack, we return -1.

class Solution {
    public:
        int strStr(string haystack, string needle) {
            int n = haystack.size(); 
            int m = needle.size();
            if(m > n){return -1;}
    
            const int prime1 = 31; 
            const int prime2 = 53; 
            const int mod1 = 1e9 + 7; 
            const int mod2 = 1e9 + 9;
    
            long long hashNeedle1 = 0, hashNeedle2 = 0; 
            long long hashWindow1 = 0, hashWindow2 = 0; 
            long long power1 = 1, power2 = 1;
    
            for(int i = 0; i < m; i++){
                hashNeedle1 = (hashNeedle1 * prime1 + needle[i]) % mod1;
                hashNeedle2 = (hashNeedle2 * prime2 + needle[i]) % mod2;
                hashWindow1 = (hashWindow1 * prime1 + haystack[i]) % mod1;
                hashWindow2 = (hashWindow2 * prime2 + haystack[i]) % mod2;
    
                if (i < m - 1) {
                    power1 = (power1 * prime1) % mod1;
                    power2 = (power2 * prime2) % mod2;
                }
            }
            if (hashWindow1 == hashNeedle1 && hashWindow2 == hashNeedle2) {
                if (haystack.substr(0, m) == needle) return 0;  // Verify substring
            }
            for (int i = m; i < n; i++) {
                hashWindow1 = (hashWindow1 - haystack[i - m] * power1) % mod1;
                hashWindow1 = (hashWindow1 * prime1 + haystack[i]) % mod1;
                if (hashWindow1 < 0) hashWindow1 += mod1;  
    
                hashWindow2 = (hashWindow2 - haystack[i - m] * power2) % mod2;
                hashWindow2 = (hashWindow2 * prime2 + haystack[i]) % mod2;
                if (hashWindow2 < 0) hashWindow2 += mod2;  
    
                if (hashWindow1 == hashNeedle1 && hashWindow2 == hashNeedle2) {
                    if (haystack.substr(i - m + 1, m) == needle) return i - m + 1;
                }
            }
            return -1;
        }
    };