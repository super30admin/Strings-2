/*Running Time Complexity: O(n)
Space Complexity: constant
Successfully Run and Compiled on leetcode
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        //2 pointer with using hmap
        int matches = 0;
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            hmap.put(c,hmap.getOrDefault(c,0)+1);
            
        }
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            //in
            if(hmap.containsKey(in)){
                int cnt = hmap.get(in);
                cnt--;
                hmap.put(in,cnt);
                if(cnt==0) matches++;
                }
            
            //out
            if(i>=p.length()){
                char out= s.charAt(i-p.length());
                if(hmap.containsKey(out)){
                    int cnt = hmap.get(out);
                    cnt++;
                    hmap.put(out,cnt);
                    if(cnt == 1) matches--;
                }
            }
            // System.out.println(hmap);
            // System.out.println(matches);
            if(matches == hmap.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}