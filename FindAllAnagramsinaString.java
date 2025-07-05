// TC : O(N+M)
// N - length of String p
// M - length of String s

// SC : O(1)
// Hashmap has 26 characters -- lower case only so constant space.

// Approach : 
// Iterate over the pattern string and count the frequencies of the strings.
// Then have a count variable which keeps track of it, 
// When the element in the string is found reduce the count in the haspmap or vice versa.
// The count variable keeps tracks of the no. of occurances.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        int m = s.length();
        int n = p.length();
        for(char x : p.toCharArray()){
            if(!map.containsKey(x))
                map.put(x,0);
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int match = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;++i){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0)
                    match++;
            }
            if(i >= n){
                char x = s.charAt(i-n);
                if(map.containsKey(x)){
                    map.put(x, map.get(x)+1);
                    if(map.get(x) == 1)
                        match--;
                }
            }
            if(match == map.size())
                res.add(i-n+1);
        }
        return res;
    }
}
