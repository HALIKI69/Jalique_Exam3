
package jaliqueexam3;

import java.util.Scanner;


public class JaliqueExam3 {
private class PriorityQueuesArray{
            
            int priority;
            int data;
          
       PriorityQueuesArray next;           
        }

    private PriorityQueuesArray front = null;
   static int printCount = 0;
    public int deletion() throws Exception{
          if (front == null){
              throw new Exception("Queue is Empty");
          } 
          int temporary = front.data;
          front = front.next;
            
           return temporary; 
        
        }
    private void insertion(int item, int priority){
            PriorityQueuesArray node = new PriorityQueuesArray();
            node.data=item;
            node.priority = priority;
            node.next = null;
            
            
            if (front == null || priority <= front.priority) {
                node.next = front;
                front = node;
            }
            else{
                PriorityQueuesArray temporary = front;
                while (temporary.next != null && temporary.next.priority <= priority) {                    
                    temporary = temporary.next;
                }
                   node.next = temporary.next;
                   temporary.next = node;
               printCount++;
               
               }
            
        }
     
        public void display() throws Exception{
            if (front == null){
              throw new Exception("Queue is Empty");
          }
            PriorityQueuesArray temporary = front;
            
            System.out.println("Priority \t\t Pages");
            
            while(temporary != null){
              
                   System.out.println(temporary.priority + "\t\t" + temporary.data);
                temporary = temporary.next;

            }
            System.out.println("\n");
        }
    public static void main(String[] args) throws Exception {
        JaliqueExam3 list = new JaliqueExam3();
        Scanner scanner = new Scanner(System.in);
        boolean ins = true;
        while (ins) {            
            System.out.println("Enter Pages: ");
                    int item = scanner.nextInt();
                    System.out.println("Enter Priority: ");
                    int priority = scanner.nextInt();
                      
                    list.insertion(item, priority);
                     if(printCount>4){
                         list.deletion();
                     }
                        
                    
                    list.display();
        }
                
    }
    
}
