/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Math;

/**
 *
 * @author DELL
 */
public class Transaction {
        protected int id;//student id
        //public String transactionId;
        public int bookId;
        public String studentId;
    public String details;
    public String date;// borrowing date
   // public String borrowingDate;//date it was borrowed at
    public String dueDate;//date it wil be return at
    
    public int transactionId;
     
    // private ArrayList<Transaction> transactions = new ArrayList<>();
    

    public ArrayList<Student> stuTrans = new ArrayList<>();
    Random random;
    // have a studrent array here
   
    Transaction(int id,int bookId,String details,String date,String dueDate){
        this.id=id;
        this.bookId=bookId;
        this.details=details;
        this.date=date;
       //this.borrowingDate=borrowingDate;
       this.dueDate=dueDate;
       
       this.transactionId=((int)(Math.random()*10));
             
              
      

}
    public void storeTrans(String stuTrans){
        
        
    } 
     public int getId(){
        return id;
    }
    public void update(String dueDate){
        // this method updates the due due of the book 
        this.dueDate=dueDate;
    }
    
     
     
     public void printStuTrans(String id){
       for(int i =0;i<stuTrans.size();i++){
           System.out.println(stuTrans.get(i));
       }
     }
     
     @Override
    public String toString() {
        return  "Transactio ID"+ transactionId +" "+
                "Student id=" + id +
                ", Book ID=" + bookId + " " +
                ", Borrower name and bookname=" + details + " " +
                " borrowing date= " + date + " " +
               " due date  " + dueDate +" "+
               
                
                '}';
    }
   
}
