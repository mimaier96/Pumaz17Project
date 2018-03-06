package de.dpma.projekt.utils4Code;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;


public class DateUtil {


    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** Date formatter */
    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    
    public static String format(Date date) {
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String dateText = dateFormat.format(date);
     
    return dateText;
    }
    
   /* 
    	public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

   */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

   
    public static boolean validDate(String dateString) {
        // Parse String
        return DateUtil.parse(dateString) != null;
    }
    
    public static Date formatDate(String dateString) throws ParseException {
    DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    Date date = format.parse(dateString);
    
    return date;
    }
        
}

