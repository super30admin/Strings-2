
//Time Complexity:
/*O(length of String * length of frequency array)
For each window we need to check if the final frequncy array has all zero's int it in which case it will be a anagram
*/
//Space complexity:
O(size of frquency array)



// Did this code successfully run on Leetcode :
yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach



class Solution {
    
    //Calculate the frequency for the first window
        int[] frequency = new int[26];
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length(), n = p.length();
        if(n > m) return list;
        
        
        for(int i = 0; i < n; i++){
            frequency[s.charAt(i) - 'a']++;
            frequency[p.charAt(i) - 'a']--;
        }
        
       // calculate frequency For the remaining windows
        for(int i = n; i < m; i++){
            if(areAllZeroes(frequency)){
                list.add(i - n);
            }
            frequency[s.charAt(i) - 'a']++; // when changing window add new char frequency
            frequency[s.charAt(i - n) - 'a']--; // when changing window remove old char freq
        }
        if(areAllZeroes(frequency)){
            list.add(m - n);
        }
        
        return list;
    }
    
    boolean areAllZeroes(int[] cnt_arr){
        for(int i = 0; i < frequency.length; i++){
            if(cnt_arr[i] != 0) return false;
        }
        return true;
    }
    
}