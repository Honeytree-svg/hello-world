package designpattern.factory.abstractfactoryinstant.product.schedule;

import designpattern.factory.abstractfactoryinstant.clan.ScheduleInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 10:05
 **/
public class ZhikangScheduleInfo implements ScheduleInfo {
    @Override
    public ScheduleInfo produce() {
        return new ZhikangScheduleInfo();
    }
}
