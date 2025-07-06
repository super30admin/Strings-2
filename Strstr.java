//Tine: O(n * m) where n is the length of haystack and m is the length of needle
//Space: O(1) since we are not using any extra space that grows with input size
public class Strstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
