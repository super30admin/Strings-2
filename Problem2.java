public class Problem2 {
    class Solution {
        //t.c ->O(m+n)
        //s.c -> O(1)
        public List<Integer> findAnagrams(String s, String p) {
            if(s== null || s.length() ==0 || p.length()>s.length()){
                return new ArrayList<>();
            }

            int match = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            for(int i = 0;i<p.length();i++){//put char of p with its freq
                char c = p.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }

            for(int i =0 ;i<s.length();i++){//now iterate over s
                char incoming = s.charAt(i);
                if(map.containsKey(incoming)){//check if map contains char of s
                    int count = map.get(incoming);
                    count--;//dec the freq
                    if(count == 0){
                        match++;
                    }
                    map.put(incoming,count);//put back the char with new freq.
                }
                if(i >= p.length()){//if i becomes greater than p's length then we've outgoing char , this is opp of incoming
                    char outgoing = s.charAt(i-p.length());
                    if(map.containsKey(outgoing)){
                        int count = map.get(outgoing);
                        count++;//inc the freq
                        if(count == 1){
                            match--;
                        }
                        map.put(outgoing,count);//put back the char with new freq.
                    }
                }
                if(match == map.size()){//it means we've found that all char matches
                    result.add(i-p.length()+1);
                }
            }
            return result;
        }
    }
}
