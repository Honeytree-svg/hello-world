package exception;

/**
 * @author : sz
 * @Description : 测试try-catch
 * @date : 2022-06-17 12:15
 **/
public class Test {

    public static void main(String[] args) {

        try {
            int i = 1/0;
        }catch (Exception e){
            e.getMessage();
        }

        System.out.println(1);
    }
}
