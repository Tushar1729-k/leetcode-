class MyHashSet {

    private List<Integer>[] hashtable;
  
    public MyHashSet() {
      int numBuckets = 5;
      hashtable = new ArrayList[numBuckets];
      for (int i = 0; i < numBuckets; i++)
        hashtable[i] = new ArrayList<>();
    }
    
    public void add(int key) {
      if (contains(key))
        return;
      int hashIndex = key % 5;
      hashtable[hashIndex].add(key);
    }
    
    public void remove(int key) {
      int hashIndex = key % 5;  
      if (hashtable[hashIndex].isEmpty())
        return;
      for (int i = 0; i < hashtable[hashIndex].size(); i++)
        if (hashtable[hashIndex].get(i) == key)
          hashtable[hashIndex].remove((int)i);
    }
    
    public boolean contains(int key) {
      int hashIndex = key % 5;
      if (hashtable[hashIndex].isEmpty())
        return false;
      for (int i = 0; i < hashtable[hashIndex].size(); i++)
        if (hashtable[hashIndex].get(i) == key)
          return true;
      return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */