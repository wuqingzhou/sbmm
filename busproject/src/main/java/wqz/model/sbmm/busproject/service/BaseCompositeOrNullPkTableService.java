package wqz.model.sbmm.busproject.service;

/**
 * 适用于复合主键的表
 *
 * @param <T>
 * @author wuqingzhou
 */
public interface BaseCompositeOrNullPkTableService<T> extends BaseViewService<T> {
    /*=============================== BaseInsertMapper ==================================*/

    /**
     * 插入数据。保存一个实体，null的属性也会保存，不会使用数据库默认值
     */
    public int insert(T record);

    /**
     * 插入数据。保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    public int insertSelective(T record);

    /*=============================== BaseUpdateMapper ==================================*/

    /**
     * 更新数据。根据主键更新实体全部字段，null值会被更新
     *
     * @author wuqingzhou
     */
    int updateByPrimaryKey(T record);

    /**
     * 更新数据。根据主键更新属性不为null的值
     *
     * @author wuqingzhou
     */
    int updateByPrimaryKeySelective(T record);
    /*=============================== BaseDeleteMapper ==================================*/

    /**
     * 删除数据。根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @author wuqingzhou
     */
    int delete(T record);

    /**
     * 删除数据。根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @author wuqingzhou
     */
    int deleteByPrimaryKey(Object key);
}
