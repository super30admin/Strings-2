class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < s.length() - p.length()+1; i++){
            String str = s.substring(i, p.length()+i);
            if(isAnagram(str, p)){
                indices.add(i);
            }
        }
        return indices;
    }
    
    private boolean isAnagram(String s1, String s2) {
        char[] aArr = s1.toCharArray(), bArr = s2.toCharArray();
        if (aArr.length != bArr.length)
            return false;
        int[] counts = new int[26]; 
        for (int i = 0; i < aArr.length; i++){
            counts[aArr[i]-97]++;  
            counts[bArr[i]-97]--;  
        }
        // If the strings are anagrams, the counts array will be full of zeros
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }
}


//SC:O(n) extra character array
//TC:O(N) 

//Approach:Store the string char in char array and compare the two char arrays to check for anagram
