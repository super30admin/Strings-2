//Time:O(N)
//Space: O(K)
class Solution {
    public boolean ana(HashMap<Character,Integer> p, HashMap<Character,Integer> check){
         for(char c:check.keySet()){
                if(!p.containsKey(c)){return false;}
             if(!(check.get(c)).equals(p.get(c))){
                    return false;
                }
             } 
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l= new ArrayList<>();
        if(p.length()>s.length()){return l;}
        int [] a= new int[26];
        int prime=3;
        int p1=0;
        HashMap<Character,Integer>hs= new HashMap<>();

     for( int i=0;i<p.length();i++){
        if(!hs.containsKey(p.charAt(i))){
            
           hs.put(p.charAt(i),0); 
        }
         hs.put(p.charAt(i),hs.get(p.charAt(i))+1);
         } 
      // System.out.println(hs);
        int pt1=0;
        int pt2=p.length()-1;
        HashMap<Character,Integer>check= new HashMap<>();
        
        for( int i=0;i<=pt2;i++){
            char c=s.charAt(i);
             
            if(!check.containsKey(c)){
                check.put(c,0);
            }
            check.put(c,check.get(c)+1);
        }
          while(pt2<s.length()){

            if(ana(hs,check)){
             l.add(pt1); 
            }
              check.put(s.charAt(pt1),check.get(s.charAt(pt1))-1);
              if(check.get(s.charAt(pt1))==0){check.remove(s.charAt(pt1)); }
              pt1++;
              pt2++;
              if(pt2>s.length()-1){break;}
         if(!check.containsKey(s.charAt(pt2))){
             check.put(s.charAt(pt2),0);
         }
              check.put(s.charAt(pt2),check.get(s.charAt(pt2))+1);
          }
        return l;
    }
}
