package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.clan.Article;
import designpattern.factory.abstractfactory.clan.Video;

public interface CourseFactory {
    Video getVideo();
    Article getArticle();
}
