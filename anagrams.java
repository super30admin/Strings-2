//TC: O(n-p) n = length of the actual string
//SC: O(p) p = length of anagram word to be stored in hashmap
//leetcode: successful

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> h1 = new HashMap<>();
        int s1= s.length();
        int p1 = p.length();
        for(int i=0;i<p1;i++){
            char ch = p.charAt(i);
            h1.put(ch,h1.getOrDefault(ch,0)+1);
        }
        int match =0;
        for(int i=0;i<s1;i++){
            char in =s.charAt(i);
            if(h1.containsKey(in)){
                h1.put(in,h1.getOrDefault(in,0)-1);
            if(h1.get(in)==0)
                match++;
            }
            if(i>=p1){
                char out = s.charAt(i-p1);
                if(h1.containsKey(out)){
                    h1.put(out,h1.getOrDefault(out,0)+1);
                if(h1.get(out)==1)
                    match--;
                }
            }
            
            if(h1.size()==match)
                res.add(i-p1+1);
        }
        return res;
    }
}

