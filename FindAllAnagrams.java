public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match = 0;
        if(p.length()>s.length()) return result;
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s.length();i++){
            // incoming character
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                map.put(in,cnt);
                if(cnt==0) match++;
            }

            // outgoing character
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    map.put(out,cnt);
                    if(cnt==1) match--;
                }
            }
            if(match==map.size()) result.add(i-p.length()+1);
        }
        return result;
    }
}

// TC - O(max(m,n)) ~ O(n) , m - pattern , n - string
// SC - O(1)