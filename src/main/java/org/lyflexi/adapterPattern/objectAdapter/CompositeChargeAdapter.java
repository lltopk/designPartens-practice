package org.lyflexi.adapterPattern.objectAdapter;

import org.lyflexi.adapterPattern.adaptee.OldPowerAdapter;
import org.lyflexi.adapterPattern.adaptee.UsbSource;
import org.lyflexi.adapterPattern.adaptee.VgaSource;
import org.lyflexi.adapterPattern.target.IChargeTarget;

/**
 * 对象适配器 - 综合充电适配器
 * 
 * 适配器模式的另一种核心实现方式:
 * 1. 组合被适配者对象
 * 2. 实现目标接口
 * 3. 在实现方法中调用被适配者的方法
 * 
 * 优点:
 * - 可以适配多个被适配者
 * - 可以动态组合不同的适配器
 * - 被适配者类可以是final的,因为不继承
 * - 更灵活,可以在运行时切换被适配者
 * 
 * 缺点:
 * - 需要创建被适配者实例
 * 
 * 突出的适配器特点:
 * - 组合关系: 适配器组合被适配者对象
 * - 多接口适配: 可以同时适配USB、VGA、老式电源等多种接口
 * - 灵活性: 可以根据需求组合不同的被适配者
 * - 解耦: 客户端不依赖具体的实现类
 */
public class CompositeChargeAdapter implements IChargeTarget {
    
    private UsbSource usbSource;
    private VgaSource vgaSource;
    private OldPowerAdapter oldPowerAdapter;
    
    /**
     * 构造方法,可以传入不同的被适配者
     * 展示对象适配器的灵活性:可以组合多种接口
     * 
     * @param useType 使用类型: "usb", "vga", "old" 或 "all"
     */
    public CompositeChargeAdapter(String useType) {
        switch (useType) {
            case "usb":
                this.usbSource = new UsbSource();
                break;
            case "vga":
                this.vgaSource = new VgaSource();
                break;
            case "old":
                this.oldPowerAdapter = new OldPowerAdapter();
                break;
            case "all":
                // 组合多个被适配者,展示对象适配器的多接口适配能力
                this.usbSource = new UsbSource();
                this.vgaSource = new VgaSource();
                this.oldPowerAdapter = new OldPowerAdapter();
                break;
            default:
                throw new IllegalArgumentException("未知的适配类型: " + useType);
        }
    }
    
    /**
     * 实现目标接口的charge方法
     * 根据传入的useType决定使用哪个被适配者
     * 
     * @param useType 使用类型: "usb", "vga", "old" 或 "all"
     */
    public void charge(String useType) {
        System.out.println("【对象适配器】正在使用" + useType.toUpperCase() + "充电适配器...");
        
        switch (useType) {
            case "usb":
                if (usbSource != null) {
                    usbSource.output5V();
                    System.out.println("USB 5V电压已转换为标准充电协议");
                }
                break;
                
            case "vga":
                if (vgaSource != null) {
                    vgaSource.output12V();
                    System.out.println("VGA 12V电压已转换为标准充电协议");
                }
                break;
                
            case "old":
                if (oldPowerAdapter != null) {
                    oldPowerAdapter.output19V();
                    System.out.println("老式电源 19V电压已转换为标准充电协议");
                }
                break;
                
            case "all":
                if (usbSource != null) {
                    System.out.println(">>> 开始使用USB接口...");
                    usbSource.output5V();
                    System.out.println("USB 5V电压已转换为标准充电协议\n");
                }
                if (vgaSource != null) {
                    System.out.println(">>> 开始使用VGA接口...");
                    vgaSource.output12V();
                    System.out.println("VGA 12V电压已转换为标准充电协议\n");
                }
                if (oldPowerAdapter != null) {
                    System.out.println(">>> 开始使用老式电源接口...");
                    oldPowerAdapter.output19V();
                    System.out.println("老式电源 19V电压已转换为标准充电协议");
                }
                break;
                
            default:
                throw new IllegalArgumentException("未知的适配类型: " + useType);
        }
    }
    
    @Override
    public void charge() {
        // 默认使用USB接口
        charge("usb");
    }
}