package org.lyflexi.delegatePattern.withFunctionPass;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:18
 */
public class TestDelegateOrientedFunction {

    public static void main(String[] args) {
        new Boss().startWork("部署项目",new Manager());
    }
}
