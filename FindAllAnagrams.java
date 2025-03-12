class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int sl = s.length();
        int pl = p.length();
        if(pl>sl)
        return result;
        for(int i=0;i<p.length();i++)
        {
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int match =0;
        for(int i=0;i<sl;i++)
        {
            //in
            char in =s.charAt(i);
            if(map.containsKey(in))
            {
                int count = map.get(in);
                count--;
                if(count==0)
                match++;
                map.put(in,count);
            }

            //out
            if(i>=pl)
            {
            char out = s.charAt(i-pl);
            if(map.containsKey(out))
            {
            int count = map.getOrDefault(out, 0);
            count++;
            if(count==1)
             match--;
            map.put(out,count);
            }
            }

        if(match == map.size())
        {
            result.add(i-pl+1);
        }

        }
        return result;

    }
}

//Time Complexity (TC): O(s + p)
//Space Complexity (SC): O(s)
//p is the length of string p
//s is the length of string s