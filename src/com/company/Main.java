package com.company;

import com.company.lock.LockData;
import com.company.lock.ReaderData;
import com.company.lock.WriterData;
import com.company.lock2.Data;
import com.company.lock2.Receiver;
import com.company.lock2.Sender;

public class Main {

    static final int READER_SIZE = 1;
    static final int WRITER_SIZE = 1000;

    public static void main(String[] args) {
        LockData();
    }

    static void LockData() {

        LockData<Integer, Integer> lockData = new LockData();
        for (int i = 0; i < WRITER_SIZE; i++) {
            Thread writeThread = new Thread(new WriterData(lockData));
            writeThread.start();
        }
        Thread readThread = new Thread(new ReaderData(lockData));
        readThread.start();
    }

    static void thData() throws InterruptedException {

        Data data = new Data();
        Sender senderData = new Sender(data);
        Thread sender = new Thread(senderData);
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
