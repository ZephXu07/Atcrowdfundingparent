/**
 * @author: zephxu
 * @email: zephaniaxu0701@gmail.com
 * PACKAGE: com.zephxu.crowdfunding.manager.service.impl
 * PROJECT: Atcrowdfundingparent
 * Date: 2019-11-05 19:49
 * @module: 类所属模块
 * @describe:
 * @version: v1.0
 */
package com.zephxu.crowdfunding.manager.service.impl;

import com.zephxu.crowdfunding.manager.dao.TestDao;
import com.zephxu.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public void insert() {
        Map map = new HashMap();
        map.put("name", "xzf");
        testDao.insert(map);
    }
}
