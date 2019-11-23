package com.intelligencebank.stepDefinitions.resources.data;

public class EndTime {
    private long time;

    public EndTime(long endTime) {
        setTime(endTime);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
