class RandomizedSet {
    List<Integer> listSet;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        listSet = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        else {
            listSet.add(val);
            map.put(val, listSet.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int idx = map.get(val);
            listSet.add(idx, listSet.get(listSet.size()-1));
            map.put(listSet.get(listSet.size()-1), idx);
            listSet.remove(idx+1);
            listSet.remove(listSet.size()-1);
            map.remove(val);
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getRandom() {
        int randomNum = (int) (Math.random() * listSet.size());
        return listSet.get(randomNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */