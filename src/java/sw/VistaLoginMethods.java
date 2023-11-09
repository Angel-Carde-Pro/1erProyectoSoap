package sw;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Transaccion;
import modelo.Usuario;

/**
 *
 * @author angel
 */
@WebService(serviceName = "VistaLoginMethods")
public class VistaLoginMethods {

    private ArrayList<Usuario> arrayusuario = new ArrayList<>();

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "registro")
    public boolean registrar(@WebParam(name = "usuario") Usuario usuario) {

        return arrayusuario.add(usuario);

    }

    @WebMethod(operationName = "iniciosesion")
    public Usuario login(@WebParam(name = "usuario") Usuario usuario) {
        Usuario user = new Usuario();

        for (int i = 0; i < arrayusuario.size(); i++) {

            if (arrayusuario.get(i).getUser_name().equals(usuario.getUser_name()) && arrayusuario.get(i).getUser_password().equals(usuario.getUser_password())) {

                user = arrayusuario.get(i);
                break;
            }

        }

        return user;
    }

    @WebMethod(operationName = "deposito")
    public Transaccion depositar(@WebParam(name = "cantidad") Transaccion transaccion) {
        Transaccion deposito = new Transaccion();
        for (int i = 0; i < arrayusuario.size(); i++) {

            if (arrayusuario.get(i).getUser_name().equals(transaccion.getUser_name())) {

                deposito.setEstado(true);
                arrayusuario.get(i).setTotal(arrayusuario.get(i).getTotal() + transaccion.getTotal());
                deposito.setTotal(arrayusuario.get(i).getTotal());
                deposito.setUser_name(arrayusuario.get(i).getUser_name());
                break;
            }

        }
        return deposito;
    }

    @WebMethod(operationName = "retiro")
    public Transaccion retirar(@WebParam(name = "cantidad") Transaccion transaccion) {
        Transaccion retiro = new Transaccion();
        for (int i = 0; i < arrayusuario.size(); i++) {

            if (arrayusuario.get(i).getUser_name().equals(transaccion.getUser_name())) {

                if (arrayusuario.get(i).getTotal() > transaccion.getTotal()) {
                    retiro.setEstado(true);
                    arrayusuario.get(i).setTotal(arrayusuario.get(i).getTotal() - transaccion.getTotal());
                    retiro.setTotal(arrayusuario.get(i).getTotal());
                    retiro.setUser_name(arrayusuario.get(i).getUser_name());
                    break;
                } else {
                    retiro.setEstado(false);
                    retiro.setTotal(arrayusuario.get(i).getTotal());
                    retiro.setUser_name(transaccion.getUser_name());
                }
            }

        }
        return retiro;
    }
}
