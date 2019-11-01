package lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Least Recently Used(LRU)
 *
 */
public class Lru implements LruCache {
	private int capacity = 0;
	private Item head;
	private Item tail;

	Map<Object, Item> hashMap = null;

	public Lru(int capacity) {
		this.capacity = capacity;
		this.hashMap = new HashMap<>();
	}

	// Getter and setter methods. Though, in this class those are private. However,
	// it is a common
	// practice to access variables through getter/setter.
	private Item getHead() {
		return head;
	}

	private void setHead(Item head) {
		this.head = head;
	}

	private Item getTail() {
		return tail;
	}

	private void setTail(Item tail) {
		this.tail = tail;
	}

	@Override
	public Object get(Object key) {
		// If the object is in the hashMap then return it.
		// However, before that, remove the item from the linkedList and add that at the
		// end
		if (hashMap.containsKey(key)) {
			Item item = hashMap.get(key);
			removeItem(item);
			moveAtEnd(item);
			return item.getValue();
		}
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		// If the object is in the hashMap then update it.
		// However, after that, remove the item from the linkedList and add that at the
		// end. Otherwise, check the size of linkedList and add at the end of the
		// linkedList.
		if (hashMap.containsKey(key)) {
			Item item = hashMap.get(key);
			item.setValue(value);
			removeItem(item);
			moveAtEnd(item);
		} else {
			// If cache is filled, then remove from the head of the linkedList
			if (hashMap.size() >= getMaxSize()) {
				hashMap.remove(getHead().getKey());
				removeItem(getHead());
			}

			// Add at the end of the linkedList
			Item item = new Item(key, value);
			moveAtEnd(item);
			hashMap.put(key, item);
		}

	}

	//	Removes item from a linkedList
	private void removeItem(Item item) {
		// If the item to remove is head then set the head to the next item. Otherwise,
		// create a link between it's previous and next items.
		if (item.getPrev() == null) {
			setHead(item.getNext());
		} else {
			item.getPrev().setNext(item.getNext());
		}

		// If the item to remove is tail then set the tail to the previous item.
		// Otherwise, create a link between it's next and previous items.
		if (item.getNext() == null) {
			setTail(item.getPrev());
		} else {
			item.getNext().setPrev(item.getPrev());
		}
	}

	// Move any edited, accessed, created item at the end(tail) of linkedList
	private void moveAtEnd(Item item) {
		// Check if the tail is an empty/null. If not then add the item next to tail
		if (getTail() != null) {
			getTail().setNext(item);
		}

		item.setPrev(getTail());
		item.setNext(null);
		setTail(item);

		// If the linkedList is an empty, then head and tail are same
		if (getHead() == null) {
			setHead(getTail());
		}
	}

	@Override
	public int getMaxSize() {
		return capacity;
	}

}
