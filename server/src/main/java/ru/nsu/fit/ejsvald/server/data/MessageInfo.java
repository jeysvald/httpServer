package ru.nsu.fit.ejsvald.server.data;

public class MessageInfo {
    private String messages;
    private int number;

    public MessageInfo(int number, String messages) {
        this.messages = messages;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getMessages() {
        return messages;
    }
}
