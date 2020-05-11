/**
 * Time Complexity - O(n)
 * Space Comlexity - O(1)
 */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] chars = new int[256];
        int count=0;
        for(char ch: p.toCharArray()){
            chars[ch]++;
            count++;
        }
        char[] sChars = s.toCharArray();
        int left=0, right=0;

        while(right < s.length()){

            if(chars[sChars[right++]]-- >=1) count--;

            if(count==0){
                result.add(left);
            }

            if(right-left == p.length() && chars[sChars[left++]]++>=0) count++;

        }
        return result;
    }

}