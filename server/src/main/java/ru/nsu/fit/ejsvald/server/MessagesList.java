package ru.nsu.fit.ejsvald.server;

import ru.nsu.fit.ejsvald.server.data.MessageInfo;

import java.util.ArrayList;
import java.util.List;

public class MessagesList {
    List<String> messages;
    public MessagesList() {
        messages = new ArrayList<>();
    }
    public void addMessage(String name, String message) {
        messages.add(name + ": " + message);
    }

    public void addInfo(String info) {
        messages.add(info);
    }

    public MessageInfo getFrom(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < messages.size(); i++) {
            sb.append(messages.get(i));
            sb.append(System.lineSeparator());
        }
        return new MessageInfo(messages.size(), sb.toString());
    }


}
