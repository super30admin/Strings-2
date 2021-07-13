public class StrStr {


    /*
    TC : O(N*M) where N is the length of haystack and M is the length of needle string
    SC : O(1)
    LC : Yes
    Problem : No
     */

    /**
     * The approach taken here is to iterate over the haystack string and everytime we find a character
     * that is same as the starting character of needle, then we run a while loop to see if the complete string needle
     * is present from that index.
     * <p>
     * If yes, then return the starting index else continue
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        int h = 0;
        int n = 0;
        int result = -1;

        if (needle.equals(""))
            return 0;

        while (h < haystack.length() - needle.length() + 1) {

            int temp = h;
            while (n < needle.length() && temp < haystack.length() && haystack.charAt(temp) == needle.charAt(n)) {
                temp++;
                n++;
            }

            if (n == needle.length()) {
                result = temp - needle.length();
                break;
            } else {
                h++;
                n = 0;
            }

        }

        return result;

    }
}
