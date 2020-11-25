package com.springboot.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "marco.redisson")
public class RedissonProperties {
    private String host = "localhost";
    private int port = 6379;
    private int timeOut;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
