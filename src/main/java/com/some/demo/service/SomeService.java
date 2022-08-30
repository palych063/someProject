package com.some.demo.service;

import com.some.demo.model.Product;
import com.some.demo.model.SomeRequest;
import com.some.demo.model.StorageProduct;
import com.some.demo.util.SomeCacheApplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public final class SomeService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SomeService.class);
    @Autowired
    SomeCacheApplier someCacheApplier;

    public void register(SomeRequest someRequest) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("someRequest starting to register");
        }

        Function<String, Boolean> func = (id -> {
            boolean result = doSomething(id);

            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("completed for {}, result {}", id, result);
            }
            return result;
        });

        someCacheApplier.compute(someRequest.getSomeId(), func);
    }

    /**
     * Just for test
     */
    private boolean doSomething(final String id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
