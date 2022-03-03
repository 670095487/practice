package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchEx2
 *
 * @author: yunN
 * @createTime: 2021/01/30 15:19:23
 * @description: 将一个大任务拆分成若干个子任务 交给不同的线程组去做,并且需要观察，每个线程组
 * 完成的情况，以及子任务完成的情况
 */
public class CountDownLatchEx2 {

    private static final CountDownLatch latch = new CountDownLatch(1);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final ExecutorService pools = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};
        for (Event event : events) {
            List<Table> tables = capture(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(),event);
            for (Table table : tables) {
                TaskBatch taskBatch = new TaskBatch(taskGroup,2);
                TrustSourceColumns columnsRunnable = new TrustSourceColumns(table, taskBatch);
                TrustSourceRecordCount recordCountRunnable = new TrustSourceRecordCount(table, taskBatch);
                pools.submit(columnsRunnable);
                pools.submit(recordCountRunnable);
            }
        }
    }

    interface Watcher {
        void done(Table table);
    }

    static class TaskBatch implements Watcher {

        private final TaskGroup taskGroup;

        private final CountDownLatch countDownLatch;

        public TaskBatch(TaskGroup taskGroup, int szie) {
            this.taskGroup = taskGroup;
            this.countDownLatch = new CountDownLatch(szie);
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("table:" + table.toString() + "had done ...");
            }
            taskGroup.done(table);
        }
    }


    static class TaskGroup implements Watcher {

        private final CountDownLatch countDownLatch;

        private final Event event;

        public TaskGroup(int szie,Event event) {
            this.event = event;
            this.countDownLatch = new CountDownLatch(szie);
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("=====All missions had done ... in event :" + event.id);
            }
        }
    }


    static class Table {
        String tableName;
        long sourceRecordCount = 10;
        long targetCount;
        String sourceColumnSchema = "columnSchema";
        String targetColumnSchema = "";

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", sourceRecordCount=" + sourceRecordCount +
                    ", targetCount=" + targetCount +
                    ", sourceColumnSchema='" + sourceColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }

        public Table(String tableName, long sourceRecordCount) {
            this.tableName = tableName;
            this.sourceRecordCount = sourceRecordCount;
        }
    }

    private static List<Table> capture(Event event) {
        ArrayList<Table> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Table("table-" + event.id + "_" + + +i, i * 1000));
        }
        return list;
    }

    static class Event {
        private final int id;

        public Event(int id) {
            this.id = id;
        }
    }

    static class TrustSourceRecordCount implements Runnable {
        private final Table table;
        private final TaskBatch taskBatch;


        public TrustSourceRecordCount(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(RANDOM.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetCount = table.sourceRecordCount;
            taskBatch.done(table);
        }
    }


    static class TrustSourceColumns implements Runnable {
        private final Table table;
        private final TaskBatch taskBatch;

        public TrustSourceColumns(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(RANDOM.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.targetColumnSchema = table.sourceColumnSchema;
            taskBatch.done(table);
        }
    }
}
