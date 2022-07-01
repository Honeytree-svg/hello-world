package date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : sz
 * @Description :
 * @date : 2022-06-28 16:32
 **/
public class Local {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusMinutes(30);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
