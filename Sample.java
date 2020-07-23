// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>(); // result
        HashMap<Character, Integer> map = new HashMap<>(); // to store the character and frequency of p string
        int match = 0;
        for(int i=0;i<p.length();i++) // iterate over p
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1); // add frequency for each character
        }
        
        for(int i=0;i<s.length();i++) // iterate over string s
        {
            char in = s.charAt(i); // get incoming character by i
            
                if(map.containsKey(in)) // if incoming char in map
                {
                    int count = map.get(in); //get the count
                    count--; //reduce it i.e one character found
                    map.put(in,count); //update the count
                    
                    if(count == 0) // when the count becomes zero for a character
                        match++; // we have one character match (equal to frequency)
                    
                }
            
            //outgoing
            if(i>= p.length()) // if i becomes more than or equal to length of p, we have an outgoing character as we need to maintain the window of the size of p
            {
                char out = s.charAt(i - p.length()); // get outgoing character
                
                if(map.containsKey(out)) // if map has it, its count must have been reduced earlier
                {
                    int count = map.get(out); // get count
                    count++; //increase it for outgoing character
                    map.put(out,count); // update the count
                    
                    if(count == 1) // if count becomes one
                        match--; // reduce the match
                }
            }
            
              if(match == map.size()) // when match becomes equal to number of unique characters of p
                    result.add(i - p.length() + 1); // add the start index of window to result
            
        }
        
        return result;
    }
}

//same question using fast and slow pointers
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int match = 0;
        for(int i=0;i<p.length();i++)
        {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        int slow = 0;
        int fast = 0;
        
       while(fast < s.length())
        {
            char in = s.charAt(fast);
                if(map.containsKey(in))
                {
                    int count = map.get(in);
                    count--;
                    map.put(in,count);
                    
                    if(count == 0)
                        match++;
                    
                }
            
            //outgoing
            if(fast>= p.length())
            {
                char out = s.charAt(slow);
                
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    map.put(out,count);
                    
                    if(count == 1)
                        match--;
                }
                slow++; //increase slow when we have a outgoing character
            }
            
              if(match == map.size())
                    result.add(slow);
           
           fast++; //fast increase at each point
            
        }
        
        return result;
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int strStr(String haystack, String needle) {
        //edge case
        if(needle.length() == 0) 
            return 0;
        
        int m = haystack.length(); 
        int n = needle.length();
        int i = 0; // for haystack
        int j = 0; //for needle
        
        while(i<m-n+1) // till i is less than diff of haystack and needle length as after that we cannot find a match
        {
            if(haystack.charAt(i) == needle.charAt(j)) //if we find a match 
            {
                int temp = i; //initialize temp at i and move temp to find the rest of match
                while(temp<m && j < n) // till both are within the length of strings
                {
                    if(haystack.charAt(temp) == needle.charAt(j)) // if matches
                    {
                        temp++; j++; //increase both
                    }
                    else
                        break; //come out of loop
                }
                
                if(j == n) // if j's last character matched and then j has increased one more than that
                    return i; //return the start of string denoted by i
            }
            i++; //incraese i to start checking for another substring
            j=0; // reset j
        }
        return -1;
    }
}

// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        int i = 0; //haystack
        int j = 0; // needle
        int lps[] = lps(needle);
        //same as lps
        while(i<m) //till i has traversed the whole haystack string
        {
            if(haystack.charAt(i) == needle.charAt(j)) // if there is match with needle 
            {
                i++; j++; // go further
            }
            if(j == n) // if needle has been traversed fully
                return i-n; // return the starting index
            else if(i<m && j>0 && haystack.charAt(i) != needle.charAt(j)) // if they dont match and there is a prefix suffix 
            {
                j = lps[j-1];// move j to position till where we have a match
            }
            else if(i<m && j==0 && haystack.charAt(i) != needle.charAt(j)) // if no match and j is zero i.e no match previously
                i++; //move to next character of haystack
        }
        
        return -1;
       
    }
    
    private int[] lps(String needle)
    {
        int i = 1; // start i at one to compare
        int j = 0; //both i and j on needle
         int n = needle.length();
        int lps[] = new int[n]; // prefix suffix matched array
        lps[0] = 0; // for one character prefix, suffix matched are zero
        while(i<n) //till i has traversed the whole needle string
        {
            if(needle.charAt(i) == needle.charAt(j)) // if characters match
            {
                j++; //increase the prefix suffix window
                lps[i] = j; // put j value in lps array for ith character
                i++; // increase i as well
            }
            else if(needle.charAt(i) != needle.charAt(j) && j>0) // if they dont match and there is a prefix suffix
            {
                j = lps[j-1]; // move j to position till where we have a match
            }
            else if(needle.charAt(i) != needle.charAt(j) && j==0) // if no match and j is zero i.e no match previously
            {
                lps[i] = 0; // put match as zero
                i++; // go to next character
            }
        }
        return lps;
    }
}