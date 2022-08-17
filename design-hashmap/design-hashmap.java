class MyHashMap {

    private List<Integer[]>[] hashtable;
    private int numBuckets = 5;
  
    public MyHashMap() {
      hashtable = new ArrayList[numBuckets];
      for (int i = 0; i < numBuckets; i++)
        hashtable[i] = new ArrayList<Integer[]>();
    }
    
    public void put(int key, int value) {
      int hashIndex = key % numBuckets;
      if (get(key) == -1)
        hashtable[hashIndex].add(new Integer[]{key, value});
      else {
        for (int i = 0; i < hashtable[hashIndex].size(); i++)
          if (hashtable[hashIndex].get(i)[0] == key)
            hashtable[hashIndex].get(i)[1] = value;
      }
    }
    
    public int get(int key) {
      int hashIndex = key % numBuckets;
      for (int i = 0; i < hashtable[hashIndex].size(); i++)
        if (hashtable[hashIndex].get(i)[0] == key)
          return hashtable[hashIndex].get(i)[1];
      return -1;
    }
    
    public void remove(int key) {
      if (get(key) == -1)
        return;
      int hashIndex = key % numBuckets;
      for (int i = 0; i < hashtable[hashIndex].size(); i++)
        if (hashtable[hashIndex].get(i)[0] == key)
          hashtable[hashIndex].remove((int)i);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */