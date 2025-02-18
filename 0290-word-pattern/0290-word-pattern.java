class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        int len = pattern.length();

        if(str.length != len){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            char schar = pattern.charAt(i);
            String curr = str[i];

            if(map.containsKey(schar)){
                String corresT = map.get(schar);
                if(!corresT.equals(curr)){
                    return false;
                }
            }
            else if(map.containsValue(curr)){
                return false;
            }
            else{
                map.put(schar, curr);
            }
        }
        return true;
    }
}