package by.epam.callcenter.main;

import by.epam.callcenter.entity.CallCenter;
import by.epam.callcenter.entity.Client;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    public static final int NUM_CLIENTS = 20;

    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        CallCenter callCenter = CallCenter.getInstance();

        for (int i = 0; i < NUM_CLIENTS; i++) {
            new Client(callCenter, i+1).start();
        }
    }
}
