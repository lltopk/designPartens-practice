package org.lyflexi.delegatePattern.withVariableConstruct;

import org.lyflexi.delegatePattern.withFunctionPass.Manager;

public class BossDelegatingManager {
    Manager manager;

    public BossDelegatingManager(Manager manager){
        this.manager = manager;
    }

    public void startWork(String taskCommand){
        manager.work(taskCommand);
    }
}
