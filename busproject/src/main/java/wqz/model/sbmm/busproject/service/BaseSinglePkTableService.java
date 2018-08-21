package wqz.model.sbmm.busproject.service;

import java.util.List;

public interface BaseSinglePkTableService<T> extends BaseCompositeOrNullPkTableService<T> {

    /*=============================== IdsMapper ==================================*/

    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     * 注：通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常
     *
     * @author wuqingzhou
     */
    List<T> selectByIds(String ids);

    /**
     * 批量删除数据。根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @author wuqingzhou
     */
    int deleteByIds(String ids);
}
