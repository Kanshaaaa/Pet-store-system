/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Librarian extends User {
     
   /* private ArrayList<String> disabledUsers;
    private ArrayList<String> userIDs;
    private ArrayList<Integer> borrowedBooks;
    private ArrayList<String> userPasswords;
*/
    private String department;
    String name;
    String username;
    String password;
    String age;
    private boolean access; // Boolean variable to control access

  private ArrayList<String> disabledUsers;
    private ArrayList<String> userIDs;
    private ArrayList<Integer> borrowedBooks;
    private ArrayList<String> userPasswords;
    
   // private static  ArrayList<Transaction> transactions = new ArrayList<>();
    //an arrayList for all transactions for the librarian to view shows librarian transaction relationship

    public Librarian(String name,String age,String username,String password,String department) {
        super(name,age,username,password);
        this.name=name;
        this.age=age;
        this.username=username;
        this.password=password;
        this.department=department;
        this.department = department;   
        this.disabledUsers = new ArrayList<>();
        this.userIDs = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.userPasswords = new ArrayList<>();
        this.access=true;
        
    }

 public static void enableUser(Student stu) {
        if (stu.qnty < 3) {
           stu.changeAccess(true); // Grant access for purchasing
            System.out.println(stu.name+" has their Access granted for purchasing.");
        } else {
            stu.changeAccess(false);// Deny access for purchasing
            System.out.println(stu.name +" has their Access denied for purchasing due to borrowing limit.");
        }
    }
    
    public static void disableUser(Student student) {
        student.changeAccess(false);
        //access = false; // Deny access for purchasing
        System.out.println(student.userName+" has their Access denied for purchasing due to late book returns.");
    }
    
    public static void addTransactions(ArrayList<Transaction>transactions,Transaction t){//method declared static so that no librarian object needs to be created for adding transactions
        transactions.add(t);
        //adds a transaction for all students
        
    }
    
    public static void viewTransactions(ArrayList<Transaction>transactions){
        if(transactions.isEmpty()){
            System.out.println("No transactions found");
        }
        else{
            System.out.println("Past Transactions fo all students");
            for(Transaction trans:transactions){
             System.out.println(trans.toString());
             
        }
        }
        
       
    }
}
