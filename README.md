# Least Recently Used (LRU) Implementation

The program implements LRU using a Linked List and HashMap. Adding or deleting in a Linked List is O(n). However, HashMap improves that in O(1). 

### Workflow
* `LruCache` interface provides three methods (`get`, `put`, and `getMaxSize`)
* `Item` class implements an item (node) of a doubly LinkedList
* `Lru` class implements `LruCache` and used `item` as a node of LinkedList. Besides, implementation of `get`, `put`, and `getMaxSize`, this class also implements `removeItem` and `moveAtEnd` methods (`private`). The reason for using those methods are described in comments. To use `Lru`, initilize with a capacity (`LruCache lruCache = new Lru(3)`). Then, call methods (`get`, `put`, and `getMaxSize`) as your need. 
* `LruTest` class is for unit tests (`junit`). This class provides 100% unit test coverage.

#### Notes:
Followed some of the best practices. For example:
* It is a good practice to declare Interface type (LruCache/Map) variable instead of concrete type (Lru/HashMap).
* Make all instance variables private and use of Getter/Setter methods
* Use of JavaDoc comments
* Use of `@Override` keyword