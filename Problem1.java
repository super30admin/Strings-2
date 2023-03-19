/*
Find the Index of the First Occurrence in a String
approach:
1. at each index of haystack check all characters are matching; time: O(mxn) space: O(1)
2. LPS, for the needle string, calculate length of longest common prefix == suffix; time: O(len(haystack)) space: O(1)
3. for every index of haystack, calculate hash, if it is equal to needle hash return index; time: O(len(haystack) space: O(1)

 */
public class Problem1 {
    public int strStr(String haystack, String needle) {
        int fast = 0;
        int j = 0;
        while(fast<=haystack.length()-needle.length()) {
            if(haystack.charAt(fast)==needle.charAt(j)) {
                int slow = fast;

                while(haystack.charAt(slow)==needle.charAt(j)) {
                    j++;slow++;
                    if(j==needle.length()) return fast;
                }
                j=0;
            }
            fast++;
        }

        return -1;
    }

    public int strStrLPS(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        int[] lps = get(needle);
        int i = 0, j = 0;
        while(i<haystack.length()) {
            if(haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
                if(j==needle.length()) return (i-needle.length());
            }
            else if(haystack.charAt(i)!=needle.charAt(j) && j>0) {
                j = lps[j-1];
            }
            else if(haystack.charAt(i)!=needle.charAt(j) && j==0) {
                i++;
            }
        }

        return -1;
    }

    private int[] get(String s) {
        int j=0, i = 1;
        int[] lps = new int[s.length()];
        lps[0] = 0;

        while(i<s.length()) {
            if(s.charAt(i)==s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else if(s.charAt(i)!=s.charAt(j) && j>0) {
                j = lps[j-1];
            }
            else if(s.charAt(i)!=s.charAt(j) && j==0) {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }


    public int strStrHashing(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        long nhash = getNhash(needle);

        int k=26;
        long kl = (long)Math.pow(k, needle.length());
        long hhash = 0;

        for(int i=0;i<needle.length();i++) {
            char c = haystack.charAt(i);
            hhash = hhash*k+(c-'a');
        }
        if(hhash==nhash) return 0;

        for(int i=1;i<=haystack.length()-needle.length();i++) {
            char in = haystack.charAt(i+needle.length()-1);
            char out = haystack.charAt(i-1);

            hhash = hhash*k+(in-'a');
            hhash = hhash - kl*(out-'a');
            if(hhash==nhash) return i;
        }
        return -1;
    }

    private long getNhash(String s) {
        int k = 26;
        long nhash = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            nhash = nhash*k+(c-'a');
        }

        return nhash;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.strStr("sadbutsad", "sad");
    }
}
