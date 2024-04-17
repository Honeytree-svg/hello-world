package designpattern.factory.abstractfactory.article;

import designpattern.factory.abstractfactory.clan.Article;

public class JavaArticle extends Article {
    public void produce() {
        System.out.println("编写Java课程手记！");
    }
}