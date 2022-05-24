//where m is length of string s and n is length of string p
//TC :O(m+n)/ O(m) as string s will always be bigger
//SC : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if(p==null||p.length()==0) return result;
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0 ;i<p.length();i++)
        {
            char c = p.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int match = 0;
        int prev = 0;
        int i=0;
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)
                    match++;

            }
            i++;
            if(i-prev > p.length())
            {
                char c1 = s.charAt(prev);
                if(hm.containsKey(c1))
                {
                    hm.put(c1,hm.get(c1)+1);
                    if(hm.get(c1)==1)
                        match--;
                }
                prev++;
            }

            if(match==hm.size())
                result.add(prev);
        }
        return result;
    }
}