// TC : O(m*n)
// SC : O(1)
class IndexofFirstOccurrenceInaString {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int hp = 0;
        int np = 0;
        while(hp < haystack.length()) {
            if(haystack.charAt(hp) == needle.charAt(np)) {
                np++;
                if(np == needle.length()) {
                    return hp - needle.length() + 1;
                }
            } else {
                hp = hp - np;
                np = 0;
            }
            hp++;
        }
        return -1;
    }
}