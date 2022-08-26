package designpattern.factory.abstractfactory.factory;

import designpattern.factory.abstractfactory.CourseFactory;
import designpattern.factory.abstractfactory.article.JavaArticle;
import designpattern.factory.abstractfactory.clan.Article;
import designpattern.factory.abstractfactory.clan.Video;
import designpattern.factory.abstractfactory.video.JavaVideo;

public class JavaCourseFactory implements CourseFactory {

    public Video getVideo() {
        return new JavaVideo();
    }

    public Article getArticle() {
        return new JavaArticle();
    }
}