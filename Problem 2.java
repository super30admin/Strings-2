//Time Complexity: O(m + n) where m is the length of s and n is the length of p
//Space Complexity: O(n)

//Successfully runs on leetcode: 17 ms

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> hmap = new HashMap<>();
        int match = 0;
        for(int i = 0; i < p.length(); i++)
        {
            char c = p.charAt(i);
            hmap.put(c, hmap.getOrDefault(c,0)+1);
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            char in = s.charAt(i);
            if(hmap.containsKey(in))
            {
                int count = hmap.get(in);
                count--;
                if(count == 0) 
                    match++;
                hmap.put(in, count);
            }
            if(i >= p.length())
            {
                char out = s.charAt(i - p.length());
                if(hmap.containsKey(out))
                {
                    int count = hmap.get(out);
                    count++;
                    if(count == 1) 
                        match--;
                    hmap.put(out, count);
                }
            }
            if(match == hmap.size())
                result.add(i - p.length() + 1);
        }
        return result;
    }
}