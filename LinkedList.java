import java.util.function.Function;

public class LinkedList {
    public Node first;
    private int length;

    public LinkedList() {
        this.first = null;
        this.length = 0;
    }

    public Node findNode(int index) {
        if (index < length && index >= 0) {
            Node currentNode = this.first;
            for(int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
            }
            // System.out.print(currentNode.getValue());
            return currentNode;
        } else {
            return null;
        }
    }

    public void add(String value) {
        Node newNode = new Node(value);
        if(this.first == null) {
            this.first = newNode;
        } else {
            Node lastNode = this.findNode(length-1);
            lastNode.setNext(newNode);
        }
        length++;
    }

    public void insert(String value, int index) {
        if (index < length && index >= 0) {
            if (index == 0) {
                Node node = new Node(value);
                node.setNext(this.first);
                this.first = node;
            } else {
                Node temp = new Node(value);
                Node beforeIndexNode = findNode(index-1);
                Node indexNode = beforeIndexNode.getNext();
    
                beforeIndexNode.setNext(temp);
                beforeIndexNode.getNext().setNext(indexNode);
            }

            length++;
        }
    }

    public void remove(int index) {
        if (index < length && index >= 0) {
            if (index == 0) {
                Node temp = this.first;
                this.first = temp.getNext();
                
            } else {
                Node beforeIndexNode = findNode(index-1);
                Node afterIndexNode = beforeIndexNode.getNext().getNext();
                beforeIndexNode.setNext(afterIndexNode);
            }

            length--;
        }
    }

    public void swap(int index1, int index2) {
        if (index1 < length && index2 < length && index1 >= 0 && index2 >= 0) {
            Node firstNode = findNode(index1);
            Node secondNode = findNode(index2);
    
            insert(secondNode.getValue(), index1);
            remove(index1+1);
    
            insert(firstNode.getValue(), index2);
            remove(index2+1);
        }
    }

    public String get(int index) {
        if (index < length && index >= 0) {
    
            Node indexNode = findNode(index);
            return indexNode.getValue();
        } else {
            return "";
        }
    }

    public void deleteValue(String value) {
        Node temp = first;
        int index = length;
        for (int i = 0; i < index; i++) {
            if (temp != null) {
                if (temp.getValue() == value) {
                    remove(i);
                }
                temp = temp.getNext();
            }
        }
    }

    public void deleteDuplicate() {
        int lengthOfLinkedList = length;
        Node primaryNode = first;

        for (int i = 0; i < lengthOfLinkedList; i++) {
            String value = primaryNode.getValue();
            Node comperNode = first; 

            for (int j = 0; j < i; j++) {
                if (value == comperNode.getValue()) {
                    remove(j);
                }
                comperNode = comperNode.getNext();
            }

            primaryNode = primaryNode.getNext();
        }
    }

    public void tailToHead() {
        swap(0, length-1);
    }

    public void showAll() {
        Node currentNode = this.first;
        for (int i = 0; i < length; i++) {
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList newLinkedList = new LinkedList();

        newLinkedList.add("T");
        newLinkedList.add("E");
        newLinkedList.add("L");
        newLinkedList.add("L");

        // newLinkedList.deleteValue("T");
        newLinkedList.tailToHead();
        // newLinkedList.deleteDuplicate();
        newLinkedList.showAll();


    }
}
