package com.company.lock;

import java.util.concurrent.ConcurrentHashMap;

public class ReaderData implements Runnable {
    private LockData<Integer, Integer> data;

    public ReaderData(LockData<Integer, Integer> data) {
        this.data = data;
    }

    @Override
    public void run() {


        try {

            ConcurrentHashMap<Integer, Integer> all = data.listAll();
            all.entrySet().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++");
            Thread.sleep(100);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
