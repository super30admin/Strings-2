//Time - O(n)
//Space - O(1)


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int[] sarr = new int[26];
        int[] parr = new int[26];
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            parr[ch-'a']++;
        }
      
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            sarr[ch-'a']++;
            if(i>=p.length()){
                char ch1 = s.charAt(i-p.length());
                sarr[ch1-'a']--;
            }
            if(Arrays.equals(sarr,parr)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
}
