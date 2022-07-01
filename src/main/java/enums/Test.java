package main.java.enums;

public class Test {

    public static void main(String[] args) {

        System.out.println(OrderStatusEnum.toOrderStatusEnum("3").getOrderMsg());
    }
}
