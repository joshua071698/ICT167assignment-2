/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ospi;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author joshu
 */
public class Book implements Comparable<Book>{

    private String BookTitle;
    private int BookID;
    private String ISBN;
    private String Author;
    private int Pages;
    private String Datestr;
    private String BName;
    int days;
    //private String genre;

    public Book() //default constructor
    {

    }

    public Book(String BookTitle, int BookID, String ISBN, String Author, int Pages, String Datestr, String BName) //constructor with parameter
    {
        this.BookTitle = BookTitle;
        this.BookID = BookID;
        this.ISBN = ISBN;
        this.Author = Author;
        this.Pages = Pages;
        this.Datestr = Datestr;
        this.BName = BName;
        //this.genre = genre;
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date dateissued = sdf.parse(Datestr.replace("\"", ""));
            Date datenow = Date.from(Instant.now());
            long diff = datenow.getTime() - dateissued.getTime();

            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            this.days = diffDays;
        } 
        catch (Exception e) 
        {
        }
    }


    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    public String getBookTitle() {
        return BookTitle;
    }

    public int getBookID() {
        return BookID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getDate() {
        return Datestr;
    }

    public String getAuthor() {
        return Author;
    }

    public int getPages() {
        return Pages;
    }

    public String getBName() {
        return BName;
    }
/*
    public String getGenre() {
        return genre;
    }
*/
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setPages(int Pages) {
        this.Pages = Pages;
    }

    public void setDate(String Date) {
        String[] data = Date.split("/");
        int month = Integer.parseInt(data[0]);
        int day = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
    }

    public void setBName(String BName) {
        this.BName = BName;
    }
/*
    public void setGenre(String genre) {
        this.genre = genre;
    }
*/
    @Override
    public String toString() {
        return ("Book Id: " + getBookID() + ", "
                + "Title: " + getBookTitle() + ", "
                + "ISBN: " + getISBN() + ", "
                + "Author: " + getAuthor() + ", "
                + "Pages: " + getPages() + ", "
                + "Date of Issue: " + getDate()+ ", "
                + "Borrower: " + getBName());
               // + "Genre: " + getGenre());
    }

    public int compareTo(Book o) 
    {
        if (getBookID() < o.getBookID()) 
        {
            return -1;
        } 
        else 
            if (getBookID() == o.getBookID()) 
            {
                if (getBookTitle().compareTo(o.getBookTitle()) < 0) 
                {
                    return -1;
                } 
                else 
                    if (getBookTitle().compareTo(o.getBookTitle()) == 0) 
                    {
                        return 0;
                    } 
                    else 
                         {
                            return -1;
                         }
            }       
            else 
                 {
                    return 1;
                 }
    }
}
