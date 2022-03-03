package com.yunn.autumn.thread.threadenhance2.design.produceconsumer;

import java.util.LinkedList;

/**
 * MessageQueue
 *
 * @author: yunN
 * @createTime: 2021/01/18
 * @description:
 */
public class MessageQueue {

    private final LinkedList<Message> queue;

    private final static int DEFAULT_MAX_LIMIT = 100;

    /**
     * 队列最大限制长度
     */
    private final int limit;

    /**
     * 如果调用者未给出队列最大限制长度，就使用默认的队列最大长度
     */
    public MessageQueue() {
        this(DEFAULT_MAX_LIMIT);
    }

    public MessageQueue(final int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }


    //-----------------------------------------------------getter-----------------------------------//

    /**
     * 返回队列的实时大小
     */
    public int getQueueSize() {
        synchronized (queue) {
            return queue.size();
        }
    }

    /**
     * 被final修饰，后续不会被改变，不需要加锁
     */
    public int getLimit() {
        return limit;
    }
//-----------------------------------------------------getter-----------------------------------//

    /**
     * 生产者调用此api,往消息队列中放入一条数据
     */
    public void put(final Message message) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() > limit) {
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    /**
     * 消费者调用此api,从消息队列中取一条数据
     */
    public Message take() throws InterruptedException{
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            //？
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

}


class TestConstructor {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(10);
        System.out.println(messageQueue.getLimit());
        System.out.println(messageQueue.getQueueSize());
    }
}