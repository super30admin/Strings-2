//Time Complexity: O(m+n)
//Space Complexity: O(1) 26 characters

/*
 * In this approach we first put all the chars of the pattern string in the hashmap. Then we maintain a window of pattern string length on the source string.
 * We check the incoming and outgoing chars, if the incoming is there in the map then we decrement its freq count in the map. If the count is 0 then there is a match 
 * and we increment match count we add the updated count to the map. For outgoing count once we are chars after the length of pattern we check if it is there in the map,
 * we increment the count and if it is 1 then we decrement the match and update the count value in map. The start of the window where the match count is equal to the size of 
 * the map will give us correct index of the anagram.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int m = s.length();
        int n = p.length();
        int match = 0;
        for(int i =0;i<n;i++){   //n
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i =0;i< s.length();i++){ //m
            char c = s.charAt(i);  //incoming char
            if(map.containsKey(c)){
                int ct = map.get(c) -1;
                if(ct == 0){
                    match++;
                }
                map.put(c,ct);
            }
            if(i>=n){
                char ch = s.charAt(i-n);  //outgoing char
                if(map.containsKey(ch)){
                    int ct = map.get(ch) +1;
                    if(ct == 1){
                        match--;
                    }
                    map.put(ch,ct);
                }
            }
            if(match == map.size() ){
                result.add(i-n+1);
            }
        }
        return result;
    }
}