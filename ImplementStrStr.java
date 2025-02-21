class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty()){
            return -1;
        }
        int l = 0;
        int r = needle.length();
        while(r<=haystack.length()){
            String s = haystack.substring(l, r);
            if(s.equalsIgnoreCase(needle)){
                return l;
            }
            l++;
            r++;
        }
        return -1;
    }
}
