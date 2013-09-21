package com.java.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CustomFutureTask extends FutureTask<Object>
{
    public CustomFutureTask(Runnable runnable)
    {
        super(runnable, null);
    }

    @Override
    protected void done()
    {
        try
        {
            if (!isCancelled())
            {
                get();
            }
        }
        catch (final ExecutionException e)
        {
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    throw new RuntimeException(e.getMessage(),e);
                }
            });
            thread.start();
        }
        catch (InterruptedException ignored)
        {
        }
    }
}
