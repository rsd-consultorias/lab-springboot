package br.com.rsdconsultoria.labspringboot;

public class UsuarioLogado {
    private static final ThreadLocal<String> userHolder = new ThreadLocal<String>();

    public static void logIn(String user) {
        userHolder.set(user);
    }

    public static String get() {
        return userHolder.get();
    }

    public static void logOut() {
        userHolder.remove();
    }
}
