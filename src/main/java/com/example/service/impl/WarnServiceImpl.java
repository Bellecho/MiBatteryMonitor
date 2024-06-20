package com.example.service.impl;

import com.example.dao.WarnRuleDAO;
import com.example.entity.WarnInfo;
import com.example.entity.WarnQuery;
import com.example.service.WarnService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WarnServiceImpl implements WarnService {
//    @Autowired
//    private WarnRuleDAO warnDao;
//
//    @Override
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Cacheable(value = "warnInfoCache", key = "'vid:'+#query.vid+':wid'+#query.wid+':sub'+#query.sub+':type'+#query.type")
//    public WarnInfo getWarnInfo(WarnQuery query) {
//        return warnDao.getWarnInfo(query);    }
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Cacheable(value = "warnInfoCache", key = "#query.vid + '_' + #query.wid + '_' + #query.sub + '_' + #query.type")
    public WarnInfo getWarnInfo(WarnQuery query) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            WarnRuleDAO mapper = session.getMapper(WarnRuleDAO.class);
            return mapper.getWarnInfo(query);
        }
    }
}
