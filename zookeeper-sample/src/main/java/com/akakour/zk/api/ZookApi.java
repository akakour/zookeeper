package com.akakour.zk.api;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookApi {
    public static final String connect = "192.168.11.101:2181";

    public static final CountDownLatch cdl = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper client = new ZooKeeper(connect, 5000, new WatchImpl(cdl));
        cdl.await();
        System.out.println(">>>>>>>>>>>>>>>>");
        System.out.println(client.exists("/", true).getCtime());
        System.out.println(">>>>>>>>>>>>>>>>");

        client.create("/pre", "demo".getBytes(), null, CreateMode.PERSISTENT);
        client.addAuthInfo(null, null);
        System.out.println(client.getData("/pre", false, new Stat()).toString());

    }
}
