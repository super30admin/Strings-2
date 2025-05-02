import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//TC: O(m+n)
//SC:O(1)
class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int match=0;
        int i=0;
        int j=0;
        int n=s.length();
        while(j<n){
            char in=s.charAt(j);
            if(map.containsKey(in)){
                int v=map.get(in);
                v--;
                if(v==0){
                    match++;
                }
                map.put(in,v);
            }
            if(j>=p.length()){
                char out=s.charAt(i);
                if(map.containsKey(out)){
                    int v=map.get(out);
                    v++;
                    if(v==1){
                        match--;
                    }
                    map.put(out,v);
                }
                i++;
            }
            if(match==map.size()){
                res.add(i);
            }
            j++;
            
        }
        return res;
    }
}