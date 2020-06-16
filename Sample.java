class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0)
            return 0;
        int nc=0;
        
        for(int i=0;i<haystack.length()-needle.length()+1;i++)
        {

            if(haystack.charAt(i)==needle.charAt(0))
            {
                String x=haystack.substring(i,i+(needle.length()));
                System.out.println(x);
                    if(x.equals(needle))
                        return i;
            }
        }
        return -1;
    }
}
-------------------------------------------------------------------------------------
//Time Complexity:O(len(s)+len(p))
//Space Complexity:O(1)
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();

    Map<Character, Integer> pCount = new HashMap();
    Map<Character, Integer> sCount = new HashMap();
 
    for (char ch : p.toCharArray()) {
      if (pCount.containsKey(ch)) {
        pCount.put(ch, pCount.get(ch) + 1);
      }
      else {
        pCount.put(ch, 1);
      }
    }

    List<Integer> output = new ArrayList();
   
    for (int i = 0; i < ns; ++i) {
    
      char ch = s.charAt(i);
      if (sCount.containsKey(ch)) {
        sCount.put(ch, sCount.get(ch) + 1);
      }
      else {
        sCount.put(ch, 1);
      }
     
      if (i >= np) {
        ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        }
        else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }
    
      if (pCount.equals(sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}

------------------------------------------------------------------------