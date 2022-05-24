class Solution {

    //Time Complexity : 0(m + n) where m is the size if string s and n is the size of string p
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In short, explain your arroach

    //I am using the cincept of sliding window

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();  //declaring a hashmap to keep a count of the occurences of anagram and then adding to it once it is encountered in s string and subtracing it's count once it exits the sliding window
        List<Integer> result = new ArrayList<>();   //to store the indices to occurence of anagram

        for(int i = 0; i < p.length(); i++){    //adding the characters of anagram and it's no. of occurences
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0;  //taking a match variable to keep a track of the size of the unique characters in anagram and the unique characters in sliding window. If it matches, then we add the index to the result

        for(int j = 0; j < s.length(); j++){    //iterating over the given string
            char incoming = s.charAt(j);    //extracting characters one by one
            if(map.containsKey(incoming)){  //checking if it mathces the character present in anagram or not
                int count = map.get(incoming);  //if yes, getting its current occurence count
                count--;    //then reducing the count of it's occurence as it is encountered while traversing
                if(count == 0){ //if the count is 0, means that this character satisfies the anagram condition
                    match++;
                }
                map.put(incoming, count);   //then putting back the character with it's updated count into the hashmap
            }
            if(j >= p.length()){    //keeping a track of outgoing character of my sliding window
                char outgoing = s.charAt(j - p.length());   //capturing the outgoing element of the winddow
                if(map.containsKey(outgoing)){
                    int count = map.get(outgoing);  //getting the current count of the caracter
                    count++;    //and increasing it by 1
                    if(count == 1){ //if the count is equal to 1 meaning that the character string is 1 character less to form an anagram
                        match--;    //reducing the size of maatch and storing the current count of the character back to hashmap
                    }
                    map.put(outgoing, count);
                }
            }
            if(match == map.size()){    //if match matches the size of the hashmap, we capture the index of the starting character of the anagram
                result.add(j - p.length() + 1);
            }
        }
        return result;
    }
}