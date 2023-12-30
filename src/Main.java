

public class Main {

    private static final String REGEX = "^[a-zA-Z0-9_]+$";

    public static void main(String[] args) {
        try {
            check("anton2258", "officeman123", "officeman123");
            System.out.println("Проверка логина и пароля пройдена успешно.");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        }
    }


    private static void check(String login, String password, String confirmPassword) {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException(" В логине имеются недопустимые символы. ");
        }
        if (login.length() > 20) {
            throw new WrongLoginException(" Длина логина превышает 20 символов. ");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException(" В пароле имеются недопустимые символы. ");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException(" Длина пароля превышает 20 символов. ");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException(" Пароли не совпали. ");
        }
    }
}











