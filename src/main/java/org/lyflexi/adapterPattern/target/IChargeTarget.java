package org.lyflexi.adapterPattern.target;

/**
 * 目标接口 - 充电目标
 * 定义客户端期望的统一充电接口
 * 这是适配器模式中的"目标(Target)"角色
 */
public interface IChargeTarget {
    /**
     * 充电方法
     */
    void charge();
}