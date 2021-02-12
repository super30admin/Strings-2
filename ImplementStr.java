// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class ImplementStr {
    public int strStr(String haystack, String needle) {
        //if needle len is 0 return 0
        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            // when there are not enough places for needle after i
            if (i + needle.length() > haystack.length())
                break;

            //iterate through needle and see if characters match in haystack
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }
}