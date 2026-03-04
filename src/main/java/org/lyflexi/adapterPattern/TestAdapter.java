package org.lyflexi.adapterPattern;

import org.lyflexi.adapterPattern.delegateAdapter.DelegateInterfaceAdapter;
import org.lyflexi.adapterPattern.delegateAdapter.adapteeInterfece.AdapteeInterfaceImpl1;
import org.lyflexi.adapterPattern.delegateAdapter.adapteeInterfece.AdapteeInterfaceImpl2;
import org.lyflexi.adapterPattern.inheritAdapter.UsbToChargeAdapter;
import org.lyflexi.adapterPattern.compositeAdapter.CompositeChargeAdapter;
import org.lyflexi.adapterPattern.target.IChargeTarget;

/**
 * @Author: ly
 * @Date: 2024/3/3 22:12
 */
public class TestAdapter {
    public static void main(String[] args) {
        System.out.println("========== 适配器模式测试 ==========\n");
        
        // 测试类适配器
        testClassAdapter();
        System.out.println();
        
        // 测试对象适配器
        testObjectAdapter();
        System.out.println();
        
        // 测试对象适配器的多接口适配能力
        testObjectAdapterMulti();

        // 测试委托适配器- 组合接口
        testDelegateAdapter();
    }
    
    /**
     * 测试类适配器
     * 类适配器特点: 继承被适配者,实现目标接口
     */
    private static void testClassAdapter() {
        System.out.println("【测试类适配器】");
        
        // 创建类适配器对象
        IChargeTarget usbAdapter = new UsbToChargeAdapter();
        
        // 通过统一接口使用
        System.out.println("使用统一接口charge()方法:");
        usbAdapter.charge();
    }
    
    /**
     * 测试对象适配器
     * 对象适配器特点: 组合被适配者,实现目标接口
     */
    private static void testObjectAdapter() {
        System.out.println("【测试对象适配器】");
        
        // 创建对象适配器对象(使用USB)
        CompositeChargeAdapter usbAdapter = new CompositeChargeAdapter("usb");
        usbAdapter.charge();
        usbAdapter.charge("usb");

    }
    
    /**
     * 测试对象适配器的多接口适配能力
     * 展示对象适配器可以组合多个被适配者
     */
    private static void testObjectAdapterMulti() {
        System.out.println("【测试对象适配器 - 多接口适配】");
        
        // 创建对象适配器,组合多种接口
        CompositeChargeAdapter multiAdapter = new CompositeChargeAdapter("all");
        

        multiAdapter.charge("usb");
        multiAdapter.charge("vga");
        multiAdapter.charge("old");
    }

    private static void testDelegateAdapter() {
        System.out.println("【测试委托适配器- 接口组合】");

        DelegateInterfaceAdapter delegateInterfaceAdapter = new DelegateInterfaceAdapter(new AdapteeInterfaceImpl1());
        delegateInterfaceAdapter.charge();

        delegateInterfaceAdapter = new DelegateInterfaceAdapter(new AdapteeInterfaceImpl2());
        delegateInterfaceAdapter.charge();
    }
}