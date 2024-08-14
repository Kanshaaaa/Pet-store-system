/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testlibrary;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static testlibrary.Student.arrayTrans;
import static testlibrary.Student.booksArray;
import static testlibrary.Student.choice;
import static testlibrary.Student.input;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class TestLibrary {

    /**
     * @param args the command line arguments
     */
   static  Scanner input = new Scanner(System.in);
    static  ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Librarian> librarians = new ArrayList<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();
    static ArrayList<Books> books = new ArrayList<>();  // Assuming Book class is implemented

    
    public static void main(String[] args) {
        // TODO code application logic here

        String day;
        String month;
        String year;
        String userName;
        String password;
        String name;
        String course;
        String department;
        String studentId;//student id
        String age;
        int qty;
        Boolean access;
        int bookId;
        access = false;
        System.out.println("");
        Scanner input = new Scanner(System.in);
      
       // ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        
        //librarian=createLibrarianArray();
        
       
       students = createStudentArray(students);
        librarians=createLibrarianArray(librarians);
        transactions=createTransactionArray(transactions);
         books = createBooksArray(books);
       // ArrayList<Books> books = new ArrayList<>(Arrays.asList(booksArray));
       
        //array of type book initialization 
        // the method createBooksArray initializes and returns an array of type Books which is referenced by booksArray
        //ArrayList<Books> books = new ArrayList<>();

        int choice;

        do {
//login or sign up menu
            System.out.println("\nWelcome to the Library!");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 2);//the choice must be either 1 or 2  if anything else, keep looping until correct input

        // Login or Signup Logic
        if (choice == 1) {
            //call the log-in function which creates either the student or the librarian objects 
            handleLogin(students,librarians);
        } else {
            // call the sign up function which creates either the student or the librarian objects 
            handleSignup(students, librarians, input, booksArray, books);
        }

        
    }

    private static void handleLogin(ArrayList<Student> students, ArrayList<Librarian> librarian) {
        System.out.println("Create account as: ");
        System.out.println("1. Student");
        System.out.println("2. Librarian");
        choice = input.nextInt();
        switch (choice) {
            case 1: // login as student
               
                boolean studentPresent=false;
                System.out.print("Enter username: ");
                String username = input.next();
                System.out.print("Enter password: ");
                String password = input.next();
                // iterate through the arrayList using a for each loop to check for a match, retuens true if able to access
                for (Student student : students) {
                    if (student.userName.equals(username) && student.password.equals(password)) {
                        studentPresent=true;
                        student = findStudent(username, students);
                        //displaying menu
                        System.out.println("1.Borrow books\n2.view transactions");

                        choice = input.nextInt();
                        switch (choice) {
                            //int id,String StudentId,String dateBorrowed,ArrayList<Books> books,Student student){
    
                            case 1: int bookId = Student.browsebooks(books);
                    Date date = new Date();
                    //initialises this to todays dat
                    String[] dateBorrowedArray = date.toString().split(" ");
                    String dateBorrowed = dateBorrowedArray[2] + dateBorrowedArray[1] + dateBorrowedArray[5];
                    //String[] days = date.toString().split(" ");//the array days stores the date from java.util.date class 
                    // stores month in the first index 1, day is the second 2 and year in the fifth  5  
                    int studentId= student.getId() ;

                    Borrowing.create(bookId, studentId, dateBorrowed, books, student,transactions);
                    break;

                            case 2:
                                 student.viewTransactions(transactions,student);
                              //  Borrowing.borrowedBooks(arrayTrans, booksArray, student);
                                 break;
                           /* case 3:  
                                 Borrowing.borrowedBooks(transactions,books,student);
                                    break;
                                 */

                        }
                    } 
                    
                }
                
                if (studentPresent==false){
                    System.out.println("invalid credentials");
                }
                
                break;

            case 2://if librarian chosen for login
                //checking user name and password by iterating throught the array list using a for each loop
                boolean accessLib=false;
                boolean available=false;
                System.out.print("Enter username: ");
                String userName = input.next();
                System.out.print("Enter password: ");
                String passwordLib = input.next();
                // iterate through the arrayList using a for each loop to check for a match, retuens true if able to access
                for (Librarian libr : librarian) {
                    if (libr.username.equals(userName) && libr.password.equals(passwordLib)) {
                        accessLib=true;
                        System.out.println("choose what you wish to do \n[1]view transactions for all students\n[2]disable or enable access for a student ");
                        int select = input.nextInt();
                        switch (select) {
                            case 1://code for viewing transactions
                                Librarian.viewTransactions(transactions);
                                break;
                            case 2://code for viewing chaning access
                                System.out.print("enter the studentId of the student you wish to change access for: ");
                                String changedId = input.next();
                                
                                for (Student student : students) {
                                    if (student.id == Integer.parseInt(changedId)) {
                                        available=true;
                                        Student stu = student;
                                        //creating a new student object to stoe this disable student, later passed to te disabled user method
                                        System.out.println("[1]enable access\n[2]disable access");
                                        int changedAccess = input.nextInt();
                                        switch (changedAccess) {
                                            case 1:
                                                Librarian.enableUser(stu);
                                                break;
                                            case 2:
                                                Librarian.disableUser(stu);
                                                break;

                                        }
                                    } 
                                }
                                
                                
                            break;
                        }

                    } 
                }
                if(available==false){
                                    System.out.println("student ID not found");
                                }
                if(accessLib==false){
                    System.out.println("invalid credentials");
                }
                break;
        }

    }

    private static Student findStudent(String username, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.userName.equals(username)) {
                return student;
            }
        }
        return null; // Indicate student not found 
    }

    
    

    private static void handleSignup(ArrayList<Student> students, ArrayList<Librarian> librarians, Scanner input, Books[] booksArray, ArrayList<Books> books) {
        int choice;

        System.out.println("Create account as: ");
        System.out.println("1. Student");
        System.out.println("2. Librarian");
        choice = input.nextInt();

        if (choice == 1) {
            // Create student object

            //displaying menu
            Student student = createStudent(students);
            
           System.out.println("1.Borrow books \n 2.view transactions");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    int bookId = Student.browsebooks(books);
                    Date date = new Date();
                    //initialises this to todays dat
                    String[] dateBorrowedArray = date.toString().split(" ");
                    String dateBorrowed = dateBorrowedArray[2] + dateBorrowedArray[1] + dateBorrowedArray[5];
                    //String[] days = date.toString().split(" ");//the array days stores the date from java.util.date class 
                    // stores month in the first index 1, day is the second 2 and year in the fifth  5  
                   int studentId = student.getId() ;

                    Borrowing.create(bookId, studentId, dateBorrowed, books, student,transactions);
                    break;
                case 2:
                      student.viewTransactions(transactions,student);
                   break;
               /* case 3:
                    Borrowing.borrowedBooks(transactions,books,student);
               break;
              */
                
                  

            }
            //create student returns student which is passed to display menu which is passed to borrowedBooks
            //a function that shows menu for student class and sends the transaction list as an array to the borrowing function

        } 
        else if (choice == 2) {
            // Create librarian object
            createLibrarian(librarians);
            System.out.println("choose what you wish to do \n [1]view transactions for all students \n[2] disable or enable access for a student ");
            int select = input.nextInt();
            
            switch (select) {
                case 1:
                    Librarian.viewTransactions(transactions);
                    break;
                case 2:
                    System.out.println("enter the studentId of the student you wish to change access for");
                    boolean access=false;
                    String changedId = input.next();
                    for (Student student : students) {
                        if (student.id == Integer.parseInt(changedId)) {
                            access=true;
                            Student stu = student;
                            //creating a new student object to store this disable student, later passed to te disabled user method
                            System.out.println("[1]enable access \n [2]disable access");
                            int changedAccess = input.nextInt();
                            switch (changedAccess) {
                                case 1:
                                    Librarian.enableUser(stu);
                                    break;
                                case 2:
                                    Librarian.disableUser(stu);
                                    break;

                            }
                        } 
                        else {
                            access=false;
                        }
                    }
                    /*
                    if(access==false){
                        System.out.println("studentId not found");
                    }
*/
                  break;

            }

        }
        else {
            System.out.println("Invalid choice.");

        }
    }

    private static Student createStudent(ArrayList<Student> students) {
        // Collect student information and create a Student object
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter year: ");
        String year = input.nextLine();
        System.out.print("Enter course: ");
        String course = input.nextLine();
        System.out.print("Enter age: ");
        String age = input.nextLine();
        int id = (int) (Math.random() * 100000);
        System.out.println("Your ID is: " + id);

        Student student = new Student(id, name, age, course, year, username, password, 0); // Initial quantity borrowed is 0
        students.add(student);
        return student;
    }

    private static void createLibrarian(ArrayList<Librarian> librarians) {
        // Collect librarian information and create a Librarian object

        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter age: ");
        String age = input.nextLine();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter department: ");
        String department = input.nextLine();
        
       //ask for logIn inoformation
      Librarian librarian= new Librarian(name,age,username,password,department);
      librarians.add(librarian);
      //adds new librarian object to the librarian arrayList
        System.out.println(name);
    }
    public static ArrayList<Books> createBooksArray(ArrayList<Books>books) {
        
       books.add(new Books(1, "Pride and Prejudice", "Classic Literature", "A witty comedy of manners by Jane Austen", "Penguin Classics", 5));
        books.add( new Books(2, "To Kill a Mockingbird", "Historical Fiction", "A poignant coming-of-age story by Harper Lee", "HarperCollins", 3));
        books.add(new  Books(3, "The Lord of the Rings", "Fantasy", "An epic saga by J. R. R. Tolkien", "Houghton Mifflin Harcourt", 3));
        books.add(new  Books(4, "One Hundred Years of Solitude", "Magical Realism", "A landmark novel by Gabriel Garcia Marquez", "Penguin Random House", 1));
        books.add(new  Books(5, "The Hitchhiker's Guide to the Galaxy", "Science Fiction Comedy", "A humorous space adventure by Douglas Adams", "Pan Macmillan", 4));
        books.add(new Books(6, "The Great Gatsby", "American Literature", "A classic exploration of the American Dream by F. Scott Fitzgerald", "Scribner", 7));
        books.add(new  Books(7, "Frankenstein", "Gothic Fiction", "A chilling tale by Mary Shelley", "Dover Publications", 1));
        books.add(new Books(8, "Beloved", "Historical Fiction", "A powerful novel by Toni Morrison", "Alfred A. Knopf", 2));
        books.add(new Books(9, "The Catcher in the Rye", "Coming-of-Age", "A poignant story of teenage angst by J. D. Salinger", "Little, Brown and Company", 6));
       books.add(new  Books(0, "1984", "Dystopian Fiction", "A chilling vision of the future by George Orwell", "Penguin Classics", 3));
        books.add(new  Books(11, "The Handmaid's Tale", "Dystopian Fiction", "A thought-provoking novel by Margaret Atwood", "Anchor Books", 4));
        books.add(new  Books(12, "The Book Thief", "Historical Fiction", "A moving story of resilience during war by Markus Zusak", "Random House", 5));
       books.add(new  Books(13, "Things Fall Apart", "African Literature", "A powerful story of colonialism by Chinua Achebe", "Anchor Books", 2));
       books.add(new  Books(14, "Jane Eyre", "Classic Literature", "A gothic romance by Charlotte Bronte", "Penguin Classics", 8));
        books.add(new  Books(15, "The Adventures of Huckleberry Finn", "Coming-of-Age", "A satirical novel by Mark Twain", "Dover Publications", 1));
        books.add(new  Books(16, "The Three Musketeers", "Historical Adventure", "A swashbuckling tale by Alexandre Dumas", "Oxford University Press", 4));
        books.add(new  Books(17, "The Count of Monte Cristo", "Adventure", "A story of revenge and redemption by Alexandre Dumas", "Penguin Classics", 3));
        books.add(new  Books(18, "The Metamorphosis", "Short Story, Absurdism", "A thought-provoking story by Franz Kafka", "Penguin Classics", 5));
        return books;
    }
    
    
    public static ArrayList<Student> createStudentArray(ArrayList<Student> students){
        
        
        students.add(new Student(1, "Omar", "18", "Computer Science", "Freshman", "omar123", "password1", 1));
    students.add(new Student(2, "Layla", "20", "Mathematics", "Sophomore", "layla456", "password2", 2));
   students.add(new Student(3, "Karim", "19", "Engineering", "Freshman", "karim789", "password3", 3));
    students.add(new Student(4, "Dina", "21", "Biology", "Junior", "dina012", "password4", 1));
   students.add( new Student(5, "Sewar", "19", "Software Engineering", "Freshmen", "sewar", "sewar1", 2));
    students.add(new Student(6, "Fatima", "18", "Chemistry", "Freshman", "fatima678", "password6", 1));
   students.add(new Student(7, "Kinzah", "19", "Software Engineering", "Freshmen", "kinzah", "huhuhu", 2));
   students.add( new Student(8, "Hana", "19", "Literature", "Freshman", "hana234", "password8", 2));
    students.add(new Student(9, "Ibrahim", "21", "Economics", "Junior", "ibrahim567", "password9", 1));
   students.add( new Student(10, "Jameela", "22", "Philosophy", "Senior", "jameela890", "password10", 0));
   students.add( new Student(11, "Khalid", "18", "Computer Science", "Freshman", "khalid123", "password11",2 ));
   students.add( new Student(12, "Laila", "20", "Mathematics", "Sophomore", "laila456", "password12", 3));
    students.add(new Student(13, "Mariam", "19", "Engineering", "Freshman", "mariam789", "password13", 2));
    students.add(new Student(14, "Aminah", "19", "Software Engineering", "Freshmen", "aminah", "aminah1", 1));
    students.add( new Student(15, "Aisha", "22", "Physics", "Senior", "aisha345", "password15", 0));

return students;
    }
    public static ArrayList<Transaction> createTransactionArray(ArrayList<Transaction> transactions){
       
        transactions.add( new Transaction(1, 3, "Omar The Lord of the Rings", "01/05/2023", "31/05/2023"));
    transactions.add( new Transaction(2, 16, "Layla The Three Musketeers", "10/05/2023", "20/06/2023"));
    transactions.add(new Transaction(3, 2, "Karim To Kill a Mockingbird", "15/05/2023", "15/07/2024"));
    transactions.add( new Transaction(4, 1, "Dina Pride and Prejudice", "20/05/2024", "30/06/2024"));
    transactions.add( new Transaction(5, 5, "Sewar The Hitchhiker's Guide to the Galaxy", "25/04/2024", "10/07/2024"));
    transactions.add(new Transaction(6, 3, "Fatima The Lord of the Rings", "01/04/2024", "30/06/2024")); 
    transactions.add(new Transaction(7, 12, "Kinzah The Book Thief", "10/04/2024", "20/07/2024"));
    transactions.add(new Transaction(8, 7, "Hana Frankenstein", "15/04/2024", "15/08/2024"));
    transactions.add( new Transaction(9, 13, "Ibrahim Things Fall Apart", "20/06/2024", "31/07/2024"));
   transactions.add( new Transaction(10, 18, "Jameela The Metamorphosis", "25/06/2024", "10/08/2024"));

    return transactions;
    }
   
    
    public static ArrayList<Librarian> createLibrarianArray(ArrayList<Librarian>librarians){
        
         librarians.add(new Librarian("Uthman", "35", "uthman123", "password1", "Computer Science"));
    librarians.add( new Librarian("Ali", "42", "ali456", "password2", "Engineering"));
    librarians.add( new Librarian("Karim", "28", "karim789", "password3", "Medicine"));
    librarians.add( new Librarian("Ahmed", "50", "ahmed012", "password4", "Literature"));
    librarians.add( new Librarian("Arwa", "30", "arwa", "password5", "History"));
return librarians;
    }
       
}
