package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LocalDate2 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Date date = new Date();
        System.out.println(localDateTime);
        System.out.println(date);
    }
}
