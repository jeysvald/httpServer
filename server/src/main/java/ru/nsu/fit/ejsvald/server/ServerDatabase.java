package ru.nsu.fit.ejsvald.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerDatabase {

    private ArrayList<Long> PKI = new ArrayList<>();
    private Map<String, Integer> usersID = new HashMap<>(); //по логину можно получить ID
    private Map<String, String> regInf = new HashMap<>(); //pair(login, password)
    private int freeIDForChat = 0;

    public boolean isLoginExist(String login) {
        return usersID.containsKey(login);
    }

    public long getFreeIDForNewChat(){
        return freeIDForChat++;
    }

    public String signUp(String login, String password) {
        return regInf.containsKey(login) && (regInf.get(login).equals(password))? "good" : "wrong";
    }
}
