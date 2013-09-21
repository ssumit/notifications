package open.java.executors;

import java.util.concurrent.*;

public class CustomExecutorService
{
    private static ScheduledExecutorService mNotificationService;

    public void setExecutorService()
    {
        mNotificationService = Executors.newSingleThreadScheduledExecutor();
    }

    public void setExecutorService(ScheduledExecutorService notificationService)
    {
        mNotificationService = notificationService;
    }

    public void setExecutorService(ThreadFactory threadFactory, int NoOfThreads)
    {
        if(NoOfThreads == 1)
        {
            mNotificationService = Executors.newSingleThreadScheduledExecutor(threadFactory);
        }
        else
        {
            mNotificationService = Executors.newScheduledThreadPool(NoOfThreads, threadFactory);
        }
    }

    public ScheduledFuture<?> scheduleNow(Runnable runnable)
    {
        return schedule(runnable,0,TimeUnit.SECONDS);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long time, TimeUnit timeUnit)
    {
        CustomFutureTask task = new CustomFutureTask(runnable);
        return mNotificationService.schedule(task, time, timeUnit);
    }

}