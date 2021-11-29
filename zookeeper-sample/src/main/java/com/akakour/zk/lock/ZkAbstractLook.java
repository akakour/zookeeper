package com.akakour.zk.lock;

public abstract class ZkAbstractLook implements Lock {

    protected abstract boolean tryLock();

    protected abstract void waitForLock();

    @Override
    public boolean lock() {
        return false;
    }

    @Override
    public boolean unlock() {
        return false;
    }
}
