/**
LeetCode Submitted : 35/36 test case passes
Time Complexity : O(O(s.length)*O((s.length)log(S.length))
Space Complexity : O(1)


Brute force solution (Not optimal) the idea is to sort anagram(p) and then search for each possible substring in the s string.
**/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> results = new ArrayList<>();
        
        if(s.equals(p))
            return new ArrayList<>(0);
        
        if(s.length() < p.length())
            return results;
        
        return calculateAnagrams(s,p);
    }
    
    private List<Integer> calculateAnagrams(String s, String p){
        List<Integer> r = new ArrayList<>();
        char[] anagrams = p.toCharArray(); 
        Arrays.sort(anagrams);
        
        for(int i = 0; i<s.length();i++){
            String temp = s.substring(i,Math.min(s.length(),i + p.length()));
            char[] test = temp.toCharArray();
            Arrays.sort(test);
            if(Arrays.equals(test,anagrams)){
                //System.out.println(i);
                r.add(i);
            }
                
        }
        return r;
    }
}
