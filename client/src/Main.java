import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Network server = new Network("http://localhost:8080");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your login: ");
        String login = in.nextLine();
        String password = null;
        boolean hasSignIn = false;
        boolean isLoginExist = true; //TODO: проверка наличия логина
        if (!isLoginExist) {
            System.out.print("This login does not exist. Do you want to sign up? (y/n)");
            String answer = in.nextLine();
            if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
                //TODO: регистрация
            }
        } else {
            System.out.print("Enter your password to sign in: ");
            password = in.nextLine();
            hasSignIn = server.signIn(login,password);
        }
        while(!hasSignIn) {
            System.out.println("failed ");
            System.out.print("Enter your login: ");
            login = in.nextLine();
            System.out.print("Enter your password: ");
            password = in.nextLine();
            hasSignIn = server.signIn(login,password);
        }
        new Thread(new Listener(login, password)).start();
        while(true) {
            String message = in.nextLine();
            server.addMessage(login, password, message);
        }
    }
}
