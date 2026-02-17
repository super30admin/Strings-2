import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p){
        //base condition to check if source len less than pattern return empty array
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        int n = p.length();
        List<Integer> result = new ArrayList<>();
        //create a hashMap to store pattern characters and its frequency
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //iterate over the source String
        int match=0;
        int m = s.length();
        for(int i=0;i<m;i++){
            //check incoming characters
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in)-1;
                if(cnt==0){
                    match++;
                }
                map.put(in,cnt);
            }
            //check outgoing
            if(i>=n){
                char out=s.charAt(i-n);
                if(map.containsKey(out)){
                    int cnt = map.get(out)+1;
                    if(cnt==1){
                        match--;
                    }
                    map.put(out,cnt);
                }
            }
            //compare if match is same length as map size
            if(match==map.size()){
                result.add(i-n+1);
            }
        }
        return result;
    }
    public static void main(String args[]){
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println("Output is : " +findAnagrams(s,p));
    }
}

//TC:O(n)
//SC:O(1)