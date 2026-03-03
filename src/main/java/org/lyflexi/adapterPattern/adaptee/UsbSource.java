package org.lyflexi.adapterPattern.adaptee;

/**
 * 被适配者 - USB源
 * 现有系统中的类,输出5V电压
 * 使用USB接口,无法直接提供统一充电接口
 */
public class UsbSource {
    /**
     * USB输出5V
     */
    public void output5V() {
        System.out.println("USB接口输出5V电压");
    }
}