package data;

public class MessageInfo {
    private String messages;
    private int number;
    public MessageInfo(){};
    public MessageInfo(int number, String messages) {
        this.messages = messages;
        this.number = number;
    }
    public void setMessages(String messages) {
        this.messages=messages;
    }


    public void setNumber(int number) {
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public String getMessages() {
        return messages;
    }
}
