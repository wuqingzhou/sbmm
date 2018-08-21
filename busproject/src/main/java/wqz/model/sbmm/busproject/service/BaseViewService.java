package wqz.model.sbmm.busproject.service;

import org.apache.ibatis.annotations.Param;

public interface BaseViewService<T> {
    /*================================= ConditionMapper ===============================*/

    /**
     * 根据Condition条件更新实体record包含的全部属性，null值会被更新
     */
    int updateByCondition(@Param("record") T record, @Param("example") Object condition);

    /**
     * 根据Condition条件更新实体record包含的不是null的属性值
     */
    int updateByConditionSelective(@Param("record") T record, @Param("example") Object condition);

    /**
     * 根据Condition条件删除数据
     */
    int deleteByCondition(Object condition);
}
