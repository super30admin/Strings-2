import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    //Time Complexity: O(M+N) -> where m and n are the lengths of the string
    //Space Complexity: Constant as we are maintaining 2 hashmaps which can take 26 characters max
    public List<Integer> findAnagrams(String s, String p){

        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();
        int ptr;
        for(int i =0; i< p.length(); i++){
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0)+ 1);
        }

        for(ptr = 0; ptr< s.length(); ptr++){

            if(pCount.equals(sCount)){
                indexes.add(ptr - p.length());
            }
            if(ptr <= (p.length() - 1)){
                sCount.put(s.charAt(ptr), sCount.getOrDefault(s.charAt(ptr), 0)+ 1);
            }else{
                sCount.put(s.charAt(ptr), sCount.getOrDefault(s.charAt(ptr), 0)+ 1);
                sCount.put(s.charAt(ptr- p.length()), sCount.getOrDefault(s.charAt(ptr- p.length()), 0)- 1);
                if(sCount.get(s.charAt(ptr- p.length())) == 0 ){
                    sCount.remove(s.charAt(ptr- p.length()));
                }
            }

        }
        if(pCount.equals(sCount)){
            indexes.add(ptr - p.length());
        }

        return indexes;

    }

}
