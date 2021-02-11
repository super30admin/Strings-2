// Time Complexity : O(h + n), h, n is length of the haystack and needle
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting the correct answer if the needle contained more than 1 character present at needle[0]

// Notes : Create an array to store the maximum length when the suffix and prefix is equal for a given window in the needle string. This array will be used to reset the pointer on the needle to a new position, if the characters at the haystack and needle dont match.

public class ImplementStrstr {
    if(needle.length() == 0 ) return 0;
        if(haystack.length() == 0 || haystack.length() < needle.length()) return -1;

        int h = 0; //pointer for haystack
        int p = 0; //pointer for needle

        int arr[] = calc(needle);
        
        while(h < haystack.length() && p < needle.length()){
            if(haystack.charAt(h) == needle.charAt(p)){
                h = h + 1;
                p = p + 1;
                if(p == needle.length())
                    return h - p; 
            } else {
                if(p == 0){
                    h = h + 1;
                } else {
                    p = arr[p - 1];
                }
            }
        }
        return -1;
    }
    
    private int[] calc(String needle){
        int arr[] = new int[needle.length()];
        
        int fast = 1; 
        int slow = 0; 
        
        arr[0] = 0;
        
        while(fast < needle.length() ){
            if(needle.charAt(fast) == needle.charAt(slow)){
                slow = slow + 1;
                arr[fast] = slow;
                fast = fast + 1;
            } else if(needle.charAt(fast) != needle.charAt(slow) && slow > 0){
                slow = arr[slow - 1];
            } else if(needle.charAt(fast) != needle.charAt(slow) && slow == 0){
                arr[fast] = 0;
                fast = fast + 1;
            }
        }
        
        return arr;
    }
}
