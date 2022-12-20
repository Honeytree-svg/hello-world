package serialization;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-09-05 16:39
 **/
public class Copy {

    public static void main(String[] args) {

        List<Customer> customers = BeanUtil.copyToList(null, Customer.class);


        Customer2 customer2 = new Customer2("23",12);
        customer2.setId("2123");
        Customer customer = BeanUtil.copyProperties(customer2, Customer.class);
        System.out.println(customer);
        DateTime date = DateUtil.date();
        System.out.println(date);
    }
}
