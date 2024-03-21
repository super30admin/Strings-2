// Time Complexity : O(m), m will always be bigger than n
// Space Complexity : O(1), at max there will be only 26 enteries in map.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : maintain a window and keep modifying the map according to incoming and outgoing char


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int m = s.length();
        int n = p.length();

        if(m < n){
            return result;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        //Freq of characters in p
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //to track number of characters satisfied in p
        int matches = 0;

        for(int i = 0 ; i < m ; i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
               int cnt = map.get(in);
               map.put(in,--cnt);
               if(cnt == 0) matches++;
            }
            //window of size n
            if(i >= n){
                char out = s.charAt(i-n);

                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    map.put(out,++cnt);
                    if(cnt == 1) matches--;
                }
            }  

            //found anagram
            if(matches == map.size()){
                result.add(i-n+1); //start idx
            }
        }

        return result;
    }
}