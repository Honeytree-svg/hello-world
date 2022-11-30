package thread.caffeine;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.NamedThreadFactory;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : sz
 * @Description :
 * @date : 2022-10-08 14:40
 **/
public class Main {

    public static void main(String[] args) {

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,
                10000L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                new NamedThreadFactory("sync-task", true));

        JSONObject jsonObject = new JSONObject();
        List<DsfsjData> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            DsfsjData dsfsjData = new DsfsjData();
            for (int j = 0; j < 10; j++) {

                dsfsjData.getList().add(new DsfsjItemData());
            }
            list.add(dsfsjData);
        }
        long start = System.currentTimeMillis();
        jsonObject.put("dsfsjData",list);
        List<DsfsjData> dsfsjData = jsonObject.getJSONArray("dsfsjData").toJavaList(DsfsjData.class);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        Integer count = dsfsjData.size();
        // 线程限制条数  100条数据上传一次
        Integer threadSize = 100;

        Integer threadNum = (count % threadSize == 0) ? count/threadSize : count/threadSize +1;
        for (int i = 0; i < threadNum; i++) {

            List<DsfsjData> cutList = new ArrayList<>();
            if (i == threadNum -1){
                cutList = dsfsjData.subList(threadSize * i, count);
            }else {
                cutList = dsfsjData.subList(threadSize * i, threadSize * (i + 1)-1);
            }

            final List<DsfsjData> listStr = cutList;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (null != listStr && listStr.size() > 0) {
                        System.out.println(Thread.currentThread().getName() +":开始");
                        try {
                            Thread.sleep(10 * 1000l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() +":结束");
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }

        try {
            threadPoolExecutor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
