package designpattern.factory.abstractfactory.video;

import designpattern.factory.abstractfactory.clan.Video;

public class JavaVideo extends Video {
    public void produce() {
        System.out.println("录制Java课程视频！");
    }
}