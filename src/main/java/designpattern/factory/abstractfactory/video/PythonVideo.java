package designpattern.factory.abstractfactory.video;

import designpattern.factory.abstractfactory.clan.Video;

public class PythonVideo extends Video {
    public void produce() {
        System.out.println("录制Python课程视频！");
    }
}