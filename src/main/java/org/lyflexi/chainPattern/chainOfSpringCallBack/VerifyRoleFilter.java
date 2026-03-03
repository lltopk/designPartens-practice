package org.lyflexi.chainPattern.chainOfSpringCallBack;

public class VerifyRoleFilter implements IFilter{
    @Override
    public void filter(ProtocolsContext context, DefaultChainFactory chain) {
        LoginUser loginUser = context.getLoginUser();
        if(!"admin".equals(loginUser.getRoleName())){
            System.out.println("角色信息有误");
            return;
        }
        System.out.println("2.角色信息校验通过");

        chain.filter(context);
    }
}
