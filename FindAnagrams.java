import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    //tc : O(n*(mlogm)); m = len of p; n = len of s
    //sc : O(m)
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || s == null || p.length() == 0 || p == null) return list;

        char[] temp = p.toCharArray();
        Arrays.sort(temp);
        String pNew = String.valueOf(temp);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + p.length());
            char[] ch = sub.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if (str.equals(pNew)) {
                list.add(i);
            }
        }
        return list;
    }
}
