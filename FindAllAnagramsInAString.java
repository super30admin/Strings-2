class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k=p.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i< p.length(); i++){
            char c= p.charAt(i);
            map.put(c, map.getOrDefault(c,0) +1);
        }

        int match = 0;
        for(int i=0; i<s.length(); i++){
            char in = s.charAt(i);

            //in --> right

            if(map.containsKey(in)){
                int cnt = map.get(in) - 1;
                map.put(in, cnt);
                if(cnt == 0) match++;
            }

            // out going
            if(i >= k){
                char out = s.charAt(i-k);
                if(map.containsKey(out)){
                    int cnt = map.get(out) + 1;
                    map.put(out, cnt);
                    if(cnt == 1) match--;
                }
            }

            if(map.size() == match){
                result.add(i-k+1);
            }
        }
        return result;
    }
}

//Tc : O(n), Sc : O(1)

/**
 * One bruteForce Approach is to take substrings and sort both substring and Pattern string and compare whether it's anagram or not. 
Total TC : nk(klogk) → nk^2logk

Next approach is sliding window →
Using right as “in” and left as “out” pointers, checking all the right pointers inside hashmap and updating its values. Maintaining Match and during ‘in’ increasing Match when value becomes 0 .
Using left as “out” pointer and during out increasing the value by 1 and decreasing the match if it becomes 1.

Note : we are keeping the match the same when the match decreases less than 0.

If Match == map size then adding i-k+1 inside list as a starting index.
TC : O(n), SC : O(1). 

 * 
 */