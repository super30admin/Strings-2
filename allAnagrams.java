/**
 *  #Create a hashmap for the pattern to be matched
 *  #take a window and traverse the string s(as the anagram length has to be same as that of the pattern)
 *  # for every match reduce the value of that char in hmap and increase the value of that char in hmap if its out of the window
 *  # if the value of the char in hmap == 0 then increase the match count
 *  # if the match count = hmap size then there is an anagram and hence add the starting position of the window in the resultant list
 * Time: O(n) n - length of the string s
 * Space: O(m) m - length of the string p
 */
class Solution {
    int m;
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        if(s == null || s.length() < p.length()) return lst;
        int i = 0, j = 0;
        for(j = 0;j<p.length();j++){
            hmap.put(p.charAt(j), hmap.getOrDefault(p.charAt(j),0)+1);
        }

        for(j = 0;j<p.length();j++){
            if(hmap.containsKey(s.charAt(j))){
                hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j),0)-1);
                if(hmap.get(s.charAt(j)) == 0)
                    m++;
            }
        }
        if(m == hmap.size()){
            lst.add(0);
        }


        while(j<s.length()){
            if(hmap.containsKey(s.charAt(i))){
                hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i),0)+1);
                // if(hmap.get(s.charAt(i)) == 0)m++;
                if(hmap.get(s.charAt(i)) == 1) m--;
            }
            i++;
            if(hmap.containsKey(s.charAt(j)))
                hmap.put(s.charAt(j), hmap.getOrDefault(s.charAt(j),0)-1);

            if(hmap.getOrDefault(s.charAt(j),-1) == 0)
                m++;

            if(m == hmap.size()){
                lst.add(i);
            }

            j++;

            //print(hmap);

        }
        return lst;
    }
    private void print(HashMap<Character,Integer> hmap){
        for(Map.Entry<Character,Integer> es: hmap.entrySet()){
            System.out.print(" "+es.getKey()+" "+es.getValue());
        }
        System.out.println(" match:"+ m);
    }
}