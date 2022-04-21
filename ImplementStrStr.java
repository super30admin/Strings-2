//Time Complexity : O(m + n); where m and n are length of both the input strings
//Space Complexity : O(1)
public class ImplementStrStr {	
	/**Approach: KMP Algo**/
	 public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;        
        int m= haystack.length();
        int n= needle.length();     
        int i=0; //haystack
        int j=0; //needle   
        int[] lps= lps(needle); //calculate lps Array    
        while(i<m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; 
                j++;
                if(j == n) return i-n;
            }else if (j>0){
                j= lps[j-1];
            }else if (j==0){
                i++;
            }                
        }
        return -1;
    }    
    private int[] lps(String pattern){
        int[] lps= new int[pattern.length()];        
        int j=0;
        int i=1;
        while(i<pattern.length()-1){
            if(pattern.charAt(j) == pattern.charAt(i)){
                j++;
                lps[i]=j;
                i++;
            } else if(j > 0){
                 j= lps[j-1];            
            } else if(j == 0){
                lps[i] = 0;
                i++;
            } 
        }
        return lps;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		ImplementStrStr ob = new ImplementStrStr();	
		String haystack ="hello";
		String needle = "ll";
		
		System.out.println("Index of first ocurrence of pattern in given search string: "+ob.strStr(haystack,needle));      
	}	
}
