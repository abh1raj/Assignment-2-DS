/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Scanner;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class List
{
    Node head;
    int size = 0;
    public void insertBeg(int data)
    {   
        
        Node node = new Node(data);
        size++;
        if(head==null)
        {
            head = node;
            
        }
        else
        {
           node.next = head;
           head = node;
        }
    }
    
    public void insertEnd(int data)
    {
        Node node = new Node( data);
        size++;
        if(head==null)
        {
            head = node;
        }
        
        else
        {
            Node current;
            current = head;
            while(current.next != null){
                current = current.next;          
            }
            
            current.next = node;
        }
    }
    
    public void traverse()
    {
        if(head == null)
        {
            System.out.println("List Empty!");
        }
        else
        {
            Node current;
            current = head;
            System.out.println("Elements:");
            while(current != null)
            {
                System.out.println(current.data);
                current = current.next;
            }
        }
        
        
}
    
    public void revTraverse(Node node)
    {
        if(node == null)
        {
            return;
        }
        revTraverse(node.next);
        System.out.println(node.data);
    }
    
    public void alternateTrav()
    {
        Node node = head;
        while(node!=null)
        {
            System.out.println(node.data);
            node = node.next;
            if(node!=null)
            {
                node = node.next;
            }
        }
    }
    
    public int retSize()
    {
        return size;
    }
    
    public void printMiddle()
    {
        Node temp = head;
        int mid = size/2;
        for(int i=1;i<mid;i++)
        {
            temp=temp.next;
        }
        
        System.out.println("Middle element = " + temp.data);
    }
    
    public void insertPos(int pos, int val)
    {
        Node temp = head;
        Node temp2;
        Node node = new Node(val);
        for(int i=1 ; i<pos-1 ; i++)
        {
            temp=temp.next;
        }
        temp2 = temp.next;
        temp.next = node;
        node.next = temp2;
        traverse();
    }
    
    public void delPos(int pos)
    {
        Node temp = head;
        if(pos==size)
        {
            
        }
        else
        {
            for(int i=1 ; i<pos-1 ; i++)
            {
                temp=temp.next;
            }
            if(temp.next != null)
            temp.next = temp.next.next;
        }
        
    }
    
    public void delBeg()
    {
        head = head.next;
    }
    
    public void delEnd()
    {
        Node temp;
        temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }
}

    
public class LL {

    
    public static void main(String[] args) {
        int pos,val;
        Scanner q = new Scanner(System.in);
        List l = new List();
        l.insertEnd(10);
        l.insertEnd(20);
        l.insertEnd(30);
        l.insertEnd(40);
        l.insertEnd(50);
        l.insertEnd(60);
        l.insertEnd(70);
        l.insertEnd(80);
        l.insertEnd(90);
        l.insertEnd(100);
        l.insertBeg(100);
        l.insertBeg(840);
        l.traverse();
        System.out.println("Enter position and value of new element:");
        pos = q.nextInt();
        val = q.nextInt();
        if(pos<=l.retSize() && pos>0)
            {
                l.insertPos(pos,val);
            }
        else
            {
                System.out.println("Position is out of bounds!");
            }
        
        l.traverse(); 
        System.out.println("Alternate:");
        l.alternateTrav();
        System.out.println("Middle Element:");
        l.printMiddle();
        System.out.println("Delete from position:");
        l.delPos(3);
        l.traverse();
        System.out.println("Delete from start:");
        l.delBeg();
        l.traverse();
        System.out.println("Delete from End:");
        l.delEnd();
        l.traverse();
        
    }
    
}
