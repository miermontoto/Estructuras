
public class Node<T> {
	private Object data;
	private Node<T> next;
	
	public Node(T e) {
		data = (T) e;
		next = null;
	}
	
	public Node(Node<T> e, Node<T> n) {
		data = (T) e;
		next = n;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = (T) data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
