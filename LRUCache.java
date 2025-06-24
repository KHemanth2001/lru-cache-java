import java.util.HashMap;

class LRUCache{
    private static class Node{
        int key,value;
        Node prev, next;

        Node(){

        }
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;


    LRUCache(int capacity){
        this.capacity=capacity;
        cache=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node curr=cache.get(key);

        insertAtFront(curr);
        return curr.value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node curr=cache.get(key);
            insertAtFront(curr);
            curr.value=value;
        }else{
            if(cache.size()==capacity){
                Node lastNode=tail.prev;
                remove(lastNode);
            }
            Node newN=new Node(key,value);
            newN.next=head.next;
            newN.next.prev=newN;
            head.next=newN;
            newN.prev=head;
            cache.put(key,newN);
        }
    }

    private void remove(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
        cache.remove(node.key);
    }

    private void insertAtFront(Node curr) {
        //Remove the curr element from its position
        if(curr.prev!=null && curr.next!=null){
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
        }

        //Place the curr element in the first place.
        curr.prev=head;
        curr.next=head.next;
        head.next.prev=curr;
        head.next=curr;
    }


}