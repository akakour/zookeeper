package com.akakour.zk.api;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

public class WatchImpl implements Watcher {
    CountDownLatch latch = null;

    public WatchImpl(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.None
                || watchedEvent.getState() == Event.KeeperState.SyncConnected
        ) {
            latch.countDown();
        }

        System.out.println(watchedEvent.getType() + " " + watchedEvent.getPath() + " " + watchedEvent.getState());
    }
}
