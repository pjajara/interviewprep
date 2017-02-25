package edu.sjsu.java.singleton;

public class DeviceDriver {

    private static volatile DeviceDriver instance = new DeviceDriver();

    private DeviceDriver() {
        //Only one instance at a time
    }

    public static synchronized DeviceDriver getInstance() {
        /*if (instance == null) {
            instance = new DeviceDriver();
			return instance;
		}*/
        return instance;
    }

}
