class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // using sliding window, first keep track of counts of chars in pattern p, then loop through s and check, if its in hashmap, decrease the count, when count becomes zero, add one to result, when the window size becomes greater than size of p, start removing starting elem in the window and change its count accordingly
        //TC-O(m+n)SC-O(n)
        // hashmap to track p
        HashMap<Character,Integer> hm = new HashMap<>();
        int m = s.length();
        int n = p.length();
        int result=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            char c = p.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        // loop through s
        for(int j =0;j<m;j++){
            char c = s.charAt(j);
            if(hm.containsKey(c)){
                int co=hm.get(c);
                co--;
                hm.put(c,co);
                if(co==0){
                    result++;
                }
            }

            if(j>=n){
                char c2 = s.charAt(j-n);
                if(hm.containsKey(c2)){
                    int co=hm.get(c2);
                    co++;
                    hm.put(c2,co);
                    if(co==1){
                        result--;
                    }
                }
            }
            
            if(result==hm.size()){
                ans.add(j-n+1);
            }
        }
        return ans;
    }
}