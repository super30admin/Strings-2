// Time Complexity : O(N + M), N is length of source string, M is length of check string
// Space Complexity : O(1), both arrays will have constant space of 26 chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class findAllAnagramsInStr {
    public List<Integer> findAnagrams(String s, String p) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
         List<Integer> list = new ArrayList<>();

         if(s.length()<p.length())
             return list;

         for(int i=0; i<p.length(); i++){
             freq1[s.charAt(i)-'a']++;
             freq2[p.charAt(i)-'a']++;
         }

         int start=0;
         int end=p.length();

         if(Arrays.equals(freq1,freq2))
             list.add(start);

         while(end<s.length()){

             freq1[s.charAt(start)-'a']--;
             freq1[s.charAt(end)-'a']++;

             if(Arrays.equals(freq1,freq2))
             list.add(start+1);

             start++;
             end++;
         }
       return list;  
 }
}
