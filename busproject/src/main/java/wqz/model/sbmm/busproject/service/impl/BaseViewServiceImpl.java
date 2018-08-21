package wqz.model.sbmm.busproject.service.impl;

import wqz.model.sbmm.busproject.service.BaseViewService;

public abstract class BaseViewServiceImpl<T> implements BaseViewService<T> {
    /**
     * 根据Condition条件更新实体record包含的全部属性，null值会被更新
     *
     * @param record
     * @param condition
     */
    @Override
    public int updateByCondition(T record, Object condition) {
        return 0;
    }

    /**
     * 根据Condition条件更新实体record包含的不是null的属性值
     *
     * @param record
     * @param condition
     */
    @Override
    public int updateByConditionSelective(T record, Object condition) {
        return 0;
    }

    /**
     * 根据Condition条件删除数据
     *
     * @param condition
     */
    @Override
    public int deleteByCondition(Object condition) {
        return 0;
    }
}
