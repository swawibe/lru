package lru;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LruTest {

	@Test
	public void testGetMaxSize() {
		// It is a good practice to declare Interface type (LruCache) variable instead of
		// concrete type (Lru).
		LruCache lruCache = new Lru(5);
		assertThat(lruCache.getMaxSize(), equalTo(5));
	}

	@Test
	public void testPutAndGet() {
		LruCache lruCache = new Lru(5);

		// Creating a combination of Objects (String, Integer, Double)
		lruCache.put("A", "Apple");
		lruCache.put("B", 2);
		lruCache.put(3, "Cat");
		lruCache.put(4.0, 16);

		assertThat(lruCache.get(4.0), equalTo(16));
		assertThat(lruCache.get(3), equalTo("Cat"));
		assertThat(lruCache.get("B"), equalTo(2));
		assertThat(lruCache.get("A"), equalTo("Apple"));
	}

	@Test
	public void testGetReturnsNull() {
		LruCache lruCache = new Lru(5);
		lruCache.put("A", "Apple");
		assertThat(lruCache.get(4.0), equalTo(null));
	}

	@Test
	public void testLeastUsedItemsAreDiscarded() {
		LruCache lruCache = new Lru(3);

		// Creating a combination of Objects (String, Integer, Double)
		lruCache.put("A", "Apple");
		lruCache.put("B", 2);
		lruCache.put(3, "Cat");
		lruCache.put("B", "Ball");
		lruCache.put(4.0, 16);

		// Cache size was 3. Therefore, "A" should be discarded and return null.
		assertThat(lruCache.get("A"), equalTo(null));
	}

	@Test
	public void testRetrievedItemsAreNotDiscarded() {
		LruCache lruCache = new Lru(3);

		// Creating a combination of Objects (String, Integer, Double)
		lruCache.put("A", "Apple");
		lruCache.put("B", 2);
		lruCache.put(3, "Cat");
		lruCache.get("A");
		lruCache.put(4.0, 16);

		// Cache size was 3. Therefore, "B", 3, and 4.0 should be in the cache. However,
		// "A" was retrieved. As a result, it is in the cache.
		assertThat(lruCache.get("A"), equalTo("Apple"));
	}
}
