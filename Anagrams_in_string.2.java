//sol 2 hashmap: first add all the element and their frequency of p in hashmap, then slide the window
//Time Complexity = O(N)+O(M) ; N = size of s ; M = size of p
//Space Complexity= O(M)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        //base
        if(p.length() > s.length())return result;
        //add all elements to HashMap

        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i =0; i< p.length(); i++){
            char c = p.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int match=0;

        //logic
        for(int i =0 ; i< s.length() ; i++){
            //in
            char in = s.charAt(i);
            if(freq.containsKey(in)){
                freq.put(in,freq.get(in)-1);
                if(freq.get(in)==0){
                    match++;
                }
            }

            //out
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                if(freq.containsKey(out)){
                    freq.put(out,freq.get(out)+1);
                    if(freq.get(out)==1) match--;

                }
            }
            if(match == freq.size()){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}