package com.demo;

/**
 * @author zhangxinhe
 * @date 2018/5/4 14:05
 */
public class PCData {
    private final int intData;

    public PCData(int d){
        intData = d;
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "data=" + intData +
                '}';
    }
}

