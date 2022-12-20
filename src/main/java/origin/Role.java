package origin;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-11 10:33
 **/
public class Role {

    public static int sum = 0;
    private static int num = 0;

    private String name;
    public String age;


    public static void addSum(){
        sum++;
    }

    private static void addNum(){
        num++;
    }

    private void addAge(int age){

        this.age = "1";
    }

    public void Name(String age){

        this.name = age;
    }

    public Role(){
        name = "";
        age = "0";
    }

    public Role(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
