package org.lyflexi.adapterPattern.adaptee;

/**
 * 被适配者 - 老式电源适配器
 * 现有系统中的类,输出19V电压
 * 使用老式电源接口,无法直接提供统一充电接口
 */
public class OldPowerAdapter {
    /**
     * 老式电源输出19V
     */
    public void output19V() {
        System.out.println("老式电源接口输出19V电压");
    }
}