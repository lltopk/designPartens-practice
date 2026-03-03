package org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2;


import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.handler.AbstractHandler;
import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.handler.userhandler.VerifyAccountHandler;
import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.handler.userhandler.VerifyPermissionHanlder;
import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.handler.userhandler.VerifyRoleHanlder;
import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.model.LoginUser;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 17:58
 */
public class LoginUserChainFactory extends ChainFactory<LoginUser,Boolean> {
    public LoginUserChainFactory() {

    }


    @Override
    public Boolean assembleHandler(LoginUser loginUser) {
        AbstractHandler accountHandler = new VerifyAccountHandler();
        AbstractHandler roleHanlder = new VerifyRoleHanlder();
        AbstractHandler permissionHanlder = new VerifyPermissionHanlder();
        accountHandler.setNextHandler(roleHanlder);
        roleHanlder.setNextHandler(permissionHanlder);
        super.firstHandler = accountHandler;
        super.t = loginUser;
        return true;
    }


}
