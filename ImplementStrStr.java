/*
Time Complexity: O(lengthOfHayStack-lengthOfNeedle+1)
Space Complexity: O(1)
Run on Leetcode: Yes
Any Difficulties: No

Approach:
1. I will be iterating till hayStack.length()-needle.length()+1 and when ever I find a substring matching my needle,
I will be returning the initial index
 */
public class ImplementStrStr {
    public static int implementStrStr(String hayStack, String needle){
        if(hayStack.length()<needle.length()){
            return -1;
        }

        int lengthOfHayStack = hayStack.length();
        int lengthOfNeedle = needle.length();

        for(int i = 0; i<lengthOfHayStack-lengthOfNeedle+1; i++){
            if(hayStack.substring(i, i+lengthOfNeedle).equals(needle)){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(implementStrStr("hello","ll"));
    }
}
