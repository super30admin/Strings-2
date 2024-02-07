/*
* Approach:
*  1. Sliding Window Technique with prime products:
        prime products of anagrams will be same.

        First, find the product of all elements in p => hash
* 
*  2. Start iterating on S,
        increasing the window size by multiplying the product 
        if size of window  == length of p,
        add elements to window and also start removing elements from start.
* 
*  3. While removing elements remove the contribution by dividing the value 
        of outgoing char

    if hash matches, add the start index to result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n+2m)
    n = length of p
    m = length of s
* 
* Space Complexity: O(1)
* 
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class FindAnagramsPrimeProducts {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                         41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                         89, 97, 101 };

        int m = s.length(), n = p.length();

        BigInteger hash = BigInteger.ONE;

        for (int index = 0; index < n; index++) {
            char ch = p.charAt(index);

            hash = hash.multiply(BigInteger.valueOf(primes[ch - 'a']));
        }

        BigInteger currhash = BigInteger.ONE;

        // System.out.println("hash:"+hash);
        for (int index = 0; index < m; index++) {
            char ch = s.charAt(index);

            currhash = currhash.multiply(BigInteger.valueOf(primes[ch - 'a']));

            if (index >= n) {
                char out = s.charAt(index - n);

                currhash = currhash.divide(BigInteger.valueOf(primes[out - 'a']));
            }

            // System.out.println("cur hash:"+currhash);
            if (currhash.compareTo(hash) == 0) {
                result.add(index - n + 1);
            }
        }

        return result;
    }
}