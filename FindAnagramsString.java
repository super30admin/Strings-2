/*
This solution uses a sliding window along with a Hash map. First, we store all the elements and the occurences of p in a map. 
Then, we use two pointers, *in and *out, to maintain a window on string s. We maintain a window with the following rules:
1. The window is not greater than the length of p, as anagrams will have maximum length p, and it is exists only between
   *in and *out
2. As we move the *in pointer forward, we check incoming elemnts to see if they are part of the p string, and modify the 
   map, by decreasing the count of the character in the map, to note that the current window has an element of p. 
3. The map reflects the status of the window and how many elements of the p string it contains. If it contains all the 
   elements then the location of the *out pointer is recorded.
4. As the *in pointer moves forward, so does the *out pointer. If the outgoing elements in the window are part of the p
   string then the map is modified accordingly by increasing the count back again of any element that was in the map.
   
The algorithm eventually returns all the start points of the anagrams in the string.

Did this code run on leetcode: Yes

*/
class Solution {
    //Time Complexity: O(n) where n is length of s, since n will mostly always be bigger than m
    //Space Complexity: O(1) because hashmap will only have maximum 26 entries
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //In this program instead of using an *out pointer we just take in - p.length() whenever we want to evaluate the outgoing element
        int in = 0;
        int match = 0;
        while(in < s.length())
        {
            char c = s.charAt(in);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                count--;
                //If the count for a letter is 0, it means that all the instances of that letter are present in the window and we count it as a match
                if(count == 0)
                    match++;
                map.put(c, count);
            }
            
            if(in >= p.length())
            {
                char out = s.charAt(in - p.length());
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    //When the outgoing character is present in the map, and its previous count was 0, we update it to 1 and reduce the match count
                    if(count == 1)
                        match--;
                    map.put(out, count);
                }
            }
            
            if(match == map.size())
                result.add(in - p.length() + 1);
            
            in++;

        }
  
        return result;
    }
}