package org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2;


import org.lyflexi.chainPattern.chainOfGenericBuilderLinkedListV2.handler.*;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 17:58
 */
public abstract class ChainFactory<T,R> {
    AbstractHandler<T,R> firstHandler;
    T t;
    public ChainFactory () {

    }

    public R executeHandler () {
        return firstHandler.doHandler(t);
    }

    public abstract R assembleHandler (T t) ;

}
