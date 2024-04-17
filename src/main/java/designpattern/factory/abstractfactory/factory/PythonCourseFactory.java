package designpattern.factory.abstractfactory.factory;

import designpattern.factory.abstractfactory.CourseFactory;
import designpattern.factory.abstractfactory.article.PythonArticle;
import designpattern.factory.abstractfactory.clan.Article;
import designpattern.factory.abstractfactory.clan.Video;
import designpattern.factory.abstractfactory.video.PythonVideo;

public class PythonCourseFactory implements CourseFactory {
    public Video getVideo() {
        return new PythonVideo();
    }

    public Article getArticle() {
        return new PythonArticle();
    }
}