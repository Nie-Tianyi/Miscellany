public class LinkedList<E>{

	private int len = 0;
	private Node head;
	private class Node{
		public E data;
		public Node prev;
		public Node next;
		public Node(E data,Node prev,Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		public Node(E data){
			this(data,null,null);
		}
		public Node(){
			this(null,null,null);
		}	
	}
	public LinkedList(){
		//creat a empty LinkedList
		head = new Node();
	}

	public LinkedList(E[] arr){
		// construct the LinkedList with array
		head = new Node();
		for (E data: arr){
			add(data);
		}
	}

	public void print(){
		//print out the elements
		Node temp = head.next;
		System.out.print("[");
		do{
			System.out.print(temp.data);
			temp = temp.next;
			if(temp!=null){
				System.out.print(",");
			}
		}while(temp!=null);
		System.out.print("]\n");
	}

	public int len(){
		//return the length of the linkedList
		return this.len;
	}

	public void add(E data){
		//add a new element at the end of the LinkedList
		Node node = new Node(data,getLastNode(),null);
		getLastNode().next = node;
		this.len++;
	}

	public E delete(E data){
		//delete a node if it exist
		if(getByElement(data) == -1){
			System.out.println("Data does not exist!");
		}else{
			int counter = 0;
			Node temp = head;
			while(temp.next!=null){
				if(temp.data==data){
					break;
				}else{
					temp = temp.next;
					counter++;
				}
			}
			
			deleteNode(temp);
			this.len--;
		}
		return data;
		
	}

	public void insert(E data,int index){
		//insert a new Node
		Node temp = head;
		for (int i = 0;i<=index;i++){
			temp = temp.next;
		}

		Node temp_1 = temp.prev;
		Node temp_2 = temp;

		Node node = new Node(data,temp_1,temp_2);

		temp_1.next = node;
		temp_2.prev = node;

		this.len++;	
	}

	public E getByIndex(int index){
		//get the data by index
		Node temp = head;
		for (int i=0;i<=index;i++){
			temp = temp.next;
		}
		return temp.data;
	}

	public int getByElement(E element){
		//get the index of an element
		Node temp = head;
		int a = 0;
		while(temp.next != null){
			temp = temp.next;
			if(temp.data==element){
				return a;
			}
			a++;
		}
		return -1;
	}

	private void deleteNode(Node node){
		node.prev.next = node.next;
		if(node.next!=null){
			node.next.prev = node.prev;
		}
		
	}

	private Node getLastNode(){
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp;
	}

}
