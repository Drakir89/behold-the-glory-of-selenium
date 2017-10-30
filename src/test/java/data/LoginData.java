package data;

public class LoginData {
    private String user;
    private String pass;

    public LoginData(String givenUser, String givenPass){
        this.user = givenUser;
        this.pass = givenPass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
