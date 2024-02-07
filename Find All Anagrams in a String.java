// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Sliding window

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        // In this approach we are applying sliding window protocol by comparing 2 hashmaps
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();

        List<Integer> result = new ArrayList();

        if(p.length() > s.length()) return result;

        int length = p.length();

        for(int i = 0; i < length; i++)
        {
            char c = p.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        while(right < s.length())
        {
            char c = s.charAt(right);

            if(right < length) map2.put(c, map2.getOrDefault(c, 0) + 1);

            else
            {
                if(map1.equals(map2)) result.add(left);

                int count = map2.get(s.charAt(left));
                map2.remove(s.charAt(left));
                if(count > 1) map2.put(s.charAt(left), count - 1);

                ++left;

                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            ++right;
        }

        if(map1.equals(map2)) result.add(left);


        return result;
    }
}