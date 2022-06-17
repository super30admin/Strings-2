public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list =new ArrayList<Integer>();
        Map<Character, Integer> map2= createMap(p);
        Map<Character, Integer> map1= new HashMap<Character, Integer> ();

        for(int i=0;i<s.length()-p.length()+1;i++)
        {
        map1= createMap(s.substring(i,i+p.length()));
        if(map1.equals(map2))
        list.add(i);
        }
        return list;
        }

public Map<Character, Integer> createMap(String s)
        {
        Map<Character, Integer> map= new HashMap<Character, Integer>();
        for(char c:s.toCharArray())
        {
        if(map.containsKey(c))
        map.put(c,(map.get(c)+1));
        else
        map.put(c, 1);
        }
        return map;
        }
        }