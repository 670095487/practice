package com.yunn.autumn.thread.threadenhance2.design.unkowndesign;

import java.util.LinkedList;

/**
 * RequestQueue
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description: 请求队列，客户端的请求先放请求队列中
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    /**
     * 服务端弹栈
     *
     * @return .
     */
    public Request getRequest() {
        synchronized (queue) {
            while (queue.size() <= 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            //每次取队列第一个元素
            return queue.removeFirst();
        }
    }

    /**
     * 客户端压栈
     *
     * @param request .
     */
    public void putRequest(Request request) {
        synchronized (queue) {
            //任务添加至队列末尾
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
