package modelo;

/**
 *
 * @author angel
 */
public class Usuario {

    private int total;
    private String user_name;
    private String user_password;

    public Usuario() {
    }

    public Usuario(int total, String user_name, String user_password) {
        this.total = total;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}