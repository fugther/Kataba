package com.qfedu.service.intf;

import com.qfedu.entity.User;
import com.qfedu.vo.R;

import java.util.List;

/**
 * @ProjectName: Kataba
 * @Author: GSL
 * @Time: 2020/10/19 17:37
 * @Description:
 */
public interface UserService {
    R<List<User>> all();
}
