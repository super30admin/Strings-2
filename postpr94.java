//Time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer>map= new HashMap<>();
        if(s==null ||p==null ||s.length()==0||p.length()==0)return result;
        int match=0;
        //Storing in hashmap
        for(char c :p.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            //incoming characters
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)match++;
            }
            //outgoing characters
            if(i>=p.length()){
                c=s.charAt(i-p.length());
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1)match--;
                }
            }
            
            if(match==map.size())result.add(i-p.length()+1);
            
        }
        return result; 
    }
}