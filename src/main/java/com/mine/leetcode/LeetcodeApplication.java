package com.mine.leetcode;

import com.mine.leetcode.cn.no1300.FakeMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeApplication {
    public static void main(String[] args) {
        
        SpringApplication.run(LeetcodeApplication.class, args);
        FakeMain fakeMain = new FakeMain();
        fakeMain.fakeMain();
        
    }
}
