package com.java.executors;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class EventLimiter
{
    private long mFiringRate;
    private long mScheduledTime;
    private ScheduledFuture<?> mTask;
    private CustomExecutorService mCustomExecutorService;
    private Runnable mRunnable;

    public EventLimiter(long firingRate, Runnable runnable)
    {
        mFiringRate = firingRate;
        mRunnable = runnable;
        mCustomExecutorService = new CustomExecutorService();
    }

    public synchronized void schedule()
    {
        long currentTime = new Date().getTime();

        if (mScheduledTime < currentTime && previousTaskDone())
        {
            mTask = scheduleOnExecutor(mRunnable);
            mScheduledTime = currentTime + mFiringRate;
        }
    }

    private ScheduledFuture<?> scheduleOnExecutor(Runnable runnable)
    {
        return mCustomExecutorService.schedule(runnable, mFiringRate, TimeUnit.MILLISECONDS);
    }

    private boolean previousTaskDone()
    {
        return mTask == null || mTask.isDone();
    }

    public void cancel()
    {
        if (mTask != null)
        {
            mTask.cancel(true);
        }
    }
}
