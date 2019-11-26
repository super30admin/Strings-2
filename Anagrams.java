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
         char[] word1 = s1.toCharArray();
     char[] word2 = s2.toCharArray();
     Arrays.sort(word1);
     Arrays.sort(word2);
     return Arrays.equals(word1, word2);
    }
}

//Leetcode last test case Time limit exceeded
//SC:O(n) extra character array
//TC:O(nlogn+mlogm) sorting two strings to check anagrams

//Approach: We will traverse to S.length-P.length and compare the substring with P to check whther they are anagram of each other.
// To check whether these two strings are anagram, we will create a isAnagram function, where we will covert the strings to characterArray and sort them and check both thses sorted characterArrays.
