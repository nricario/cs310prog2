package edu.sdsu.cs;

import java.util.Iterator;
import java.util.LinkedList;

public class UnbalancedMap<K extends Comparable<K>, V> {

	private class Node<K, V> {
		K key;
		V value;

		Node<K, V> leftChild;
		Node<K, V> rightChild;

		public void setLeft(Node<K, V> node) {
			leftChild = node;
		}

		public void setRight(Node<K, V> node) {
			rightChild = node;
		}

		public V getValue() {
			return value;
		}

		public K getKey() {
			return key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public int compareTo(Node<K, V> compNode) {
			return ((Comparable<K>) key).compareTo((K) compNode.getKey());
		}
	}

	private Node<K, V> root;
	private int currentSize;

	public UnbalancedMap() {
		root = null;
		currentSize = 0;
	}
	
	private UnbalancedMap map;
	
	public boolean contains(K key) {
		if (root == null) {
			return false;
		}
		if (key == null) {
			return false;
		}
		if (search(root, key) == null) {
			return false;
		}
		return true;

	}

	public boolean add(K key, V value) {
		Node node = new Node(key, value);
		if (root.getKey() == null) {
			root = node;
			return true;
		}
		if (insert(node, root) != null) {
			return true;
		}
		return false;
	}

	private Node<K, V> insert(Node<K, V> node, Node<K, V> compareNode) {
		K key = node.getKey();
		K cKey = compareNode.getKey();
		if (key == cKey) {
			return node;
		}
		if ((key).compareTo(cKey) < 0) {
			if (rightEmpty(compareNode)) {
				compareNode.rightChild = node;
				return compareNode;
			} else {
				insert(node, compareNode.rightChild);
			}
		}
		if ((key).compareTo(cKey) > 0) {
			if (leftEmpty(compareNode)) {
				compareNode.leftChild = node;
				return compareNode;
			} else {
				insert(node, compareNode.rightChild);
			}
		}
		return node;
	}

	private boolean leftEmpty(Node<K, V> compareNode) {
		if (compareNode.leftChild != null) {
			return false;
		}
		return true;
	}

	private boolean rightEmpty(Node<K, V> compareNode) {
		if (compareNode.rightChild != null) {
			return false;
		}
		return true;
	}

	private Node<K, V> search(Node<K, V> node, K key) {
		if (node.getKey() == key) {
			return node;
		} else if (leftEmpty(node) == true && rightEmpty(node) == true) {
			return null;
		}
		K cKey = node.getKey();
		if (leftEmpty(node) == false && key.compareTo(cKey) < 0) {
			if (search(node.leftChild, key) != null) {
				return search(node.leftChild, key);
			}
		} else if (rightEmpty(node) == false && key.compareTo(cKey) > 0) {
			if (search(node.rightChild, key) != null) {
				return search(node.rightChild, key);
			}
		}
		return null;
	}

	public boolean delete(K key) {
		if (key == null) {
			return false;
		}
		if (root == null) {
			return false;
		} else {
			Node<K, V> deleteNode = search(root, key);
			Node<K, V> coup = inOrderSuccessor(deleteNode);
			deleteNode = coup;
			coup = null;
		}
		return false;

	}

	private Node<K, V> inOrderSuccessor(Node<K, V> deleteNode) {
		if (leftEmpty(deleteNode) == false) {
			Node<K, V> child = deleteNode.leftChild;
			Node<K, V> temp = leftRec(child);
			return temp;
		}
		if (rightEmpty(deleteNode) == false) {
			Node<K, V> child = deleteNode.rightChild;
			Node<K, V> temp = rightRec(child);
			return temp;
		}
		return null;
	}

	// goes down the right side
	private Node<K, V> leftRec(Node<K, V> node) {
		if (node.rightChild != null) {
			leftRec(node.rightChild);
		}
		Node<K, V> temp = node;
		node = null;
		return temp;
	}

	// goes down the left side
	private Node<K, V> rightRec(Node<K, V> node) {
		if (node.leftChild != null) {
			rightRec(node.leftChild);
		}
		Node<K, V> temp = node;
		node = null;
		return temp;
	}

	public V getValue(K key) {
		return ((Node<K, V>) key).getValue();
	}

	public K getKey(V value) {
		return ((Node<K, V>) value).getKey();
	}

	public int size() {
		return map.size();
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	
	public void clear() {
		root = null;
		currentSize = 0;
	}

	
	public Iterator<K> keys() {
		return alignerK(root);
	}

	
	public Iterator<V> values() {
		return alignerV(root);
	}

	private Iterator<K> alignerK(Node<K, V> n) {
		if (n != null) {
			System.out.println(n.getKey());
			alignerK(n.leftChild);
			alignerK(n.rightChild);
		}
		return null;
	}

	private Iterator<V> alignerV(Node<K, V> n) {
		if (n != null) {
			System.out.println(n.getValue());
			alignerV(n.leftChild);
			alignerV(n.rightChild);
		}
		return null;
	}

}
