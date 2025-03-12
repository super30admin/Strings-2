// TC: O(h-n) where h is the haystack string length and n is the needle length. traversing will be only done till h-n. 
// if it is checked after this length it will give error for out of bounds

// SC: O(1) as no data structure has been used

// Runs successfully on Leetcode

// for every iteration haystack substring is checked against needle and return the index if it satisfies.
// In the end, -1 is returned if nothing matches.
public class NeedleinaHaystack {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // 0
        System.out.println(strStr("leetcode", "leetco")); // 0
        System.out.println(strStr("leetcode", "leeto")); // -1
    }

    public static int strStr(String hay, String need) {
        if (need.length() == 0)
            return 0;
        if (need.length() > hay.length())
            return -1;
        int h = hay.length();
        int n = need.length();
        for (int i = 0; i <= h - n; i++) {
            if (hay.substring(i, i + n).equals(need)) {
                return i;
            }
        }
        return -1;
    }
}
