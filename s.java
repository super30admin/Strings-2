class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Add this check!
        if (p.length() > s.length()) {
            return result; // Return empty list if p is longer than s
        }

        int[] pcount = new int[26];
        int[] scount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pcount[p.charAt(i) - 'a']++;
            scount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pcount, scount)) {
                result.add(i);
            }
            if (i + p.length() < s.length()) {
                scount[s.charAt(i) - 'a']--;
                scount[s.charAt(i + p.length()) - 'a']++;
            }
        }
        return result;
    }
}

//
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;

        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String currsubstring = haystack.substring(i, i + needle.length());
            if (currsubstring.equals(needle)) {
                return i;
            }

        }
        return -1;
    }
}