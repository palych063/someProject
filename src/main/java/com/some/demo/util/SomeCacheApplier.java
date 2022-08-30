package com.some.demo.util;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

@Service
public class SomeCacheApplier<K, V> {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Map<K, V> map = new ConcurrentHashMap<>();

    public Future<V> compute(K k, Function<K, V> f) {
        return executor.submit(() -> {
            var result = map.get(k);
            if (result == null) {
                result = f.apply(k);
                map.put(k, result);
            }
            return result;
        });
    }
}