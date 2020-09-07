package test;

public class Stu {
    private String userName;
    private String password;

    public Stu(final String userName, final String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
}
