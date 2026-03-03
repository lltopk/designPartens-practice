package org.lyflexi.adapterPattern.adaptee;

/**
 * 被适配者 - VGA源
 * 现有系统中的类,输出12V电压
 * 使用VGA接口,无法直接提供统一充电接口
 */
public class VgaSource {
    /**
     * VGA输出12V
     */
    public void output12V() {
        System.out.println("VGA接口输出12V电压");
    }
}