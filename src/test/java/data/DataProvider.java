package data;

public class DataProvider {
    public LoginData getLogin1() {
        return login1;
    }

    public LoginData getBadLogin() {
        return badLogin;
    }

    LoginData login1 = new LoginData("rftester","rftester");
    LoginData badLogin = new LoginData("nobody@madeup.com", "wrongpass");
}
