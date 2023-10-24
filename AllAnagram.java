import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TC will O(n + m), where n and m are the length of strings
//SC will be O(1)

class AllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;


        for(int i =0; i<p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }


        for(int i = 0; i< s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count-- ;
                if(count == 0){
                    match++;
                }
                map.put(in, count);
            }

            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count == 1){
                        match--;
                    }
                    map.put(out, count);
                }
            }

            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }


    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc" ;
        AllAnagram obj = new AllAnagram();
        System.out.println(obj.findAnagrams(s,p));
    }
}