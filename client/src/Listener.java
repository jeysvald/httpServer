import data.MessageInfo;

public class Listener implements Runnable {
    @Override
    public void run() {
        Network server = new Network("http://localhost:8080");
        int number = 0;
        while (true) {
            MessageInfo info = server.getMessage(number);
            if (number != info.getNumber()) {
                System.out.print(info.getMessages());
                number = info.getNumber();
            }
        }
    }
}
