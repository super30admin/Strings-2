// Time Complexity : O(M+N) where M is s and n is size of p
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Maintain freq map of p array.
add and remove elements from window.
* */
public class AllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if(s==null || p==null || s.length()*p.length()==0) return result;

        HashMap<Character,Integer> pmap = new HashMap<>();
        for(char ch: p.toCharArray())
            pmap.put(ch, pmap.getOrDefault(ch,0)+1);

        int match=0;
        for(int i=0;i<s.length();i++){
            char in=s.charAt(i);
            if(pmap.containsKey(in)){
                int freq= pmap.get(in);
                freq--;
                if(freq==0) match++;
                pmap.put(in,freq);
            }

            if(i>=p.length()){
                char out= s.charAt(i-p.length());
                if(pmap.containsKey(out)){
                    int freq= pmap.get(out);
                    freq++;
                    if(freq==1) match--;
                    pmap.put(out,freq);
                }
            }

            if(match==pmap.size()) result.add(i+1-p.length());
        }


        return result;
    }
}
