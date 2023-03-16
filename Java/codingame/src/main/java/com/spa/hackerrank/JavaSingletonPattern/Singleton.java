package com.spa.hackerrank.JavaSingletonPattern;

public final class Singleton {
    private static Singleton singleton;
    public String str;
    private Singleton(){

    }
    public static Singleton getSingleInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
