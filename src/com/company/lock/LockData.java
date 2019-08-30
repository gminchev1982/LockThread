package com.company.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockData<K, E> {

    private ConcurrentHashMap<K, E> list = new ConcurrentHashMap<>();
    private ReadWriteLock rwLock;

    public LockData() {
        rwLock = new ReentrantReadWriteLock();
    }

    public void add(K key, E element) {
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();

        try {
            list.put(key, element);
        } finally {
            writeLock.unlock();
        }
    }


    public ConcurrentHashMap<K, E> listAll() {
        Lock readLock = rwLock.readLock();
        readLock.lock();

        try {
            return list;
        } finally {
            readLock.unlock();
        }
    }

}
