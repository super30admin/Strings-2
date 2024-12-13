// Approach : Sliding window - create window of size P and go through source string S and 
// remove outgoing character and add incoming character so that window size is maintained
// Time : O(m + n)
// Space : O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // store the frequency of chars of p
        for(char ch: p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int match = 0;
        int m = s.length();
        int n = p.length(); // anagram
        // now go through source string S 
        for(int i=0;i<m;i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){ // check incoming character in p map
                int freq = map.get(in);
                freq--;
                map.put(in,freq); // Add incoming charcter and its freq to map
                if(freq ==0){
                    // if freq becomes zero implies all character with their count is included/matched
                    match++;
                }
            }
            if(i>=n){
                // will have outgoing character
                char out = s.charAt(i-n);
                if(map.containsKey(out)){
                    int freq = map.get(out);
                    freq++; // putting back the character frequency in map
                    map.put(out,freq);
                    if(freq == 1){
                        match--; // putting back the original mapped character
                    }
                }
            }
            if(map.size() == match){
                result.add(i-n+1);
            }
        }

        return result;

    }
}