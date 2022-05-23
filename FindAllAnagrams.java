//TC = O(N) where N is s.length();
//SC = O(M) where M is p.length();

import java.util.*;
public class FindAllAnagrams {
    
    public static List<Integer> findAnagrams(String s, String p)
    {
        if(p == null || p.length() == 0 || p.length() > s.length())
        {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        HashMap<Character,Integer> map = new HashMap<>();


        for(int i =0;i<p.length();i++)
        {
            char c = p.charAt(i);

            map.put(c, map.getOrDefault(c,0)+1);
        }

        int match =0;
        for(int i=0;i<s.length();i++)
        {
            char in = s.charAt(i);

            if(map.containsKey(in))
            {
                int count = map.get(in);
                count --;

                if(count == 0)
                {
                    match ++;
                }

                map.put(in, count);
            }

            if(i>=p.length())
            {
                char out = s.charAt(i - p.length());
                
                    if(map.containsKey(out))
                    {
                        int count = map.get(out);
                        count ++ ;

                        if(count == 1)
                        {
                            match --;
                        }

                        map.put(out, count);
                    }
                
            }
                if(match == map.size())
                {
                    result.add(i - p.length()+1);
                }
            
        }

        return result;
    }
    
    public static void main(String args[])
    {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }
}
