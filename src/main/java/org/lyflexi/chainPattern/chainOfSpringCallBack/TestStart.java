package org.lyflexi.chainPattern.chainOfSpringCallBack;

import java.util.ArrayList;
import java.util.List;

public class TestStart {
    public static void main(String[] args) {
        List<IFilter> arrayList = new ArrayList(){{
           add(new VerifyAccountFilter());
           add(new VerifyRoleFilter());
           add(new VerifyPermissionFilter());
        }};
        DefaultChainFactory defaultChainFactory = new DefaultChainFactory(arrayList);
        ProtocolsContext protocolsContext = new ProtocolsContext();
        LoginUser loginUser = new LoginUser();
        loginUser.setLoginName("孤狼1号");
        loginUser.setPassword("123456");
        loginUser.setRoleName("admin");
        loginUser.setPermission("admin");
        protocolsContext.setLoginUser(loginUser);

        defaultChainFactory.filter(protocolsContext);
    }
}
