package lru;

 /**
 * Interface for LRU (Least Recently Used) Cache
 *
 */
public interface LruCache {
	/**
	 * @param key
	 * @return Object if available, otherwise nil 
	 */
	Object get(Object key);
	
	/**
	 * Inserts <key,value> in Cache
	 * @param key
	 * @param value
	 */
	void put(Object key, Object value);
	
	/**
	 * @return maximum size of the Cache
	 */
	int getMaxSize();
}
