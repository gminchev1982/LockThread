package com.company.lock;

import java.util.concurrent.ConcurrentHashMap;

public class ReaderData implements Runnable {
    private LockData<DataKeyModel, DataValueModel> data;

    public ReaderData(LockData<DataKeyModel, DataValueModel> data) {
        this.data = data;
    }

    @Override
    public void run() {


        try {

            ConcurrentHashMap<DataKeyModel, DataValueModel> all = data.listAll();
            all.entrySet().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++");
            Thread.sleep(100);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
