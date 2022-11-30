package thread.caffeine;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 马培淞
 * @Description 第三方数据详细信息
 * @Date 2021/6/19 14:18
 */
@Data
public class DsfsjItemDataVo {
    private Long id = 123l;
    private String collectionMode="222";
    private String businessId="222";
    private String remark="222";
    private String indexType="222";
    private String dataSource="222";
    private List data= new ArrayList<>();
    private List data2= new ArrayList<>();


    public static void main(String[] args) {

        List<String> list = JSONArray.parseArray("[\"吕美燕\",\"七星\"]", String.class);
        list.stream().forEach(System.out::println);
    }
}
