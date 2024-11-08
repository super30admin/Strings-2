class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        HashMap<Character,Integer> map= new HashMap<>();
        
        int match=0;
        int m=s.length(), n= p.length();
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<m;i++){
            char in=s.charAt(i);
            if(map.containsKey(in)){
                int freq=map.get(in);
                freq--;
                map.put(in,freq);
                if(freq==0) match++;
                else if(freq<0) match--;
            }
            
            
            if(i>=n){
                char out=s.charAt(i-n);
                if(map.containsKey(out)){
                    int freq=map.get(out);
                    freq++;
                    map.put(out,freq);
                    if(freq==1) match--;
                    else if(freq<=0) match++;
                }
            }
            
            if(match==map.size()){
                result.add(i-n+1);
            }
        }
        return result;
    }
}