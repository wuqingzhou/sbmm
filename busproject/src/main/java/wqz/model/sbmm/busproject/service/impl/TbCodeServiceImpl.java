package wqz.model.sbmm.busproject.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import wqz.model.sbmm.busproject.mapper.TbCodeMapper;
import wqz.model.sbmm.busproject.model.TbCode;
import wqz.model.sbmm.busproject.service.BaseSinglePkTableService;
import wqz.model.sbmm.busproject.service.TbCodeService;

import java.util.List;

@Service
public class TbCodeServiceImpl extends BaseSinglePkTableServiceImpl<TbCode> implements TbCodeService {
    @Autowired
    TbCodeMapper codeMapper;

    @Override
    public TbCode getCKey() {
        Condition condition = new Condition(TbCode.class);
        condition.and().andIsNull("value");
        List<TbCode> list  = codeMapper.selectByConditionAndRowBounds(condition, new RowBounds(0,1));
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
