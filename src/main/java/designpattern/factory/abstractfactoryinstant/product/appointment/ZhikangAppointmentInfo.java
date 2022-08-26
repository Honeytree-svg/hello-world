package designpattern.factory.abstractfactoryinstant.product.appointment;

import designpattern.factory.abstractfactoryinstant.clan.AppointmentInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 10:06
 **/
public class ZhikangAppointmentInfo implements AppointmentInfo {
    @Override
    public AppointmentInfo produce() {
        return new ZhikangAppointmentInfo();
    }
}
