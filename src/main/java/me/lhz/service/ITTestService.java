package me.lhz.service;

import me.lhz.bo.TTest;

import java.util.List;

public interface ITTestService {
    List<TTest> list();
    List<TTest> listByRdbmsOperation();
    void add(String name);
    void addByRdbmsOperation(String name);

    void addAndRollbackSuccess(String name);

    void xAddAndRollbackSuccess(String name);
}