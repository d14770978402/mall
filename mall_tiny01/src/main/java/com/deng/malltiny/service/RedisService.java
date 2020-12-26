package com.deng.malltiny.service;

public interface RedisService {
    void set(String key,String value);
    String get(String key);
    void remove(String key);
    boolean expire(String key,long expire);
    Long increment(String key,long delta);
}
