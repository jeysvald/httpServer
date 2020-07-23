import data.MessageInfo;

public class Listener implements Runnable {
    private String login;
    private String password;

    public Listener(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void run() {
        Network server = new Network("http://localhost:8080");
        int number = 0;
        while (true) {
            MessageInfo info = server.getMessage(number, login, password);
            if (number != info.getNumber()) {
                System.out.print(info.getMessages());
                number = info.getNumber();
            }
        }
    }
}
