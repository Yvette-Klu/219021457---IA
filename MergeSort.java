/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Eliezer Klu
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    
    node head = null;
    
    static class node {
        int value;
        node next;
 
        public node(int value)
        {
            this.value = value;
        }
    }
    
    
      node sortedMerge(node ap, node bp)
    {
        node fresult = null;
        /* Base cases */
        if (ap == null)
            return bp;
        if (bp == null)
            return ap;
 
        /* Pick either ap or bp, and recur */
        if (ap.value <= bp.value) {
            fresult = ap;
            fresult.next = sortedMerge(ap.next, bp);
        }
        else {
            fresult = bp;
            fresult.next = sortedMerge(ap, bp.next);
        }
        return fresult;
    }
      
      
      node mergeSort(node h)
    {
        // Base case 
        if (h == null || h.next == null) {
            return h;
        }
 
        // get the middle of the list
        node middle = GetMiddle(h);
        node nextofthemiddle = middle.next;
 
        // set the next of middle node to null
        middle.next = null;
 
        // Apply mergeSort on left list
        node left = mergeSort(h);
 
        // Apply mergeSort on right list
        node right = mergeSort(nextofthemiddle);
 
        // Merges the left and right list
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
      
      public static node GetMiddle(node head)
    {
        if (head == null)
            return head;
 // s = slow f =  fast 
        node s = head, f = head;
 
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
      
      void push(int newData)
    {
        // assign node 
        node new_node = new node(newData);
 
        //link the old list of the new node 
        new_node.next = head;
 
        // move the head to point to the new node 
        head = new_node;
    }
 
    //  print the linked list
    void printList(node headreference)
    {
        while (headreference != null) {
            System.out.print(headreference.value + " ");
            headreference = headreference.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        MergeSort list = new MergeSort();
        
        list.push(18);
        list.push(12);
        list.push(5);
        list.push(24);
        list.push(1);
        list.push(2);
 
        System.out.print("\n unsortedSorted Linked List is: ");
        list.printList(list.head);
        list.head = list.mergeSort(list.head);
        System.out.print("\n Sorted Linked List is: " );
        list.printList(list.head);
    

 
    }
    
}
