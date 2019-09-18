public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        int ptr1 = 0;
        for(int i = 0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(ptr1)) {
                if(ptr1 == needle.length()-1) {
                    return i-ptr1;
                }
                ptr1++;
            }
            else if(ptr1 != 0) {
                i = i-ptr1;
                ptr1 = 0;
            }
        }
        return -1;
    }
