class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.equals(needle)) return 0;

        char ch = needle.charAt(0);

        for(int i=0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == ch) {
                if(i + needle.length() <= haystack.length() && haystack.substring(i, i+needle.length()).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}