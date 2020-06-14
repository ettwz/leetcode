package com.mine.leetcode.cn.no1300;

public class FakeMain {
    public void fakeMain() {
        int[] arr = {60864,25176,27249,21296,20204};
        int target = 56803;
        
        Solution solution = new Solution();
        int res = solution.findBestValue(arr,target);
        System.out.println(res);
    }
}
