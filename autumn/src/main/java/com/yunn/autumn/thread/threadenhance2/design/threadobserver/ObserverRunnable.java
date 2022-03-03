package com.yunn.autumn.thread.threadenhance2.design.threadobserver;

/**
 * ObserverRunnable
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description:
 */
public abstract class ObserverRunnable implements Runnable {

    final protected MyLifeCycleListener listener;

    public ObserverRunnable(final MyLifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent event) {
        listener.onEvent(event);
    }

    /**
     * 线程状态
     */
    public enum RunnableState {
        /**
         * 运行态
         */
        RUNNING,
        /**
         * 错误结束
         */
        ERROR,
        /**
         * 正常结束
         */
        DONE;
    }

    /**
     * 线程事件
     */
    public static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }

}
