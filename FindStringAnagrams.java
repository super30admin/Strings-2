class FindStringAnagrams {
    //Will come bcak to this question as I did not fuly understand solution
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            if(!sMap.contains(s.charAt(i))) {
                sMap.put(s.charAt(i), 0);
            } else {
                sMap.put(sMap.get(s.charAt(i)) + 1);
            }
        }

        return result;

    }
}