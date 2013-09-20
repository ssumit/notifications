package com.java.util;

public class Utils
{
    public String trimTickerTextByLength(String tickerText, int length)
    {
        if (tickerText.length() < length)
        {
            return tickerText;
        }
        else
        {
            return tickerText.substring(0, length) + "...";
        }
    }

    public String trimTickerText(String tickerText)
    {
        return trimTickerTextByLength(tickerText, 100);
    }
}
