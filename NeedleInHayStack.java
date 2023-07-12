// Time Complexity : O(n) where n is the length of the string haystack
// Space Complexity :O(n) n is the length of the string haystack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
import java.util.LinkedList;
import java.util.Queue;

public class NeedleInHayStack {
    public int strStr(String haystack, String needle) {
        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                q.add(i);
            }
        }

        int index = -1, first = -1, start = -1, i = -1;
        while(!q.isEmpty()){
            i = 0;
            first = q.poll();
            start = first;
            while(i< needle.length() && first < haystack.length()){
                if(haystack.charAt(first) != needle.charAt(i)){
                    break;
                }

                first++;
                i++;
            }
            if(i == needle.length()){
                index = start;
                break;
            }

        }
        return index;
    }
}
