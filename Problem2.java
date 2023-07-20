
//Time Complexity - O(n * m) 
//Space Complexity - O(1)

class Solution {
    public int strStr(String haystack, String needle) {

        if (haystack == null || haystack.length() == 0 || needle == null)
            return -1;

        int nLen = needle.length();
        int hLen = haystack.length();

        if (nLen > hLen)
            return -1;

        for (int hIndex = 0; hIndex <= hLen - nLen; hIndex++) {
            for (int nIndex = 0; nIndex < nLen; nIndex++) {
                char curCh = haystack.charAt(hIndex + nIndex);
                char firstCh = needle.charAt(nIndex);
                if (curCh != firstCh)
                    break;
                if (nIndex == nLen - 1)
                    return hIndex;
            }
        }
        return -1;
    }
}