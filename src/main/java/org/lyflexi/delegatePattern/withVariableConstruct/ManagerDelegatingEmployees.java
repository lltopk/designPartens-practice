package org.lyflexi.delegatePattern.withVariableConstruct;

import org.lyflexi.delegatePattern.common.EmployeeA;
import org.lyflexi.delegatePattern.common.EmployeeB;
import org.lyflexi.delegatePattern.common.IEmployee;

import java.util.HashMap;
import java.util.Map;

public class ManagerDelegatingEmployees implements IEmployee{
    private Map<String, IEmployee> workTargetMap = new HashMap<>();

    public ManagerDelegatingEmployees() {
        workTargetMap.put("部署项目",new EmployeeA());
        workTargetMap.put("修复BUG",new EmployeeB());
    }

    @Override
    public void work(String taskCommand) {
        IEmployee employee = workTargetMap.get(taskCommand);
        if(null == employee){
            System.out.println("未找到可以执行任务的员工");
            return;
        }
        employee.work(taskCommand);
    }
}
