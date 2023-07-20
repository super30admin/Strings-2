
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;

        Integer sLen = s.length(), pLen = p.length();
        if (pLen > sLen)
            return result;

        int[] sCnt = new int[26], pCnt = new int[26];
        for (int i = 0; i < pLen; i++)
            pCnt[(int) p.charAt(i) - 'a']++;

        for (int i = 0; i < sLen; i++) {
            sCnt[(int) s.charAt(i) - 'a']++;
            if (i >= pLen)
                sCnt[(int) s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(sCnt, pCnt))
                result.add(i - pLen + 1);
        }
        return result;
    }
}