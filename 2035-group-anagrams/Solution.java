class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] charr = s.toCharArray();
            Arrays.sort(charr);

            String word = new String(charr);

            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
            }

            map.get(word).add(s);
        }

        return new ArrayList<>(map.values());
    }
}