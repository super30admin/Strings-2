class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int pat[] = new int[26];
        int str[] = new int[26];
        for (char c : s1.toCharArray())
            pat[c - 'a']++;
        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            str[s2.charAt(end) - 'a']++;
            if (end >= s1.length()) {
                str[s2.charAt(start) - 'a']--;
                start++;
            }
            if (Arrays.equals(str, pat)) {
                resultIndices.add(start);
            }
        }
        return resultIndices;
    }
}