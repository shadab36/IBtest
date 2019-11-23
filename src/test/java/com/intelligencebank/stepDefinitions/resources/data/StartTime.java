package com.intelligencebank.stepDefinitions.resources.data;

public class StartTime {
    private long time;

    public StartTime(long startTime) {
        setTime(startTime);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
