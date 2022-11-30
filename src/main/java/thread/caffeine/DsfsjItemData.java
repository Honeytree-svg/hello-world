package thread.caffeine;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import net.Response;

import java.util.*;

/**
 * @Author 马培淞
 * @Description 第三方数据详细信息
 * @Date 2021/6/19 14:18
 */
@Data
public class DsfsjItemData {
    private Long id = 123l;
    private String collectionMode="222";
    private String businessId="222";
    private String remark="222";
    private String indexType="222";
    private String dataSource="222";
    private List data= new ArrayList<>();


}
