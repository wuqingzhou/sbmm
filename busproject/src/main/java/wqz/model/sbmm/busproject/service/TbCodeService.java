package wqz.model.sbmm.busproject.service;

import wqz.model.sbmm.busproject.model.TbCode;

public interface TbCodeService extends BaseSinglePkTableService<TbCode> {

    TbCode getCKey();
}