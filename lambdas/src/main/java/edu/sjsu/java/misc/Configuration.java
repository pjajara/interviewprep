package edu.sjsu.java.misc;

public final class Configuration {

    private String ip;
    private Integer bufferSize;
    private String hostName;

    public Configuration(String ip, Integer bs, String hn) {
        this.ip = ip;
        this.bufferSize = bs;
        this.hostName = hn;
    }

    public Configuration() {
    }

    public String getIp() {
        return ip;
    }

    public Integer getBufferSize() {
        return bufferSize;
    }

    public String getHostName() {
        return hostName;
    }


}
