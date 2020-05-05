//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    int[] counts = new int[26];
    int[] countp = new int[26];
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(s==null || s.length()==0){
            return result;
        }
        
        if(p.length() > s.length()){
            return result;
        }
        
        int slen = s.length();
        int plen = p.length();
        int index = 0;
        for(int i=0; i<plen;i++){
            counts[s.charAt(i)-'a']++;
            countp[p.charAt(i)-'a']++;
        }
        
        if(isAnagrams()){
            result.add(index);
        }
        
        for(int i=plen; i<slen;i++){
            counts[s.charAt(index)-'a']--;
            counts[s.charAt(i)-'a']++;
            if(isAnagrams()){
                result.add(index+1);
            }
            index++;
        }
        
        return result;
        
    }
    
    private boolean isAnagrams(){
        for(int i=0; i<26;i++){
            if(counts[i]!=countp[i]){
                return false;
            }
        }
        
        return true;
    }
}