import java.util.Scanner;

public class IndexFirstOccurrenceInString_BruteForce {

        // BRUTE FORCE - SLIDING WINDOW - O(M*N)

        public int strStr(String haystack, String needle) {

            int m = needle.length();

            int n = haystack.length();

            int i = 0;

            while( i <= n - m) {   // O(m*n)

                if(haystack.charAt(i) == needle.charAt(0)) {

                    int k = i;

                    int l = 0;

                    while(haystack.charAt(k) == needle.charAt(l)) {

                        k++; l++;

                        if(l == m) {

                            return i;
                        }
                    }
                }
                i++;
            }
            return -1;
        }

        public static void main(String[] args) {

            IndexFirstOccurrenceInString_BruteForce obj = new IndexFirstOccurrenceInString_BruteForce();

            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter Haystack
            System.out.print("Haystack: ");
            String h = scanner.nextLine();

            // Prompt the user to enter Needle
            System.out.print("Needle: ");
            String n = scanner.nextLine();

            int answer = obj.strStr(h, n);

            System.out.println("The index of the first occurrence of needle in haystack: " + answer);
        }

}

/* TIME COMPLEXITY =  O(m*n)
SPACE COMPLEXITY = O(1)
*/