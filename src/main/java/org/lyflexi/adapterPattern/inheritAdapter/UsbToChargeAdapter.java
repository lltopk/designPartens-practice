package org.lyflexi.adapterPattern.inheritAdapter;

import org.lyflexi.adapterPattern.adaptee.UsbSource;
import org.lyflexi.adapterPattern.target.IChargeTarget;

/**
 * 类适配器 - USB充电适配器
 * 
 * 适配器模式的核心实现方式之一:
 * 1. 继承被适配者类
 * 2. 实现目标接口
 * 3. 在实现方法中调用被适配者的方法
 * 
 * 优点:
 * - 直接继承被适配者,可以访问被适配者的所有方法
 * - 无需创建被适配者实例
 * 
 * 缺点:
 * - Java不支持多重继承,如果被适配者已经继承了其他类,则无法使用类适配器
 * - 被适配者类的实现细节暴露在适配器中
 * 
 * 突出的适配器特点:
 * - 继承关系: 适配器继承被适配者
 * - 接口转换: 将USB源转换为统一充电接口
 * - 复用性: 复用UsbSource的现有功能
 */
public class UsbToChargeAdapter extends UsbSource implements IChargeTarget {
    
    /**
     * 实现目标接口的charge方法
     * 内部调用被适配者的output5V方法
     * 完成接口转换
     */
    @Override
    public void charge() {
        System.out.println("【类适配器】正在使用USB充电适配器...");
        super.output5V();
        System.out.println("USB 5V电压已转换为标准充电协议");
    }
}