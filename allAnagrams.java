// Time Complexity : O(N) where N is the number of characters in either strings 's'
// Space Complexity : O(N) where N is the number of anagrams
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int[] visited;
    int sLength;
    int pLength;
    public List<Integer> findAnagrams(String s, String p) {
        Solution sol = new Solution();
        sLength = s.length();
        pLength = p.length();
        List<Integer> answer = new ArrayList<Integer>();
        visited = new int[sLength+1];
        for(int i=0;i<=sLength;i++) {
            if(visited[i] == 0 && i+pLength<=sLength && sol.isAnagram(s.substring(i, i+pLength), p, i)) {
                answer.add(i);
            }
        }
        return answer;
        
    }
    
    public boolean isAnagram(String s, String p, int index) {
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        int[] count = new int[256];
        
        for(int i = 0; i < str1.length; i++) {
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }
        
        if (str1.length != str2.length)
            return false;
 

        for(int i = 0; i < 256; i++) {
            if (count[i] != 0)
                return false;
        }
        for(int i = 0; i < pLength; i++) {
            visited[i+index] = 1;
        }
        return true;
    }
}
