package main.java.enums;

import java.util.stream.Stream;

public enum OrderStatusEnum {

    WEI_QU_HAO("0", "未取号"),
    YI_QU_HAO("1", "已取号"),
    YI_TUI_FEI("2", "已退费(已取号)"),
    YI_JIU_ZHEN("3", "已就诊"),
    WEI_FU_FEI_QU_XIAO("4", "未付费取消"),
    YI_FU_FEI_YI_QU_XIAO("5", "已付费已取消"),
    YUN_XU_YU_YUE_BAO_DAO("6", "允许预约报道"),
    YI_SHUANG_YUE("7", "已爽约");

    private String orderCode;

    private String orderMsg;

    OrderStatusEnum(String orderCode, String orderMsg) {
        this.orderCode = orderCode;
        this.orderMsg = orderMsg;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    public static OrderStatusEnum toOrderStatusEnum(String value) {
        return Stream.of(OrderStatusEnum.values())
                .filter(item -> item.orderCode == value)
                .findAny()
                .orElse(null);
    }
}
