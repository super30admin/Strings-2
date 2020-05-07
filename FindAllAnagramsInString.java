// 43.
// time - O(n + m) -> n is the length of string s and m is length of p
// space - constant 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pFreq = new int[26]; //freq arrays for s and p
        int[] sFreq = new int[26];
        //find freq of chars in p
        for(int i = 0; i < p.length(); i++)
        {
            char ch = p.charAt(i);
            pFreq[ch - 'a']++;
        }
        int start = 0; //both start and end iterates through s
        int end = 0;
        while(end < s.length())
        {
            char chEnd = s.charAt(end);
            char chStart = s.charAt(start);
            //end - start + 1 is the snippet size
            //as long as snippet is smaller than p, add end to s freq and increase end
            if(end - start + 1 < p.length()) 
            {
                sFreq[chEnd - 'a']++;
                end++;
            }
            //if snippet becomes equal, add end to freq of s, increase end, compare sfreq and pfreq, add to result if same
            else if(end - start + 1 == p.length()) 
            {
                sFreq[chEnd - 'a']++;
                end++;
                if(isAnagram(sFreq, pFreq))
                {
                    result.add(start);
                }
            }
            //if snippet becomes larger, reduce start char count and increase start
            else // end - start + 1 > p.length()
            {
                sFreq[chStart - 'a']--;
                start++;
            }
        }
        return result;
    }
    
    private boolean isAnagram(int[] sFreq, int[] pFreq) {
        for(int i = 0; i < sFreq.length; i++) //compare both arrays and return true if both are same
        {
            if(sFreq[i] != pFreq[i])
            {
                return false;
            }
        }
        return true;
    }
}
