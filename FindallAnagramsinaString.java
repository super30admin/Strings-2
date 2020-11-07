// Time Complexity : O(M + N)- M implies length of string S and N implies length of string p
// Space Complexity : O(1)- As we use two arrays which are of finite length 26
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr1 = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if(m > n) return arr1;
        int[] pfreq = new int[26];
        int[] sfreq = new int[26];
        for(int i = 0;i < m;i++){
            pfreq[p.charAt(i) - 'a']++;
        }
        for(int i = 0;i < m;i++){
            sfreq[s.charAt(i) - 'a']++;
        }
        for(int i = m;i < n;i++){
            if(Arrays.equals(pfreq,sfreq)){
                arr1.add(i - m);
            }
            sfreq[s.charAt(i) - 'a']++;
            sfreq[s.charAt(i - m) -'a']--;
        }
        if(Arrays.equals(pfreq,sfreq)){
            arr1.add(n - m);
        }
        
        return arr1;
    }
}
// Your code here along with comments explaining your approach