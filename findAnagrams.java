//TC = O(m)
//SC =O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(n > m) return result;
        int match = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            char c = .charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < m; i++)
        {
            char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int cnt = map.get(in);
                cnt--;
                if(cnt == 0) match++;
                map.put(in, cnt);
            }

            if(i >=n)
            {
                char out = s.charAt(i-n);
                if(map.containsKey(out))
                {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out, cnt);
                }
            }
            if(match == n)
            {
                result.add(i-n+1);
            }
        }
        return result;
    }
}
