package org.lyflexi.chainPattern.chainOfSpringCallBack;

/**
 * 由框架回调具体的过滤器类filter.filter(context, chain)
 */
public interface IFilter {
    /**
     * 用户拿到的是DefaultChainFactory chain, 用户需要手动执行chain.filter();
     * @param context
     * @param chain
     */
    void filter(ProtocolsContext context, DefaultChainFactory chain);
}
