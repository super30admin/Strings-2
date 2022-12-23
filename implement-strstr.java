
//tc is O(m+n)
//sc is o(n) in case hashmap has all values of one character eg: aaaaaaaaaaaaa
import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null)
            return -1;
        int m = haystack.length();
        int n = needle.length();

        if (m == 0 || n == 0)
            return -1;

        if (n > m)
            return -1;

        // make the map
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char c = haystack.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }

            List<Integer> list = map.get(c);
            list.add(i);

            map.put(c, list);
        }

        // get values of starting index

        List<Integer> list = map.get(needle.charAt(0));

        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int index = list.get(i);
                System.out.println(index);

                if (index + n <= m) {
                    if (haystack.substring(index, index + n).equals(needle)) {
                        return index;
                    }
                }

            }

        }

        return -1;

    }
}