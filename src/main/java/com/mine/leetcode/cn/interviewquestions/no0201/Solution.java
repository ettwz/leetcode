package com.mine.leetcode.cn.interviewquestions.no0201;

import java.util.*;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(head.val);
        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            if (!hashSet.contains(next.val)) {
                hashSet.add(next.val);
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        current.next = null;
        return head;
    }
    
}
