package lru;

/**
 * Item class for making a LinkedList
 *
 */
public class Item {
	private Object key;
	private Object value;
	private Item prev;
	private Item next;

	public Item(Object key, Object value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Item getPrev() {
		return prev;
	}

	public void setPrev(Item prev) {
		this.prev = prev;
	}

	public Item getNext() {
		return next;
	}

	public void setNext(Item next) {
		this.next = next;
	}

}
