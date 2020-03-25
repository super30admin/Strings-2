//Time Complexity: O(h*n) length of haystack * length of needle
//Space Complexity: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        
        if( haystack.length() == 0 && needle.length() == 0) 
            return 0;

        if(haystack.length() < needle.length())
            return -1;
        
        if(needle.length() ==0)
            return 0;

        int h = haystack.length();
		int n = needle.length();
		
		int i=0;
		while(i<h)
		{
			int currLength=0;
			for(int j=0; j<n; j++)
			{
				if(haystack.charAt(i)==needle.charAt(j))
				{
					i++;
					currLength++;
				}else
				{
					i = i - currLength+1;
					break;
				}
				
				
				if(currLength == n)
					return i-currLength;
			}
	
		}
		
		return -1;
	
    }
}
