package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * FutureResult
 *
 * @author yunN
 * @createTime 2021年01月22日 14:22
 * @description 作为实时结果立即响应调用者，真正的结果出来以后 再回调客户端 给一个真正的结果
 */
public class FutureResult implements Result {

    private Result result;

    private boolean ready = false;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    /**
     * 如果真正的结果还未返回[会先返回一个响应？]，会进行等待，等到线程执行任务完成以后，才会返回真正的结果
     * @return /
     */
    @Override
    public synchronized Object getResultValue() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}
