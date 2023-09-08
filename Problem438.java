class Problem438 {
  //TC=O(m+n)
  //SC=O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int sLength=s.length();
        int pLength=p.length();
        HashMap<Character, Integer> pMap=new HashMap<>();
        for(int i=0;i<pLength;i++){
            char c=p.charAt(i);
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int match=0;
        for(int i=0;i<sLength;i++){
            //process the incoming character
            char in=s.charAt(i);
            if(pMap.containsKey(in)){
                int cnt=pMap.get(in)-1;
                pMap.put(in,cnt);
                if(cnt==0)
                    match++;
            }
            //process the outgoing character when i becomes greater than plength
            if(i>=pLength){
                char out=s.charAt(i-pLength);
                if(pMap.containsKey(out)){
                    int cnt=pMap.get(out)+1;
                    pMap.put(out,cnt);
                    if(cnt==1)
                        match--;
                }
            }
            if(match==pMap.size())
                result.add(i-pLength+1);
        }
        return result;
    }
}
