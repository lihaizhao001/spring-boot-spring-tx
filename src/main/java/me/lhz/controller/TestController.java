package me.lhz.controller;

import me.lhz.bo.TTest;
import me.lhz.service.ITTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITTestService itTestService;

    @GetMapping("/list")
    public List<TTest> list(){
        return itTestService.list();
    }
    @GetMapping("/list/rdbms")
    public List<TTest> listByRdbmsOperation(){
        return itTestService.listByRdbmsOperation();
    }
    @GetMapping("/add")
    public List<TTest> add(String name){
        itTestService.add(name);
        return itTestService.list();
    }
    @GetMapping("/add/rdbms")
    public List<TTest> addByRdbms(String name){
        itTestService.add(name);
        return itTestService.list();
    }


    //------------------------test rollback success
    @GetMapping("/add/rollback/success")
    public List<TTest> addAndRollbackSuccess(String name){
        try {
            itTestService.addAndRollbackSuccess(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itTestService.list();
    }

    //------------------------test rollback failure
    @GetMapping("/add/rollback/failure")
    public List<TTest> xAddAndRollbackSuccess(String name){
        try {
            itTestService.xAddAndRollbackSuccess(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itTestService.list();
    }

}
