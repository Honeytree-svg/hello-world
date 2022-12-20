package serialization;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpMethod;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-25 09:59
 **/
public class Json {
    public static void main(String[] args) {

        try {
            Json json = new Json();
            json.process();
        } catch (Exception e) {
            System.out.println("执行失败");
            return;
        } finally {
            System.out.println("执行结束");
        }
    }

    public String process(){

        try{
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭连接");
            return "1";
        }
    }
}
