
class Node<T> {
    private  T value;
    private Node<T> next;
    public Node(T value){
        this.value = value;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }
    public Node<T> getNext(){
        return this.next;
    }
    public T getValue(){
        return this.value;
    }1
    public String toString(){
        return String.valueOf(value);
    }
}
class LinkedList<T>{
    private Node<T> first;
    public int length;
    public LinkedList(){
    }
    public void add(T value){
        Node<T> temp = new Node<T>(value);
            if (this.first == null){
            this.first = temp;
            
            }
            else{
                this.getLast().setNext(temp);
            }
        length++;

    }
    public void remove(int index){
        Node<T> tempnode = this.get(index-1);
        Node<T> temp = tempnode.getNext();
        tempnode.setNext(temp.getNext());
        length--;
    }
    public void removeByValue(T value){
        Node<T> tempnode = this.get(this.getIndex(value)-1);
        Node<T> temp = tempnode.getNext();
        tempnode.setNext(temp.getNext());
        length--;
    }
    public void insert(T value,int index){
        Node<T> tempNode = this.get(index-1);
        Node<T> temp = tempNode.getNext();
        tempNode.setNext(new Node<T>(value));
        tempNode = tempNode.getNext();
        tempNode.setNext(temp);
        length++;

    }
    
    public void swap(int index1,int index2){
        
        Node<T> tempNode1 = this.get(index1);
        Node<T> tempNode2 = this.get(index2);
        this.remove(index1);
        this.insert(tempNode2.getValue(),index1);
        this.remove(index2);
        this.insert(tempNode1.getValue(),index2);
        
    }
    public Node<T> get(int index){
        Node<T> temp = first;
        for (int i=0;i<index;i++){
        temp = temp.getNext();
        }
        return temp;
    }
    public Node<T> getLast(){
        Node<T> last = first;
        while (last.getNext() != null){
            last = last.getNext();
        }
        return last;
    }
    public int getIndex(T value){
        Node<T> temp = first;
        int index = 0;
        while (temp.getValue() != value){
            index++;
            temp = temp.getNext();
        }return index;
    }
    
    @Override
    public String toString(){
        if (first == null){
            return null;
        }else{
            Node<T> temp = first;
            String str = temp.toString();
            while (temp.getNext() != null){
                temp = temp.getNext();
                str = str + temp.toString();
            }
            return str;
        }
    }
    
}