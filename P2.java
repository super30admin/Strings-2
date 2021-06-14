//time-o(n)


//idea- 
//maintain hashmap of char and counts for pattern string
//keep a sliding window equal to pattern length, 
//at every step, incoming char is checked , whether present in hashmap.
//if yes, decrement count, when count reaches zero - means one char match found
//when window size exceeds pattern length, we need to, check outgoing char and
//count is dcecremented, from hashmap, if present
//when count becomes 1, means that character is not present in curr str, so match reduces by 1.
//at the end, check match, if equal to hm size, add i-p.length+1 index, to result


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i = 0;i <p.length(); i++)
        {
            char c = p.charAt(i);
            if(!hm.containsKey(c))
            {
                hm.put(c,0);
            }
            hm.put(c, hm.get(c)+1);
        }
        
        System.out.println(hm.size());
        int match=0;
        
        for(int i=0 ; i< s.length();i++)
        {
            //in
            char in =  s.charAt(i);
            if(hm.containsKey(in))
            {
                int cnt = hm.get(in);
                cnt--;
                hm.put(in,cnt);
                if(cnt == 0)
                {
                    match++;
                }                
            }
           
            //out
            if(i>= p.length())
            {
                char out = s.charAt(i-p.length());
                System.out.println(out);
                if(hm.containsKey(out))
                {
                    int cnt = hm.get(out);
                    cnt++;
                    hm.put(out,cnt);
                    if(cnt == 1)
                    {
                        match--;
                    }                
                }
            }
            
             if(match == hm.size())
            {
                result.add(i-p.length()+1);
            }
        }
        
        return result;
    }
}