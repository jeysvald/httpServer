package ru.nsu.fit.ejsvald.server;

public class UsersDB {
    public boolean isLoginExist(String login) {
        //TODO: проверка что пользователь с таким логином уже существует
        return true;
    }

    public boolean authentication(String login, String password) {
        //TODO: вход по логину и паролю
        return true;
    }

    public boolean signUp(String login, String password) {
        //TODO: регистрация по логину и паролю
        return true;
    }

    public boolean changeLogin(String login, String newLogin) {
        //TODO: изменение логина
        return true;
    }

    public boolean changePassword(String login, String newPassword) {
        //TODO: изменение пароля
        return true;
    }
}
