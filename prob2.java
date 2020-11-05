
// Time complexity = O(len p * 26 letters)
// Space complexity = O(len p * 26 letters) 

class Solution {
       public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int len1 = s.length(), len2 = p.length(); // the two lengths
		if (len2 > len1)
			return result;
		
		int[] anagram = new int[26];
		for (int i = 0; i < len2; ++i) 
		{
			anagram[p.charAt(i)-'a']++; // storing th alphabet count
			anagram[s.charAt(i)-'a']--;
		}
		if(allZero(anagram))
		{
			result.add(0);
		}
		for (int i = len2 ; i < len1; ++i) 
		{
			//System.out.println(i);
			anagram[s.charAt(i) - 'a']--;
			anagram[s.charAt(i - (len2 )) - 'a']++;
			if(allZero(anagram))
			{
				result.add(i-len2 + 1); 
			}
		}
		//System.out.println(result);
		return result;
	}
    public boolean allZero(int[] freq)
	{
		for(int i=0;i<26;i++)
		{
			if(freq[i]!=0)
				return false;
		}
		return true;
	}
}
