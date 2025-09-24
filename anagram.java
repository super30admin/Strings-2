class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        int slen=s.length();
        HashMap<Character,Integer>m=new HashMap<>();
        for(char c:p.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        int match=0;
        for(int i=0;i<slen;i++){
            char in=s.charAt(i);
            if(m.containsKey(in)){
                int freq=m.get(in);
                freq--;
                m.put(in,freq);
                if(freq==0)match++;
                            }
            if(i>=p.length()){
                char out=s.charAt(i-p.length());
                if(m.containsKey(out)){
                    int count=m.get(out);
                    count++;
                    m.put(out,count);
                    if(count==1)match--;
                }
            }
            if(match==m.size()){
                res.add(i-p.length()+1);
            }         
        }
        return res; 
    }
}