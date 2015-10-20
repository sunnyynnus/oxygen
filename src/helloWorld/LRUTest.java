package helloWorld;

import java.util.*;

public class LRUTest{

  public static void main(String[] args){
      LRU<Integer, String> lru= new LRU<>(4);
      testLRU(lru);
      LRUCache<Integer, String> lruCache= new LRUCache<>(4);
      testLRUCache(lruCache);
  }

  private static void testLRU(LRU<Integer, String> lru){

    System.out.println("** using composition***");  
    int i=0;
    while(i++<5){
      lru.put(i, "Sunny"+i);
    }
    System.out.println("size= "+lru.size()+"\n"+lru);
    i=0;
      
    while(i++<4){
      lru.get(i);
    }
    System.out.println(lru);
    lru.put(10, "Sunny10");
    System.out.println(lru);
  }

  private static void testLRUCache(LRUCache<Integer, String> lru){
    System.out.println("** using inheritence***");
    int i=0;
    while(i++<5){
      lru.put(i, "Sunny"+i);
    }
    System.out.println("size= "+lru.size()+"\n"+lru);
    i=0;

    while(i++<4){
      lru.get(i);
    }
    System.out.println(lru);
    lru.put(10, "Sunny10");
    System.out.println(lru);
  }
}

class LRU<K, V>{
  
  private final Map<K, V> map;
  private final float loadFactor= 0.75f;
  private final int size;

  public LRU(int size){
    this.size= size;
    map= new LinkedHashMap<K, V>(size, loadFactor, true);
  }
  public void put(K key, V value){
    if(map.size() >= size){
      Iterator<Map.Entry<K, V>> itr= map.entrySet().iterator();
      itr.next();
      itr.remove();
    }
     map.put(key, value);
  }

  public V get(K key){
    return map.get(key);
  }

  public V remove(K key){
    return map.remove(key);
  }

  public String toString(){
    return map.toString();
  }

  public int size(){
    return map.size();
  }
}

class LRUCache<K, V> extends LinkedHashMap<K, V>{

  private final int size;

  public LRUCache(int size){
    super(size, 0.75f, true);
    this.size= size;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
    return size()> size;
  }
}
