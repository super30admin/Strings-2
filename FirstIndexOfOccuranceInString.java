class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)

    public int strStr(String haystack, String needle) {
        int nPointer = 0;
        int hPointer = 0;
        int noteStart = 0;
        while (hPointer < haystack.length()){
            if (needle.charAt(nPointer) == haystack.charAt(hPointer)){
                if(nPointer == 0)
                noteStart = nPointer;
                nPointer ++;
                if (nPointer == needle.length())
                return noteStart;
            } else {
                nPointer = 0;
            }
                hPointer ++;
        }
        return -1;
    }
}
