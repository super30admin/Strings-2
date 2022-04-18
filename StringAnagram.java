
// Time Complexity : O(n) where n is size of string s
// Space Complexity : O(m) where p is size of string p
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] pFreq = new int[26];
        for(int i=0; i<p.length(); i++){
            pFreq[p.charAt(i)-'a']++;
        }

        int[] sWindowFreq = new int[26];

        int i=0;  //end of the window

         //window for s wich will start from 0 till p.length
        while(i < s.length()){

            //incoming element
            sWindowFreq[s.charAt(i)-'a']++;


            //outgoing element
            if(i >= p.length()){
                sWindowFreq[s.charAt(i - p.length())-'a']--;

            }

            if(Arrays.equals(pFreq,sWindowFreq)){
            result.add(i-p.length()+1);

        }
           i++;
        }

        return result;

    }
}
