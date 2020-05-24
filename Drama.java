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
public class Drama extends Book {

    int fine;

    public Drama(String BookID, String ISBN, String BookTitle, String Author, String Datestr, String Pages, String BName) {
        super(BookTitle, Integer.parseInt(BookID.replaceAll("\\s+", "")), ISBN, Author, Integer.parseInt(Pages.replaceAll("\\s+", "")), Datestr, BName);
    }
    
    public Drama(String[] bookTxtLineData) {
        super(bookTxtLineData[0], Integer.parseInt(bookTxtLineData[1].replaceAll("\\s+", "")), bookTxtLineData[2], bookTxtLineData[3], Integer.parseInt(bookTxtLineData[4].replaceAll("\\s+", "")), bookTxtLineData[5], bookTxtLineData[6]);
    }

    public int getFine() 
    {
        if (days <= 3) 
        {
            fine = 0;
        } 
        else 
            if (days > 3 && days <= 8) 
            {
                fine = (days-3)*7;
            } 
            else 
                if (days > 8 && days <= 16) 
                {
                    int initialfine = (days-3)*7;
                    int addedfine = (days-8)*12;
                    fine = initialfine + addedfine;
                }
                else 
                    if (days > 16) 
                    {
                        int initialfine = (16-3)*7;
                        int addedfine = (16-8)*12;
                        fine = initialfine + addedfine;
                    }
        return fine;
    }
}
