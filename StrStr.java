class StrStr {
    public int strStr(String haystack, String needle) {

        for (int i=0; i<haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {

                for (int j=0; j<needle.length(); j++) {
                    if (haystack.charAt(j) != needle.charAt(j)) {
                        break;
                    }

                }
                return i;

            }

        }

        return -1;

    }
}