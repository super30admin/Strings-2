//Time complexity:O(m+n)
//Space complexity:O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList();
        Map<Character,Integer> map=new HashMap();
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int i=0;
        int match=0;
        for(i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    match++;
                }
            }
            if(i>=p.length()){
                c=s.charAt(i-p.length());
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)==1){
                        match--;
                    }
                }
            }
            if(match==map.size()){
                result.add(i-p.length()+1);
            }

        }
        return result;
    }
} 