package main.java.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;

public class Test {

    public static void main(String[] args) {

        DateTime dateTime = DateUtil.nextWeek();
        DateTime dateTime1 = DateUtil.parseDate("2022-05-05T00:00:00+08:00");
        Week week = dateTime1.dayOfWeekEnum();

        System.out.println(dateTime.toString("MM.dd"));
    }
}
