//idea is to //check all combinations of substring of first string of length second string weather these combinations are equal to second string string or not.
//use two pointers and two pointers scan over first string.
//first pointer start from 0th character and second pointer from length of needle-1.
//tc: 0(m) where m is length of first string
//sc o(1)
public class strStr {
	    public static  int strStr(String haystack, String needle) {
	        int length = needle.length();
	        if(haystack.length()==0 && needle.length()==0 ) return 0;
	        int i=0;
	        int j=length-1;
	        int found =-1;
	        boolean flag =false;
	        //two pointers
	        while(i<haystack.length() && j<haystack.length()){
	            System.out.println(haystack.substring(i,j+1));
	            //checking substring of first string equal to second string or not
	            if(haystack.substring(i,j+1).equals(needle)){ //substring is o(n) operation after java 1.7 and n is no of element in substring
	                found = i;
	                flag =true;
	                
	                break;
	            }
	            i++;
	            j=i+length-1;  //moving j by second string length
	        }
	        if(flag ) return found; 
	        return found;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hello";
		String needle = "ll";
		int result = strStr(haystack, needle);
		System.out.println("first occurace is"+result);

	}

}
