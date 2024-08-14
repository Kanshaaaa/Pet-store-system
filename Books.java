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
import java.util.Date;
   public class Books {

    protected int id; // book id
    public String title;
    public String details; // Additional book information
    public String publisher;
    public String genre;
    public int quantity;
    public boolean available;
    //change array to an array list here ArrayList<Books> books = new ArrayList<>(); 

     Books(int id, String title,String genre, String details, String publisher, int quantity) {
        this.id = id;
        this.title = title;
        this.genre=genre;
        this.details = details;
        this.publisher = publisher;
        this.quantity = quantity;
        this.available = true; // Initially available
        
     
    }
     
     
//Arraylist<Books> books = new ArrayList<>(Arrays.asList(booksArray)); might need to pass a function from main class with the array
    public int getId() {
        return id;
    }

    
//write set methods for all including genre 
    public boolean isAvailable() {
        return available;
    }

    public void add() {
        quantity++;
        available = true; // If available, add a book
    }
    public void remove() {
        if (available==false){
        System.out.println("book not available ");
       
        }
        else{
            quantity--;
        if (quantity<=0){
            available = false; 

        }
        }
        
    }
    

    public void update(Date dateBorrowed) { //if a book 
        if (dateBorrowed == null) {
            available = true; // Book returned, increase quantity
            quantity++;
        } else {
            available = quantity > 0; // Book borrowed, decrease quantity if available
            if (available) {
                quantity--;
            }
        }
    }


    public boolean checkAvailability() {
        return available;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", details=" + details + ", publisher=" + publisher +
                ", quantity=" + quantity + ", available=" + available + "]";
    }
}