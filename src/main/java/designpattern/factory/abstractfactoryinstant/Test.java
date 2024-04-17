package designpattern.factory.abstractfactoryinstant;

import designpattern.factory.abstractfactoryinstant.clan.AppointmentInfo;
import designpattern.factory.abstractfactoryinstant.factory.KingdeeFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 10:19
 **/
public class Test {
    public static void main(String[] args) {

        InstitutionFactory kingdeeFactory = new KingdeeFactory();
        AppointmentInfo appointmentInfo = kingdeeFactory.getAppointmentInfo();
        System.out.println(appointmentInfo.getClass().getName());

    }
}
