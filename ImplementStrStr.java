//Time complexity : O(m)
//Space complexity : O(1)
class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "dasissad";
        String needle = "sad";
        int firstOccurence = strStr(haystack, needle);
        System.out.println(firstOccurence);
    }

    private static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n)
            return -1;
        long needleHash = 0;
        long k = 26l;
        for (int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            needleHash = needleHash * k + (c - 'a' + 1);
        }
        long currentHash = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char in = haystack.charAt(i);
            currentHash = currentHash * k + (in - 'a' + 1);

            if (i >= needle.length()) {
                char out = haystack.charAt(i - needle.length());
                currentHash = (long) (currentHash - (out - 'a' + 1) * Math.pow(k, n));
            }

            if (currentHash == needleHash) {
                return i - needle.length() + 1;
            }
        }

        return -1;
    }
}