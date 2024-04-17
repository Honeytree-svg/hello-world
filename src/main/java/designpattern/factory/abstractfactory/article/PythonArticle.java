package designpattern.factory.abstractfactory.article;

import designpattern.factory.abstractfactory.clan.Article;

public class PythonArticle extends Article {
    public void produce() {
        System.out.println("编写Python课程手记！");
    }
}