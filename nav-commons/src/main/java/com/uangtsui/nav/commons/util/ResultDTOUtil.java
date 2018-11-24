package com.uangtsui.nav.commons.util;

import com.uangtsui.nav.commons.model.dto.ResultDTO;

public class ResultDTOUtil {

    public static ResultDTO success(Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(0);
        resultDTO.setMsg("成功");
        resultDTO.setData(object);
        return resultDTO;
    }
}
