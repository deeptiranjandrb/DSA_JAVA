import java.util.List;

public class LinkedList {
    Node head; // head of the list

    // Create a inner static class that will be a node of linked list
    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public static LinkedList insert(LinkedList list, int data){
        
        //create a new node
        Node new_node = new Node(data);

        //if the linked list is empty, new node will be head
        if(list.head == null){
            list.head = new_node;
        }
        else{

            //Else traverse till last node
            // add the new_node there
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            //got the last whose next is null,
            // insert the new node here
            last.next = new_node;

        }
        return list;
    }

    public static void printList(LinkedList list){
        Node currNode = list.head;
        while(currNode != null){
            // Print data at current node
            System.out.println("data: " + currNode.data);

            //Move to the next node
            currNode = currNode.next;
        }
    }
    //Deletion by Key
    public static LinkedList delete(LinkedList list, int key){
        // if key is found at head
        Node currNode = list.head, prev = null;
        if(currNode != null && currNode.data == key){
            list.head = currNode.next; // change head

            System.out.println(key + "found and deleted");

            return list;
        }

        // if the key is somewhere other than head
        while (currNode != null && currNode.data !=key){
            prev = currNode;
            currNode = currNode.next;
        }
        // if the key is present then currNode should not be null
        if(currNode != null){
            // Since key is at current node
            // Unlink the current node
            prev.next = currNode.next;
            System.out.println(key + "found and deleted");
        }else{
            System.out.println(key + " not found");
        }
        return list;
    }
    //insert after certain key
    public static LinkedList insertAfter(LinkedList list, int key, int data){
        //if key is found
        Node currNode = list.head;
        // if(currNode != null && currNode.data == key){
        //     Node newNode = new Node(data);
        //     newNode.next = currNode.next;
        //     currNode.next = newNode;
        //     return list;
        // }
        // if key is somewhere other than head
        while(currNode !=null && currNode.data != key){
            currNode = currNode.next;
        }
        if(currNode != null){
            Node newNode = new Node(data);
            newNode.next = currNode.next;
            currNode.next = newNode;
        }else{
            System.out.println(key + " key Not found");
        }
        return list;
    }
    public static LinkedList reverse(LinkedList list){
        // Node head = list.head;
        // if(head != null){
        //     Node prev = head;
        //     Node curr = head.next;
        //     Node next = curr.next;
        //     while(next != null){
        //         curr.next = prev;
        //     System.out.println("pointer check : " + curr.next.data);
        //         prev = curr;
        //         curr = next;
        //         next = next.next;
        //     }
        //     // take care of the end case
        //     curr.next = prev;
        //     head.next = null;
        //     list.head = curr;
        // }
        // return list;

        Node prev= null, curr = list.head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return list;
       
    }
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
   
        // Print the LinkedList 
        printList(list); 
        list =  delete(list, 2);
        // printList(list);
        list = delete(list, 10);
        // printList(list);
        list = insertAfter(list, 1,2);
        list = insertAfter(list, 8,9);
        list = insertAfter(list, 10,2);
        printList(list);
        list = reverse(list);
        printList(list);

    }
    
}
