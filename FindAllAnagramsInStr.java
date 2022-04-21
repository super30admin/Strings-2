import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity : O(n); where m and n are length of input strings and m<=n
//Space Complexity : O(1); as map will be max of 26 chars
public class FindAllAnagramsInStr {	
	/**Approach: Sliding Window + HashMap**/
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if(s.length() < p.length()) return result;
        
        //Create map of characters in pattern string
        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: p.toCharArray()){ //O(m)
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        //Apply sliding window on Search string
        int match=0;
        for(int i=0; i<s.length(); i++){ //O(n)
            //incoming char
            char in= s.charAt(i);
            if(map.containsKey(in)){
                int count=map.get(in) -1;
                if(count==0)  match++;
                map.put(in, count);
            }
            
            //outgoing char                        
            if(i>=p.length()){
                char out= s.charAt(i-p.length());
                if(map.containsKey(out)){
                    int count=map.get(out)+1;
                    if(count==1)  match--;
                    map.put(out, count);
                }
            }
            
            if(match == map.size()) result.add(i-p.length()+1); 
        }
        
        return result;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		FindAllAnagramsInStr ob = new FindAllAnagramsInStr();	
		String s="cbaebabacd";
		String p= "abc";
		
		System.out.println("Start indices of all anagrams of '"+p+"' are: "+ob.findAnagrams(s,p));      
	}	
}
