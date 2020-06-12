//Time complexity : O(m + n)
//Space complexity : O(n) (Hashmap of that string)
//Runs successfully on leetcode
//No problem

//Here we will be keeping a window on the string in which we need to find anagrams
//We'll be maintaing each characters existing in the window
//If we move the window forward, we will be removing the last element and adding the new one
//If the hashmap of the string we need to find anagrams of matches the hashmap we are maintaing, we add the index


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Strings_2_Problem_2_findAnagrams {
    List<Integer> list;
    public List<Integer> findAnagrams(String s, String p) {
        list = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(Character c : p.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int slow = 0;
        int fast = 0;
        HashMap<Character,Integer> hm2 = new HashMap<>();
        while(fast<s.length())
        {
            char c = s.charAt(fast);
            hm2.put(c,hm2.getOrDefault(c,0)+1);
            if(hm.equals(hm2))
            {
                list.add(slow);
            }
            if(fast - slow + 1 == p.length())
            {
                char del = s.charAt(slow);
                hm2.put(del,hm2.get(del)-1);
                hm2.remove(s.charAt(slow),0);
                slow++;
            }
            fast++;
        }
        return list;
    }
}
