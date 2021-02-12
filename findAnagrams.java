//Time Complexity: Max(o(m,n))
//Space Complexity: o(n)
//Expln: Sliding window to detemine the first index of anagrams
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int match =0;
        for(int i = 0; i < p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int j =0; j<s.length(); j++)
        {
            if(map.containsKey(s.charAt(j)))
                {
                    char st = s.charAt(j);
                    int val = map.get(st);
                    val--;
                    map.put(st, val);
                    if(val == 0)
                    {
                        match++;
                    }
                }
            if(j-p.length() >=0)
                {
                if (map.containsKey(s.charAt(j-p.length()))){
                    char str = s.charAt(j-p.length());
                    int val = map.get(str);
                    val++;
                    map.put(str, val);
                    if(val == 1)
                    {
                        match--;
                    }
                }
                }
            if(match == map.size())
            {
                res.add(j - p.length() + 1);
            }
        }
        return res;
    }
    
}