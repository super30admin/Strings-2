// TC : O(n)
// SC : O(1) pFreq and windowFreq has maximum of 26 characters
class FindAnagramsInaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null || s.length() ==0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, windowFreq)) {
            result.add(0);
        }

        for(int i = p.length(); i < s.length(); i++) {
            char sChar = s.charAt(i);
            windowFreq[s.charAt(i - p.length()) - 'a']--;
            windowFreq[sChar-'a']++;
            if(Arrays.equals(pFreq,windowFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}