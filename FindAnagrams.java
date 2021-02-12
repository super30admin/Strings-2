// Time Complexity : 0(n)
// Space Complexity : 0(1) bcoz we have constant(26) space for set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        //map for character and count
        HashMap<Character, Integer> map = new HashMap<>();
        //final result list
        List<Integer> result = new ArrayList<>();
        int n = s.length(); int m = p.length();

        //put all characters & their frequency from string p
        for(int i = 0;i < m;i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        //iterate through string s and calculate no. of matches
        for(int i=0;i < n; i++){
            char c = s.charAt(i);
            //if map contains key, update match, reduce frequency
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                if(count == 0)
                    match++;
                map.put(c, count);
            }

            if(i >= m){
                char out = s.charAt(i - m);
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count == 1)
                        match--;
                    map.put(out, count);
                }
            }

            //if match equals map size, add index of sub string in result
            if(match == map.size())
                result.add(i - m + 1);
        }

        return result;
    }
}