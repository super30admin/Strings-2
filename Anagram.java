
// Time Complexity : O(n)
// Space Complexity : O(np)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Sliding Window
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int ns=s.length();
        int np=p.length();

        if(ns<np) return result;

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<np;i++){
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int matched=0;
        for(int i=0;i<ns;i++){
            //incoming
            char c=s.charAt(i);
            if(map.containsKey(c)){
                int cnt=map.get(c);
                cnt--;
                map.put(c,cnt);
                if(cnt==0)
                    matched++;
            }

            //outgoing
            if(i>=np){
                char o=s.charAt(i-np);
                if(map.containsKey(o)){
                    int cnt=map.get(o);
                    cnt++;
                    map.put(o,cnt);
                    if(cnt==1)
                        matched--;
                }
            }

            if(matched==map.size()){
                result.add(i-np+1);
            }
        }
        return result;
    }
}




