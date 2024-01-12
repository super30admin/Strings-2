import java.util.*;

public class AnagramsInString {
    //brute force
//    TC:(m*nlogn)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int j = 0;
        char[] pc = p.toCharArray();
        Arrays.sort(pc);

        for(int i = 0; i <= sLen - p.length(); i++){
            int count = 0;
            j = i + p.length();
            String st = s.substring(i,j);
            // System.out.println(st);
            char[] sc = st.toCharArray();
            Arrays.sort(sc);
            for(int k = 0; k < sc.length; k++){
                if(sc[k]==pc[k]){
                    count++;
                }
                if(count == p.length())
                    ans.add(i);
            }
        }
        return ans;
    }
    public List<Integer> findAnagrams2(String s, String p) {
//        TC:O(m+n)
        int m = s.length();
        int n = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int freq = map.get(in);
                freq--;
                map.put(in, freq);
                if(freq==0) match++;
            }
            if(i >= n){
                char out = s.charAt(i - n);
                if(map.containsKey(out)){
                    int freq = map.get(out);
                    freq++;
                    map.put(out, freq);
                    if(freq==1) match--;
                }
            }
            if(map.size() == match){
                result.add(i-n+1);
            }
        }
        return result;
    }
}
