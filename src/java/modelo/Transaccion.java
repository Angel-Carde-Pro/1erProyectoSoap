package modelo;

/**
 *
 * @author angel
 */
public class Transaccion {

    private int total;
    private boolean estado;
    private String user_name;

    public Transaccion() {
    }

    public Transaccion(int total, boolean estado, String user_name) {
        this.total = total;
        this.estado = estado;
        this.user_name = user_name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String username) {
        this.user_name = username;
    }
}
