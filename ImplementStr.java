class ImplementStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n)
            return -1;

        long needleHash = 0l;
        int k = 26;
        long kn = (long) Math.pow(k, n);

        for (int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            needleHash = needleHash * k + (c - 'a' + 1);
        }

        long currHash = 0l;
        for (int i = 0; i < m; i++) {
            char in = haystack.charAt(i);
            currHash = currHash * k + (in - 'a' + 1);

            // outgoing
            if (i >= needle.length()) {
                char out = haystack.charAt(i - n);
                currHash = currHash - (out - 'a' + 1) * kn;
            }
            if (currHash == needleHash) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr obj = new ImplementStr();
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = obj.strStr(haystack, needle);
        System.out.println("Index of the first occurrence of needle in haystack: " + result);

        haystack = "leetcode";
        needle = "leeto";
        result = obj.strStr(haystack, needle);
        System.out.println("Index of the first occurrence of needle in haystack: " + result);

        haystack = "hello";
        needle = "ll";
        result = obj.strStr(haystack, needle);
        System.out.println("Index of the first occurrence of needle in haystack: " + result);
    }
}