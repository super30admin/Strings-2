//time - O(m+n) m = s.length(), n = p.length();
//space - O(1) since hashmap will contain in this case at max 26 letters
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s==null || s.length()==0) return result;
        int p1 = 0, p2 = 0;
        Map<Character, Integer> map = new HashMap<>();
        int match = 0;

        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        while(p1 < s.length()){
            char charIn = s.charAt(p1);
            if(map.containsKey(charIn)){
                int count = map.get(charIn);
                count--;
                map.put(charIn, count);
                if(count==0) match++;
                if(match==map.size()) result.add(p2);
            }
            p1++;
            if(p1-p2==p.length()){
                char charOut = s.charAt(p2);
                if(map.containsKey(charOut)){
                    int count = map.get(charOut);
                    count++;
                    map.put(charOut, count);
                    if(count==1) match--;
                }
                p2++;
            }
        }

        return result;
    }
}
