/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Scanner;


public class Student extends User {

    String course;
    String year;
    protected int id; //make all data fields private  check w uml diagram
    String userName;
    String password;
    String name;
    String age;
    Boolean access;
    int qnty;
    static int choice;
    private static  ArrayList<Transaction> transactions = new ArrayList<>();//linking transactions with each student
    
    //static Transaction t =new Transaction(2,"dsc","fdvsf","rvw","wver","wdvwffd","wrfcv","wdvwffd");
    //int id,String bookId,String details,String date,String borrowingDate,String dueDate,String returnDate
    
    static Scanner input=new Scanner(System.in);
static Transaction[] arrayTrans= new Transaction[transactions.size()];
public static Books[] booksArray=new Books [30];//the orig books array
//pass an array to borrowing of type transaction it prints all books borrowed  student.transaction[]
        //make books an array list
    //static Scanner input = new Scanner(System.in);

    Student(int id, String name, String age, String course, String year, String userName, String password, int qnty) {
        //super(id,name,age,userName,password);
        super(name, age, userName, password);
        this.course = course;
        this.year = year;
        this.userName=userName;
        this.id=id;
        this.password=password;
        this.name=name;
        this.age=age;
        this.transactions = new ArrayList<>();//each student has an empty transaction at first;
      this.access=true;
    }

    public int getId(){
        return id;
    }
public void changeAccess(Boolean access){
    this.access=access;
}
    public void addTransactions(Transaction t){
        transactions.add(t);
        //adds a transaction for 
    }
    public static int browsebooks(ArrayList<Books> books) {
        //the student selects the book they wish to boorow
        for(Books bookvar:books){
            System.out.println(bookvar.id +" "  +bookvar.title+" "+bookvar.details+" "+ bookvar.genre+" "+bookvar.quantity);
            
            
        }
        System.out.println("enter the bookId for the bookn you wish to borrow");
        int bookId=input.nextInt();
        return bookId;
//enters the bookId which is returned from this method
    }
    
     public void viewTransactions(ArrayList<Transaction>transactions,Student student){
        if(transactions.isEmpty()){
            System.out.println("No transactions found");
        }
        else{
            System.out.println("Past Transactions for "+userName);
            for(Transaction trans:transactions){
                if(trans.id==student.id)
             System.out.println(trans.toString());
             
        }
        }
        
       
    }
    
    

}


