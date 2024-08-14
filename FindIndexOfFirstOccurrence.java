import java.math.BigInteger;
import java.util.Objects;

public class FindIndexOfFirstOccurrence { //Needle in a haystack problem
    public static int strStrBrute(String haystack, String needle) { //O(m*n) T.C, O(1) S.C
        int h = haystack.length(); //m
        int n = needle.length(); //n

        //Optimizations
        if(n == h) return Objects.equals(needle, haystack) ? 0 : -1;
        if(n > h) return -1;

        for(int i=0; i<=h; i++) { //O(m) T.C
            if(i >= n) { //comparison should start only if the current iteration is at least length of needle
                if(Objects.equals(haystack.substring(i-n, i), needle)) //compare each substring of length n with needle
                    return i-n; //if it is equal, return the starting index
            }
        }
        return -1; //if no equal substring is found, return -1
    }

    /*
    Implementation of robin karp algorithm with hashing multiplier 26. We use big integers because
    int, long and double would become out of range if the string is too lengthy.
     */
    public static int strStr(String haystack, String needle) { //O(m+n) T.C, O(1) S.C
        int h = haystack.length(); //m
        int n = needle.length(); //n
        if(n > h) return -1;

        BigInteger twentySix = BigInteger.valueOf(26); //multiplier
        BigInteger hashNeedle = BigInteger.ZERO; //initialization
        for(int i=0; i<n; i++) { //O(n) T.C
            char c = needle.charAt(i);
            //hashN = hashN * 26 + (c-'a'+1)
            hashNeedle = hashNeedle.multiply(twentySix).add(BigInteger.valueOf(c-'a'+1));
        }

        BigInteger hashHay = BigInteger.ZERO;
        BigInteger modK = twentySix.pow(n-1); //(26^n-1) is to be divided when hash value reaches n digits
        for(int i=0; i<h; i++) {
            //outgoing
            if(i>=n) { //when iteration is at least n, hash value is at n digits
                hashHay = hashHay.mod(modK); //find the remainder once it is divided by the modK from above.
                //i.e., if n is 5 and multipler is 10, 41235 -> becomes 41235 % 10^4 = 1235.
            }

            char c = haystack.charAt(i);
            //incoming
            hashHay = hashHay.multiply(twentySix).add(BigInteger.valueOf(c-'a'+1));
            if(hashHay.equals(hashNeedle)) return i-n+1; //if both hashes are equal, return the starting index
        }

        return -1;
    }

    public static void main(String[] args) {
        String needle = "bad";
        String haystack = "nithinisawonderfulguy";

        System.out.println("The index of " + needle + " in " + haystack + " using brute force is: "
                        +strStrBrute(haystack, needle));

        String needle2 = "wonderful";
        System.out.println("The index of " + needle2 + " in " + haystack + " " +
                "using robin karp algorithm is: " +strStrBrute(haystack, needle2));
    }
}