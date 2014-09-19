package com.fpopovic.broadcaster;

/**
 * This implementation is responsibele to inform components of sharing charts events
 * Created by fp on 29.8.2014.
 */
public interface Broadcaster {

    public void sendMessage(String group, String message);

    public abstract void addListener(BroadcasterListener listener);

    public abstract void removeListener(BroadcasterListener listener);

}
