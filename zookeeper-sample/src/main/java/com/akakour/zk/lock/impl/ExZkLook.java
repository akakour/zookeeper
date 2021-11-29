package com.akakour.zk.lock.impl;

import com.akakour.zk.lock.ZkAbstractLook;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

public class ExZkLook extends ZkAbstractLook {

    private static final String connect = "192.168.11.101:2181";
    public static final String LOCK = "/root/exlock";
    private ZkClient client;

    public ExZkLook() {
        this.client = new ZkClient(connect);
    }

    @Override
    protected boolean tryLock() {
        try{
            String sequential = client.createEphemeralSequential(LOCK, "");
        }catch(ZkException e){

        }
        return true;
    }

    @Override
    protected void waitForLock() {

    }
}
