/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
/*
  * @author DELL
 */
public class Borrowing {
     String borrowerName; // Protected ID
     int bookId;
     int studentId;
     String bookName; 
      String dateBorrowed;
      String dueDate; 
      String returnDate;
       static String details;
      Student student; // Reference to Student object
 
      ArrayList<Books> books; // List of borrowed books

     Borrowing(Student student, String borrowerName, int bookId, int studentId, String bookName,String dateBorrowed,String dueDate,ArrayList<Books>book) {
        this.student = student;//object of student, so manages borrowing for each student 
        this.borrowerName = borrowerName;
        this.bookId=bookId;//
        this.dateBorrowed=dateBorrowed;//
        this.studentId = studentId;//
        this.bookName = bookName;
        this.dueDate = dueDate;//
        
        this.books= new ArrayList<>(book);
        //the array thats passed into the constructor is used here 
    }

    // Update methods (consider using Date class for date manipulation)
    public void updateDueDate(String newDueDate) {
        // Implement logic to handle due date extension (e.g., with permission)
        this.dueDate = newDueDate;
    }

    public void returnBooks() {
        // Update book quantities (returned)
        for (var book : books) {
            //book.update(dateBorrowed); // Assuming update method in Book class handles returning
        }
        books.clear(); // Remove all borrowed books
    }
public static void create(int id,int StudentId,String dateBorrowed,ArrayList<Books> books,Student student,ArrayList<Transaction>transactions){
     Date currentDate = new Date();
      Calendar calendar = Calendar.getInstance();
      //making a calender object 
        calendar.setTime(currentDate);
        //current date
         
        calendar.add(Calendar.MONTH, 3);
 // Add 3 months to the current date
        
        Date dueDate = calendar.getTime();
        String duedates=dueDate+" ";
        //changing to string
// Gets the due date

    //id is bookId
    int qnty=student.qnty;
    if(qnty<3){
        for(Books book :books)
        //type Books, variable book, in list books 
    if(book.getId()==id){
        //checks for a match in the books array 
        book.remove();
//remove method decreases a quantity of the book from the books arrayList and returns a message if book unavailable
        details=student.name+book.title;// concatenating borrowers name and books name into a string to be used in transaction class
       
        
        Transaction t = new Transaction(student.id,id,details,dateBorrowed,duedates);
        student.addTransactions(t);
        System.out.println("Book borrowed successfully!");
        //add this record to transactions arrayList specific to the student
      Librarian.addTransactions(transactions,t);
                ////add this record to transactions arrayList for all transaction only visible to librarian
        }
    
    }
    else{
        System.out.println("You have reached the borrowing limit (3 books). Please return borrowed books to borrow more.");
    }
    
}
    // Additional methods (getters, setters for other fields, etc.)

 public static void borrowedBooks(ArrayList<Transaction>transaction,ArrayList<Books>books,Student student) {
        //takes in due date and date borrowed and checks the transaction array if the date lies between these two dates, 
        //prints the the book from book array 
        String dueDate;
String dateBorrowed;
         
        Date date = new Date();
        for (Transaction trans: transaction) {

            String[] due = trans.dueDate.split("/");
            String[] borrow = trans.date.split("/");
            //stores date index 0, month index 1, year index 2
            String[] days = date.toString().split(" ");//the array days stores the date from java.util.date class 
            // stores month in the first index 1, day is the second 2 and year in the fifth  5
            //System.out.println(days[1]);
            switch (days[1]) {
                case "Jan":
                    days[1] = "1";
                case "Feb":
                    days[1] = "2";
                case "Mar":
                    days[1] = "3";
                case "Apr":
                    days[1] = "4";
                case "May":
                    days[1] = "5";
                case "Jun":
                    days[1] = "6";
                case "Jul":
                    days[1] = "7";
                case "Aug":
                    days[1] = "8";
                case "Sep":
                    days[1] = "9";
                case "Oct":
                    days[1] = "10";
                case "Nov":
                    days[1] = "11";
                case "Dec":
                    days[1] = "12";
            }
//gets month in number form
if (trans.getId()==(student.id)){
    
            // id is the defined in the class of this particular student and trans.getId() searches the arrayList 
            //to only print books currently borrowed from this particular student
            if (Integer.parseInt(due[2]) > Integer.parseInt(days[5]) && Integer.parseInt(borrow[2]) < Integer.parseInt(days[5])) {
                //converting the string elements to int, in order for it to be compared 
                //get todays date if duedate>todays date and if borrowingDate<todaysDate meaning its not overdue or else all past books will be considered

                if (Integer.parseInt(due[1]) > Integer.parseInt(days[1]) && Integer.parseInt(borrow[1]) < Integer.parseInt(days[1])) {
                    //checking month which is stored in index 1 in days and index 1 in due and borrow

                    if (Integer.parseInt(due[0]) > Integer.parseInt(days[2]) && Integer.parseInt(borrow[0]) < Integer.parseInt(days[2])){
                        int bookId=trans.bookId;
                        for(Books book:books){
                            if(book.id==bookId){
                                System.out.println("book borrowed was "+ book.toString());
                                // toString method in book prints the book 
                            }
                        }
                          
                          
                    }
                    else{
                        System.out.println("no borrowed books");
                    }
                    //checking day which is stored in index 2 in days and index 0 in due and borrow

                  
                    
                }
                 else{
                        System.out.println("no borrowed books");
                    }
            }
             else{
                        System.out.println("no borrowed books");
                    }
            
        }
        
    }
 }
 
    @Override
    public String toString() {
        return "Borrowing [borrowerName=" + borrowerName + ", studentId=" + studentId + ", bookName=" + bookName + ", dueDate=" + dueDate + ", books=" + books;
        
}
}
