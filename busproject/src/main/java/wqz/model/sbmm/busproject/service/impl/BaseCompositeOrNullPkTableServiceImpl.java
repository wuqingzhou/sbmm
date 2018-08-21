package wqz.model.sbmm.busproject.service.impl;

import wqz.model.sbmm.busproject.service.BaseCompositeOrNullPkTableService;

public abstract class BaseCompositeOrNullPkTableServiceImpl<T> extends BaseViewServiceImpl<T> implements BaseCompositeOrNullPkTableService<T> {
    /**
     * 插入数据。保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     */
    @Override
    public int insert(T record) {
        return 0;
    }

    /**
     * 插入数据。保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     */
    @Override
    public int insertSelective(T record) {
        return 0;
    }

    /**
     * 更新数据。根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @author wuqingzhou
     */
    @Override
    public int updateByPrimaryKey(T record) {
        return 0;
    }

    /**
     * 更新数据。根据主键更新属性不为null的值
     *
     * @param record
     * @author wuqingzhou
     */
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }

    /**
     * 删除数据。根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record
     * @author wuqingzhou
     */
    @Override
    public int delete(T record) {
        return 0;
    }

    /**
     * 删除数据。根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key
     * @author wuqingzhou
     */
    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }
}
