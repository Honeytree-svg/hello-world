package thread.caffeine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author 马培淞
 * @Description 更改第三方数据格式
 * @Date 2021-8-8 15:08:22
 */
@Data
public class DsfsjData {
    private String IDType = "1";
    private String IDNO ="2";
    private String name ="2";
    // 采集来源
    private String collectSource="sfds";
    // 采集人名称
    private String nameOfCollector="sfds";
    // 采集人来源
    private String IDNOOfCollector="sfds";
    // 采集机构编号
    private String orgCodeOfCollector="sfds";
    // 采集机构名称
    private String orgNameOfCollector="sfds";
    private String timestamp="sfds";
    // 数据源标识
    private String dataSource="sfds";

    private List<DsfsjItemData> list = new ArrayList<>();

    //pp016新增字段
    //来源系统
    private String collectSourceSystem="sfds";
    //来源业务
    private String collectSourceBusiness="sfds";
    //来源主键id
    private String businessId="sfds";

    @JsonProperty("IDNO")
    public String getIDNO() {
        return IDNO;
    }

    @JsonProperty("IDType")
    public String getIDType() {
        return IDType;
    }

    @JsonProperty("IDNOOfCollector")
    public String getIDNOOfCollector() {
        return IDNOOfCollector;
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("111", "222", "333");

        final ArrayBlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(16);
        final RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 16, 10000, TimeUnit.MILLISECONDS,
                WORK_QUEUE, HANDLER);

        CountDownLatch count = new CountDownLatch(list.size());

        list.forEach(item ->{

            executorService.execute(()->{

                try {
                    Thread.sleep(3000);
                    System.out.println(item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
            });
        });
//
//        try {
//            count.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("执行完毕");
    }

}
