//TC:O(p.length()+(m-p.length()+1)*26)
//SC:o(1)


class Solution {
    public List<Integer> findAnagrams(String s, String p)
    {
      List<Integer> list = new ArrayList<>();
      int cntp[] = new int[26];
      int cnts[] = new int[26];
        for(int i=0;i<p.length();i++)
        {
          cntp[p.charAt(i)-'a']++; 
        }
        
        int j=0;
        int k=0;
        while(j<s.length())
        {
          if(k<p.length()) 
          {
             cnts[s.charAt(j)-'a']++; 
             k++;
             j++;
          } 
          else
             break;
        }
        
        if(checkAnagrams(cnts,cntp))
           list.add(j-p.length());
        
        while(j<s.length())
        {
            cnts[s.charAt(j)-'a']++;
            cnts[s.charAt(j-p.length())-'a']--;
            if(checkAnagrams(cnts,cntp))
               list.add(j-p.length()+1);
            j++;
        }
        
       return list; 
    }
    
    public boolean checkAnagrams(int[] cnts,int[] cntp)
    {
       for(int i=0;i<26;i++) 
           if(cnts[i]!=cntp[i])
               return false;
        
        return true;
    }
    
    
}