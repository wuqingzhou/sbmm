package wqz.model.sbmm.busproject.service.impl;

import wqz.model.sbmm.busproject.service.BaseSinglePkTableService;

import java.util.List;

public abstract class BaseSinglePkTableServiceImpl<T> extends BaseCompositeOrNullPkTableServiceImpl<T> implements BaseSinglePkTableService<T> {
    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     * 注：通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常
     *
     * @param ids
     * @author wuqingzhou
     */
    @Override
    public List<T> selectByIds(String ids) {
        return null;
    }

    /**
     * 批量删除数据。根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param ids
     * @author wuqingzhou
     */
    @Override
    public int deleteByIds(String ids) {
        return 0;
    }
}
