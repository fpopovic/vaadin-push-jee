package com.fpopovic.broadcaster;

/**
 * Created by fp on 29.8.2014.
 */
public interface BroadcasterListener {

    /**
     * Responsible for processing messages
     * @param group
     * @param message
     */
    public void receiveMessage(String group, String message);
}
