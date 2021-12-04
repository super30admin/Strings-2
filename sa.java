//o(n) time and const space for hashmap
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);


        }
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            //incoming char
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in, cnt);
                if(cnt ==0){
                    match++;
                }
            }


            //outgoing char
            if(i > p.length() - 1){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out, cnt);
                    if(cnt ==1){
                        match--;
                    }
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
//O(N) time and o(n) space
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int m = haystack.length(); int n = needle.length();
        int i = 0; // source
        int j = 0;  //pattern
        int [] lps = lps(needle);

        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                if(j == n) return i - n;
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j - 1];
            } else if(haystack.charAt(i) != needle.charAt(j) && j ==0){
                i++;
            }
        }
        return -1;
    }
    private int[] lps(String needle){
        int [] lps = new int[needle.length()];
        lps[0] = 0;
        int i = 1; int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            } else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}