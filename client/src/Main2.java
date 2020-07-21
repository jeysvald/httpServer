import data.MessageInfo;

import java.io.Console;
import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Network server = new Network("http://localhost:8080");
//        Scanner in = new Scanner(System.in);
        int number = 0;
        try {
            while (true) {
                MessageInfo info = server.getMessage(number);
                if (number != info.getNumber()) {
                    System.out.print(info.getMessages());
                    number = info.getNumber();
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
