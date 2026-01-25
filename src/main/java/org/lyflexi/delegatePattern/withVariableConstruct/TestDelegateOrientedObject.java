package org.lyflexi.delegatePattern.withVariableConstruct;

import org.lyflexi.delegatePattern.withFunctionPass.Boss;
import org.lyflexi.delegatePattern.withFunctionPass.Manager;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:18
 */
public class TestDelegateOrientedObject {

    public static void main(String[] args) {
        BossDelegatingManager bossDelegatingManager = new BossDelegatingManager(new Manager());
        bossDelegatingManager.startWork("部署项目");
    }
}
