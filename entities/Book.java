/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.entities;

import library.interfaces.entities.EBookState;

import library.interfaces.entities.ILoan;

/**
 *
 * @author bendev
 */

public class Book {
    
    /*
       author:String, title:String, callNumber:String, bookID:int 
    throws IllegalArgumentException if:  
    any of author, title, or callNumber are null or blank || 
    bookID is less than or equal to zero 
    */
    private String author;
    private String title;
    private String callNumber;
    private int bookID;
    ILoan loan;
    EBookState state;
    
    public Book( ILoan loan,EBookState state,String author, String title, String callNumber, int bookID) {
    
        if(author.equals(null)||author.equals("")||title.equals(null)||title.equals("")||callNumber.equals(null)||callNumber.equals("")||bookID<=0){
            throw new IllegalStateException("Error object not initialised ");
            
    }
   
    
}
    public void Borrow(){
        
    }
    ILoan getLoan(){
        /*
        getLoan: ILoan 
        returns the loan associated with the book 
        returns null if:
 	the book is not current ON_LOAN
        */
        if(state==EBookState.ON_LOAN)
        return loan;
        
        return null;
    }
    
    public void ReturnBook(boolean damaged){
        /*
          Parameters: damaged:boolean 
          removes the loan the book is associated with if: 
          damaged sets the BookState to DAMAGED 
          else 
          sets the BookState to AVAILABLE 
          throws RuntimeException if: 
          the book is not currently ON_LOAN 

        */
        if(state==EBookState.DAMAGED){
            state=EBookState.DAMAGED;
        }
        else{
            state=EBookState.AVAILABLE;
            if(state!=EBookState.ON_LOAN){
                throw new RuntimeException("Book is " + state);
            }
        }
        
        
    }
    
    public void lose(){
        /*
         sets the BookState to LOST 
         throws RuntimeException if: 
         the book is not currently ON_LOAN 
 
        */
        state=EBookState.LOST;
        
        if(state!=EBookState.ON_LOAN){
            throw new RuntimeException("Book is " + state);
        }
        
        
    }
    
    public void repair(){
        /*
          sets the BookState to AVAILABLE 
          throws RuntimeException if:  the book is not currently DAMAGED 
        */
        state =EBookState.AVAILABLE;
        
        if(state!=EBookState.DAMAGED){
             throw new RuntimeException("Book is " + state);
        }
        
        
    }
    public void dispose(){
        /*
        sets the BookState to DISPOSED 
        throws RuntimeException if: 
        the book is not currently AVAILABLE, DAMAGED, or LOST 

        */
        
        state=EBookState.DISPOSED;
        if(state!=EBookState.DAMAGED||state!=EBookState.AVAILABLE||state!=EBookState.LOST){
             throw new RuntimeException("Book is " + state);
        }
    }
    
    EBookState getState(){
        //returns the book’s current BookState 

        return state;

        
    }
    
    public String getAuthor(){
        //returns the book’s author 
        return author;
    }
    
    public String getTitle(){
        //returns the book’s title 
        return title;
    }
    public String getCallNumber(){
        //returns the call number 
        return callNumber;
    }
    public int getID(){
        //returns the bookID
        return bookID;
    }
    
    
    
    
}