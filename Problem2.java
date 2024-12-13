import java.util.*;
class Problem2 {
    //TC:O(M) + O(N)
    //SC:O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        int matchCnt = 0; // we increse it every when freqencyOfP becomes 0; 
        Map<Character,Integer> freqencyOfP = new HashMap<>();

        for(int i=0;i<n;i++){
            char curr = p.charAt(i);
            if(!freqencyOfP.containsKey(curr)){
                freqencyOfP.put(curr,0);
            }
            int freq = freqencyOfP.get(curr);
            freqencyOfP.put(curr,freq+1);
        }

        for(int j=0;j<m;j++){
            char in = s.charAt(j);

            if(freqencyOfP.containsKey(in)){
                int freq = freqencyOfP.get(in);
                freq--;
                if(freq == 0){
                    matchCnt++;
                }
                freqencyOfP.put(in,freq);
            }
            if(j>=n){
                // we reached the window size so remove the outgoing char
                char out = s.charAt(j-n);
                if(freqencyOfP.containsKey(out)){
                    int freqOut = freqencyOfP.get(out);
                    freqOut++;
                    if(freqOut == 1){
                        matchCnt--;
                    }
                    freqencyOfP.put(out,freqOut);
                }
            }
            if(matchCnt==freqencyOfP.size()){
                //this will happen when all the chars in freqencyOfP has become zero
                result.add(j-n+1);
            }
        }
        return result;
    }
}