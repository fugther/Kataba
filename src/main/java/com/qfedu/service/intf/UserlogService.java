package com.qfedu.service.intf;

import com.qfedu.entity.UserLog;
import com.qfedu.vo.R;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/20 17:05
 * @Description:
 */
public interface UserlogService {
    //新增
    R save(UserLog log);
    //查询
}
