/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlibrary;

/**
 *
 * @author Kinzah 
 */
public class User {
    protected int id; 
    String name;
    String age;
    protected String userName;
    protected String password;
    
    
    User(String name,String age,String userName,String password){
        this.name=name;
        this.age=age;
        this.userName=userName;
        this.password=password;
    }
    public void create(int id,String name,String age,String userName,String password){
        this.name=name;
        this.id=id;
        this.userName=userName;
        this.age=age;
        
    }
    public void update(){
        
    }
}
