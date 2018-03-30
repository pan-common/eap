
package com.taiji.eap.biz.dmsctest.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.common.base.BaseModel;
public class Dmsctest extends BaseModel{
    private Long testId;//测试主键
    private String testName;//测试名称
    private String test1;//测试1
    private String test2;//测试2
    private String test3;//测试3
    private String test4;//测试4

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }


    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }


    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }


    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }


    public String getTest4() {
        return test4;
    }

    public void setTest4(String test4) {
        this.test4 = test4;
    }


}
