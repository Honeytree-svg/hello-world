package yuhuo;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

class A {

    int i;
    char c;
    short aShort;
    long aLong;
    float aFloat;
    double aDouble;
    byte aByte;
    boolean aBoolean;


    public static void main(String[] args) {

        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }
}
