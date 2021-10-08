// Time Complexity :O(m+n)
// Space Complexity :O(n) m = length of pattern
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* put all the char of the given pattern in hashmap along with chars'frequency. forcus of incoming letter and outgoing character. in starting all character upto pattern's length will be consdired as incoming char after this char at index i -p.length will be considered as outgoing character. if incoming char is in hashmap then dec its freq count by 1 if this count ==0 then match++. same check from outgoing character if map contaings out character then inc it's count by 1 and if this count ==1 then dec the match by 1 (if match equals to number of keys in map i.e size of map it means charcater from i - p.length to i forms a anagram hence add i - p.length +1 in result list. check same from i=0 to s.length. */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() ==0 || p.length() == 0 || p.length()>s.length())
            return  result;
       
    
        Map<Character,Integer> map = new HashMap<>();
       // Map<Character,Integer> codeMap = new HashMap<>();
        for(int i = 0 ; i < p.length(); i++)
        {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int matches =0;
      
      
        for(int i =0 ; i < s.length();i++)
        {
             char in = s.charAt(i);
            if(map.containsKey(in))
            {
                int cnt = map.get(in);
                cnt--;
                map.put(in,cnt);
                if(cnt ==0)
                    matches++;
            }
            
            if(i>=p.length())
            {
                char out = s.charAt(i-p.length());
                if(map.containsKey(out))
                {
                    int cnt = map.get(out);
                    cnt++;
                     map.put(out,cnt);
                    if(cnt ==1)
                        matches--;
                }
            }
            
            if(matches == map.size())
            {
                result.add(i-p.length()+1);
                
            }
           
          
        }
        return result;
    }
}