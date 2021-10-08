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
       
        int p1 = 0 ; int p2=0;
        int n = s.length();
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> codeMap = new HashMap<>();
        for(int i = 0 ; i < p.length(); i++)
        {
            codeMap.put(p.charAt(i),codeMap.getOrDefault(p.charAt(i),0)+1);
        }
        int matches =0;
      
        char inComing = '!';
         char outGoing = '!';
        while(p2 <= n && p1 <= n)
        {
            if(p1>0)
                outGoing = s.charAt(p1-1);
              if(p2>=p.length())
              {
                   inComing = s.charAt(p2-1);
              }
                  
           while(p2<p.length())
            {
                char c = s.charAt(p2);
                if(codeMap.containsKey(c))
                { 
                    codeMap.put(c,codeMap.get(c)-1);
                    if(codeMap.get(c) ==0)
                     matches++;
                }
               p2++;
            }
            
            if(inComing != '!')
            {
                char c = inComing;
                 if(codeMap.containsKey(c))
                { 
                     codeMap.put(c,codeMap.get(c)-1);
                     if(codeMap.get(c) == 0)
                     matches++;
                }
            }
            if(outGoing != '!')
            {
                 char c = outGoing;
                if(codeMap.containsKey(c))
                { 
                    codeMap.put(c,codeMap.get(c)+1);
                    if(codeMap.get(c) ==1)
                    matches--;
                 }
                
            }
            if(matches == codeMap.size())
            {
                result.add(p1);
                
            }
           
           p1++;
            p2++;
        }
        return result;
    }
}