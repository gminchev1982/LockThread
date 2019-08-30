package com.company.lock;

public class DataValueModel {
    Integer value;

    public DataValueModel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataValueModel{" +
                "value=" + value +
                '}';
    }
}
