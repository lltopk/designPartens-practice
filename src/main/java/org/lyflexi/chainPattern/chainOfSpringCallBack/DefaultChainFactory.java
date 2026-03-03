package org.lyflexi.chainPattern.chainOfSpringCallBack;

import java.util.List;

public class DefaultChainFactory {
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<IFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<IFilter> filters) {
        this.filters = filters;
    }

    private Integer index;

    private List<IFilter> filters;

    public DefaultChainFactory(List<IFilter> filters) {
        this.filters = filters;
        this.index = 0;
    }

    public DefaultChainFactory(DefaultChainFactory parent, int index) {
        this.filters = parent.getFilters();
        this.index = index;
    }

    public void filter(ProtocolsContext context) {
        if(index >= filters.size()) {
            return;
        }
        IFilter filter = this.filters.get(index);
        DefaultChainFactory chain = new DefaultChainFactory(this, ++index);
        //回调用户过滤器类
        // eg 回调filter0, 但是给filter0传入的是chain1, 由于filter0中末尾用户执行的是chain1.filter(context)表示继续传播链给filter1
        // eg 回调filter1, 但是给filter1传入的是chain2, 由于filter1中末尾用户执行的是chain2.filter(context)表示继续传播链给filter2
        filter.filter(context, chain);
    }




}
