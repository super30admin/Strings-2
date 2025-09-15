import java.util.ArrayList;
import java.util.HashMap;

//Idea is to use hashmap to keep track of order string frequenices
//and use Sliding window technique to keep track of frequency counts and update them
// during traversal

//Time Complexity: O(m+n)
//Space Complexity: O(1)
public class StringAnagrams {
   public List<Integer> findAnagrams(String s, String p)
   {
    List<Integer> result = new ArrayList<>();
    int m = s.length();
    int n = p.length();

    HashMap<Character,Integer> hm = new HashMap<>();

    for(char ch:p.toCharArray())
    {
        hm.put(ch,hm.getOrDefault(ch,0)+1);
    }

    int match = 0;
    for(int i=0;i<m;i++)
    {
        char in = s.charAt(i);
        if(hm.containsKey(in))
        {
            int frq = hm.get(in);
            frq--;
            hm.put(in,frq);
            if(frq==0) match++;
        }

        if(i>=n){
            char out = s.charAt(i-n);
            if(hm.containsKey(out)){
                int frq = hm.get(out);
                frq++;
                hm.put(out,frq);
                if(frq==1) match--;
            }
        }

        if(match==hm.size())
        {
            result.add(i-n+1);
        }
    }
    return result;
   } 
}
