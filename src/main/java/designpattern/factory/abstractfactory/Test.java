package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.clan.Article;
import designpattern.factory.abstractfactory.clan.Video;
import designpattern.factory.abstractfactory.factory.JavaCourseFactory;

public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}