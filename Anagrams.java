//Time - O(n)
//spae - O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i =0; i< m; i++){
            char c = p.charAt(i);
            count.put(c, count.getOrDefault(c,0) +1);
        }
        
        int match =0;
        for(int i =0; i< s.length(); i++){
            char in = s.charAt(i);
            if(count.containsKey(in)){
                int c = count.get(in);
                c--;
                count.put(in, c);
                if(c==0){
                    match++;
                }
            }
            if(i >= m){
                char out = s.charAt(i-p.length());
                if(count.containsKey(out)){
                int c = count.get(out);
                c++;
                count.put(out, c);
                if(c == 1){
                    match--;
                }
                }
            }
            if(match == count.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}