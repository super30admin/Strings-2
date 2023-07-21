import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class AnagramsInAString {

        // SLIDING WINDOW ON STRINGS

        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> result = new ArrayList<>();

            int m = p.length(); int n = s.length();

            // character frequency map of given pattern p
            HashMap<Character, Integer> freqmatch = new HashMap<>(); // O(1) space = 26 characters at maximum

            for(int i = 0; i < m; i++) { // O(m)

                char c = p.charAt(i);

                freqmatch.put(c, freqmatch.getOrDefault(c, 0) + 1);

            }

            // matching characters number is zero initially
            int match = 0;

            // iterate over all characters of string s
            for(int i = 0; i < n; i++) { // O(n)

                // incoming character in sliding window of pattern length
                char in = s.charAt(i);

                // if an incoming character is found in map, reduce its count
                if(freqmatch.containsKey(in)) {

                    int count = freqmatch.get(in);

                    count--;

                    // if count is zero, there is a match of incoming character in pattern
                    if(count == 0) {

                        match++;
                    }

                    //update map with new frequency of incoming character
                    freqmatch.put(in, count);
                }

                //outgoing
                //first outgoing character only when iterator i crosses pattern length
                if(i >= m) {

                    // (i - m) will be the index of outgoing character
                    char out = s.charAt(i - m);

                    // increase count of outgoing character if it is in map
                    if(freqmatch.containsKey(out)) {

                        int count = freqmatch.get(out);

                        count++;

                        // zero to one transition indicates match to mismatch transition
                        if(count == 1) {

                            match--;
                        }

                        //update map with new frequency of outgoing character
                        freqmatch.put(out, count);

                    }
                }

                // after every slide of window with iterator i moving forward, if match character count is same as map size of pattern -> anagram exists in that window
                if(match == freqmatch.size()) {

                    result.add(i - m + 1);
                }
            }
            //output list of starting indices of anagrams
            return result;
        }

        public static void main(String[] args) {

            AnagramsInAString object = new AnagramsInAString();

            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter string s
            System.out.print("Enter s: ");
            String s = scanner.nextLine();

            // Prompt the user to enter pattern p
            System.out.print("Enter p: ");
            String p = scanner.nextLine();

            List<Integer> answer = object.findAnagrams(s, p);

            System.out.println("Start indices of p's anagrams in s: ");

            for (Integer num : answer) {
                System.out.println(num);
            }
        }

}

/* TIME COMPLEXITY = O(M+N)
SPACE COMPLEXITY = O(1) */