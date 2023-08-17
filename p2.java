// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        List<Integer> result = new ArrayList<>();
        //null case
        if(n>m) return result;
        HashMap<Character, Integer> map = new HashMap<>();

        //Inserting characters of p in hashmap with it's frequency
        for(int i=0; i<n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        //Counter to keep the count if we have found all the characters of p
        int counter =0;



        //Going through all the characters in s
        for(int i=0; i<m; i++){
            //Process the characters being remobed from the range
            if(i>=n){
                char a = s.charAt(i-n);
                if(map.containsKey(a)){
                    int cnt = map.get(a);
                    cnt = cnt + 1;
                    if(cnt == 1) counter--;
                    map.put(a,cnt);
                }
            }

            //Process the incoming characters in range
            char b = s.charAt(i);
            if(map.containsKey(b)){
                int cnt = map.get(b);
                cnt = cnt-1;
                if(cnt == 0) counter++;
                map.put(b,cnt);
            }

            //If we find all the characters with their frequency, store the start in result
            if(counter == map.size()) result.add(i-n+1);
        }

        return result;
    }
}