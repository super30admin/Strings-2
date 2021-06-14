class Solution {
    //Time O(N)
    //Space O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0)
        {
            return result;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0; i<p.length() ; i++)
        {
            map.put(p.charAt(i) , map.getOrDefault(p.charAt(i) , 0)+1);
        }
        int match = 0 , slow = 0;
        for(int i=0 ; i<s.length() ; i++)
        {
            //in
            char in = s.charAt(i) , out = s.charAt(slow); 
            if(map.containsKey(in))
            {
                int count = map.get(in);count--;
                if(count == 0)
                {
                    match++;
                }
                map.put(in , count);
            }
            //out
            if(i >= p.length())
            {
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    if(count == 1)
                    {
                        match--;
                    }
                    map.put(out , count);
                }
                slow++;
            }
            if(match == map.size())
            {
                result.add(i+1-p.length());
            }
        }
        return result;
    }
}