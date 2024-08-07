/*
TC --> O(n)
SC --> O(n) HashMap
 */
class Solution {

    public int strStr(String haystack, String needle) {
        HashMap<Integer, String> mp = new HashMap<>();
        int s = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (c == needle.charAt(0)) {
                if (i + s - 1 < haystack.length()) {
                    String st = haystack.substring(i, i + s);
                    mp.put(i, st);
                }
            }
        }

        //System.out.println(mp);
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, String> entry : mp.entrySet()) {
            String val = entry.getValue();
            int k = entry.getKey();
            if (needle.equals(val)) {
                if (k < res) {
                    res = k;
                }
            }

        }//for

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }//method
}//class
