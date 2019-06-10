package me.lhz.service.impl;


import me.lhz.bo.TTest;
import me.lhz.dao.jdbctemplate.TTestJdbcTemplateDao;
import me.lhz.dao.rdbmsoperstion.TTestRdbmsOperationSqlQuery;
import me.lhz.dao.rdbmsoperstion.TTestRdbmsOperationSqlUpdate;
import me.lhz.service.ITTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTestServiceImpl implements ITTestService {

    @Autowired
    private TTestJdbcTemplateDao tTestDao;

    @Autowired
    private TTestRdbmsOperationSqlQuery tTestRdbmsOperationSqlQuery;

    @Autowired
    private TTestRdbmsOperationSqlUpdate  tTestRdbmsOperationSqlUpdate;

    @Override
    public List<TTest> list() {
        return tTestDao.list();
    }
    @Override
    public List<TTest> listByRdbmsOperation() {
        return tTestRdbmsOperationSqlQuery.list();
    }
    @Override
    public void add(String name) {
        tTestDao.add(name);
    }
    @Override
    public void addByRdbmsOperation(String name) {
        tTestRdbmsOperationSqlUpdate.add(name);
    }



    @Override
    public void addAndRollbackSuccess(String name) {
        tTestRdbmsOperationSqlUpdate.add(name);
        Integer.parseInt(name);
    }

    @Override
    public void xAddAndRollbackSuccess(String name) {
        tTestRdbmsOperationSqlUpdate.add(name);
        Integer.parseInt(name);
    }

}
