import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TC : O(m+n)
//SC : O(1)

/*
This solution finds all starting indices of anagrams of string `p` in string `s` using a
sliding window and frequency map. It first builds a frequency map of characters in `p`,
then slides a window of length `p` over `s`, updating the frequencies and tracking how
 many characters have matched completely. When a character enters or exits the window,
 the map is updated accordingly, and a `match` counter is adjusted. If the `match` count
 equals the size of the map, it means the current window is a valid anagram. This approach
 runs in linear time with constant space since the alphabet size is fixed.

* */

class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result=new ArrayList<>();

        HashMap<Character,Integer> map=new HashMap<>();

        for(char c:p.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int m=s.length();
        int n=p.length();

        int match=0;


        for(int i=0;i<m;i++)
        {
            char c=s.charAt(i);

            if(map.containsKey(c))
            {
                int freq=map.get(c);
                freq--;
                map.put(c,freq);
                if(freq==0)
                    match++;
            }
            if(i>=n)
            {
                char out=s.charAt(i-n);
                if(map.containsKey(out))
                {
                    int freq=map.get(out);
                    freq++;
                    map.put(out,freq);
                    if(freq==1)
                        match--;
                }
            }

            if(match==map.size())
            {
                result.add(i-n+1);
            }
        }
        return result;
    }
}