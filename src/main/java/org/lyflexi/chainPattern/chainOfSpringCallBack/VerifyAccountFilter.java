package org.lyflexi.chainPattern.chainOfSpringCallBack;

import org.apache.commons.lang3.StringUtils;

public class VerifyAccountFilter implements IFilter{
    @Override
    public void filter(ProtocolsContext context, DefaultChainFactory chain) {
        LoginUser loginUser = context.getLoginUser();
        if (StringUtils.isBlank(loginUser.getLoginName())){
            System.out.println("用户名不能为空");
            return;
        }
        if (StringUtils.isBlank(loginUser.getPassword())){
            System.out.println("密码不能为空");
            return;
        }
        if (!loginUser.getPassword().equals("123456")){
            System.out.println("密码不正确");
            return;
        }
        System.out.println("1. 账号密码校验通过");
        chain.filter(context);
    }
}
