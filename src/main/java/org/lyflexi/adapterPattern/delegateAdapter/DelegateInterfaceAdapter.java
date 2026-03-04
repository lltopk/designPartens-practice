package org.lyflexi.adapterPattern.delegateAdapter;

import org.lyflexi.adapterPattern.delegateAdapter.adapteeInterfece.IAdapteeInterface;
import org.lyflexi.adapterPattern.target.IChargeTarget;

public class DelegateInterfaceAdapter implements IChargeTarget {
    private IAdapteeInterface delegateAdaptee;
    public DelegateInterfaceAdapter(IAdapteeInterface delegateAdaptee) {
        this.delegateAdaptee = delegateAdaptee;
    }

    /**
     * 适配新框架接口
     * @return
     */
    @Override
    public void charge() {
        System.out.println(delegateAdaptee.out());
    }
}
