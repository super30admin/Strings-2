// Time Complexity : O((s - p)*p)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(s == null || p == null || s.length() == 0 || p.length() == 0)    
            return new ArrayList();
        
        int pArr[] = new int[26];
        int sIndex = 0;
        int sLen = s.length(), pLen = p.length();
        
        //update the pArr based on character count of String p
        for(char ch: p.toCharArray()){
            pArr[ch - 'a']++;
        }
        
        List<Integer> output = new ArrayList();
        
        //iterate over String s
        while(sIndex < sLen - pLen + 1){
            
            while(sIndex < sLen - pLen + 1 &&                
                  pArr[s.charAt(sIndex) - 'a'] == 0){
                sIndex++;
            }
            int sArr[] = new int[26];
            int index = sIndex + pLen - 1;
            int curIdx = sIndex;
            System.out.println("curIdx: "+curIdx+" Index: "+index);
            
            //generate the character count of the substring of length p from the curIdx
            while(curIdx < sLen && curIdx <= index){
                
                sArr[s.charAt(curIdx) - 'a']++;
                curIdx++;
                
            }
            System.out.println("output : "+(curIdx - pLen));
            //if arrays are equal, which means we can add the starting index to the output list
            if(Arrays.equals(sArr,pArr)){
                System.out.println("true");
                output.add(curIdx - pLen);
            }
            sIndex++;
        }
        
        return output;
        
    }
}
