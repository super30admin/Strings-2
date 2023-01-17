import java.util.*;
// Approach: Sliding window and 2 arrays
// Time: O(N(s)) N length of string s
// Space: O(k) k = 26, thus O(1)
class All_anagrams_in_a_string {
    public List<Integer> findAnagrams(String s, String p) {

        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];

        for (char ch : p.toCharArray()) {
            pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {

            sCount[(int)(s.charAt(i) - 'a')]++;

            if (i >= np) {
                sCount[(int)(s.charAt(i - np) - 'a')]--;
            }

            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }
}