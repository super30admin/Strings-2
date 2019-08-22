class Solution {
    public int strStr(String haystack, String needle) {
            int count = 0, index = 0;
	        if(needle.length()>0) {
			int charAt = 0, q=0;
			boolean found = false;
	        if(haystack.contains(needle)) {
				for(int i=0;i<haystack.length();i++) {
					for(int j=q;j<needle.length();) {
						if(haystack.charAt(i)==needle.charAt(j)) {
							count++;
							if(count==needle.length()) {
								found = true;
								charAt = i-count+1;
								break;
							}
							q++;
						}
						else {
							if(count>0) {
								i=i-count;
								count=0;
							}
							count=0;
							q=0;
						}
						break;
					}
					if(found==true) {
						index = charAt;
						break;
					}
				}
	        }
	        else index = -1;
	    }
	        else index = 0;
    return index;
    }
    
}