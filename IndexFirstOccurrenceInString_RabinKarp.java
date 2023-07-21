import java.util.Scanner;

public class IndexFirstOccurrenceInString_RabinKarp {

        // RABIN - KARP ALGORITHM - O(N+M) = O(N) - PATTERN FINDING ALGORITHMS

        public int strStr(String haystack, String needle) {

            int m = needle.length();

            int n = haystack.length();

            if(n < m) return -1;

            int k = 26;

            long outFactor = (long)Math.pow(k, m);

            // hash of needle

            long needleHash = 0l;

            for(int i = 0; i < m; i++) { // O(m)

                char in = needle.charAt(i);

                needleHash = needleHash * k + (in + 1 - 'a');
            }

            // hash of haystack

            long hayHash = 0l;

            for(int i = 0; i < n; i++) { // O(n)

                //incoming

                char in = haystack.charAt(i);

                // current hash is earlier hash multiplied by number of characters + incoming character hash value
                hayHash = hayHash * k + (in + 1 - 'a');

                //outcoming

                if(i >= m) {

                    char out = haystack.charAt(i - m);

                    // subtract the contribution of outgoing character
                    hayHash = hayHash - outFactor * (out + 1 - 'a');
                }

                // needle found in haystack
                if(hayHash == needleHash) {

                    return (i - m + 1);
                }
            }
            return -1;
        }

        public static void main(String[] args) {

            IndexFirstOccurrenceInString_RabinKarp object = new IndexFirstOccurrenceInString_RabinKarp();

            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter Haystack
            System.out.print("Haystack: ");
            String h = scanner.nextLine();

            // Prompt the user to enter Needle
            System.out.print("Needle: ");
            String n = scanner.nextLine();

            int answer = object.strStr(h, n);

            System.out.println("The index of the first occurrence of needle in haystack: " + answer);
        }

}


/*
TIME COMPLEXITY = O(N+M) = O(N)

O(N) as N > M

For needle hash - O(M)

For haystack hash - O((M)*1 + (N-M)*1)

Total time Complexity = O(m + (n-m)*1 + 1*m) = O(N+M)

SPACE COMPLEXITY = O(1)
*/