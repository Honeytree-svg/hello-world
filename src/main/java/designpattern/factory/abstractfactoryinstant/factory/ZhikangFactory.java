package designpattern.factory.abstractfactoryinstant.factory;

import designpattern.factory.abstractfactoryinstant.InstitutionFactory;
import designpattern.factory.abstractfactoryinstant.clan.AppointmentInfo;
import designpattern.factory.abstractfactoryinstant.clan.DepartmentInfo;
import designpattern.factory.abstractfactoryinstant.clan.ScheduleInfo;
import designpattern.factory.abstractfactoryinstant.product.appointment.ZhikangAppointmentInfo;
import designpattern.factory.abstractfactoryinstant.product.department.ZhikangDepartment;
import designpattern.factory.abstractfactoryinstant.product.schedule.ZhikangScheduleInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 10:03
 **/
public class ZhikangFactory implements InstitutionFactory {

    @Override
    public AppointmentInfo getAppointmentInfo() {
        return new ZhikangAppointmentInfo();
    }

    @Override
    public DepartmentInfo getDepartmentInfo() {
        return new ZhikangDepartment();
    }

    @Override
    public ScheduleInfo getScheduleInfo() {
        return new ZhikangScheduleInfo();
    }
}
