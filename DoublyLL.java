
package datastructures;

class Node1
{
    int data;
    Node1 next,prev;
    Node1(int data)
    {
        this.data = data;
    }
}

class DLL
{
    int size = 0;
    Node1 head,tail;
    public void insEnd(int data)
    {
        Node1 node = new Node1(data);
        
        if(head == null)
        { 
            head = node;
            tail = node;
        }
        
        else
        {
            tail.next = node;
            node.prev = tail;
            tail=node;
            
        }
        size++;
    }
    
    public void insBeg(int data)
    {
        Node1 node = new Node1(data);
        
        if(head == null)
        {
            head = node;
            tail = node;
        }
        
        else
        {
            node.next = head;
            head.prev = node;
            head = node;
        }
        
        size++;
    }
    
    public void trav()
    {
        Node1 temp = head;
        if(head == null)
        {
            System.out.println("List Is Empty!");
        }
        else
        {
            while(temp != null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    
    public void revTrav()
    {
        if(head == null)
        {
            System.out.println("List Is Empty!");
        }
        
        else
        {
            Node1 temp = tail;
            while(temp != head.prev)
            {
                System.out.println(temp.data);
                temp = temp.prev;
            }
        }
    }
    
    
    
    public void delBeg()
    {
        if(size ==1)
        {
            head = null;
        }
        if(head==null)
        {
            System.out.println("List is Empty!");
        }
        
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    
    public void delEnd()
    {
        if(size ==1)
        {
            head = null;
        }
        
        if(head == null)
        {
            System.out.println("List is empty!"); 
        }
        
        else{
            tail = tail.prev;
            tail.next = null;
        }
        
        size--;
    }
    
    public void delPosition(int n)
    {
        Node1 temp = head;
        Node1 temp2 = head;
        if(n>size)
        {
            System.out.println("Out of bounds!");
        }
        else
        {
            for(int i=1 ; i<n-1 ; i++)
            {
                temp=temp.next;
            }
            
            if(temp.next != null)
            {
                temp2 = temp.next.next;
                temp.next = temp2;
                temp2.prev = temp;
            }
            
        }
        size--;
    }
    
}

public class DoublyLL {
    public static void main(String[] args) {
        
        DLL d = new DLL();
        d.insBeg(10);
        d.insEnd(20);
        d.insBeg(99);
        d.insEnd(88);
        d.insEnd(30);
        d.insEnd(40);
        d.insEnd(50);
        d.insBeg(0);
        d.insBeg(9465);
        System.out.println("Elements are:");
        d.trav();
        System.out.println("After deletion:");
        d.delBeg();
        d.delBeg();
        d.delBeg();
        d.trav();
        System.out.println("after deletion from end:");
        d.delEnd();
        d.delEnd();
        d.trav();
        d.delBeg();
        System.out.println("In Reverse Order:");
        d.revTrav();
        System.out.println("After deleting from position:");
        d.delPosition(3);
        d.trav();
    }
    
}
