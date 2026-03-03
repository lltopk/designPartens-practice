package org.lyflexi.chainPattern.chainOfSpringCallBack;

import org.apache.commons.lang3.StringUtils;

public class VerifyPermissionFilter implements IFilter{
    @Override
    public void filter(ProtocolsContext context, DefaultChainFactory chain) {
        LoginUser loginUser = context.getLoginUser();
        if (!"admin".equals(loginUser.getPermission())){
            System.out.println("暂无权限");
            return;
        }
        System.out.println("3. 权限校验通过");
        chain.filter(context);
    }
}
