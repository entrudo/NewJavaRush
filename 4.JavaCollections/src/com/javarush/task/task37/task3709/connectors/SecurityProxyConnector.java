package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker securityChecker = new SecurityCheckerImpl();
    private SimpleConnector simpleConnector;
    private String resourceString;

    public SecurityProxyConnector(String str) {
        this.simpleConnector = new SimpleConnector(str);
        resourceString = str;
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            System.out.println("Successfully connected to " + resourceString);
            simpleConnector.connect();
        } else {
            System.out.println("Message");
        }
    }
}
