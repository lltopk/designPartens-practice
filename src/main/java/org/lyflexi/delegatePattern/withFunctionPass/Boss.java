package org.lyflexi.delegatePattern.withFunctionPass;

/**
 * @Author: ly
 * @Date: 2024/3/13 17:18
 */
public class Boss {
    public void startWork(String taskCommand,Manager manager){
        manager.work(taskCommand);
    }
}
