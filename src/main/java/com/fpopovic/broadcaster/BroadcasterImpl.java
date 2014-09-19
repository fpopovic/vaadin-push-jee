package com.fpopovic.broadcaster;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fp on 29.8.2014.
 */
@Singleton
public class BroadcasterImpl implements Broadcaster,Serializable{

    private static Logger log = LogManager.getLogger(BroadcasterImpl.class);
    private ExecutorService executorService;
    private final List<BroadcasterListener> listeners = new ArrayList<>();

    public BroadcasterImpl() {
        super();
        executorService = Executors.newFixedThreadPool(10);
    }

    @Override
    public void sendMessage(final String group, final String message) {
        for (final BroadcasterListener listener : listeners) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    listener.receiveMessage(group, message);
                }
            });

        }
    }

    @Override
    public void addListener(BroadcasterListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(BroadcasterListener listener) {
        this.listeners.remove(listener);
    }

}
