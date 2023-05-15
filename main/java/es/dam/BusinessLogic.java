package es.joseluisgs.dam.DamZum.main.java.es.dam;

/**
 * @Author: Andrés Fernández Pereira
 */
public class BusinessLogic {

    public static boolean cantidadIntervalo(float cantidad) {
        if (!((0.50f <= cantidad) && (cantidad <= 500.00f))) {
            throw new CantidadIntervaloIncorrectoException("El intervalo debe ser de 0,50 - 500,00");
        }else return true;
    }



    public static boolean cantidadCorrecta(float cantidad, float saldo) {
        if (!(cantidad <= saldo)){
            throw new CantidadIncorrectaException("La cantidad transferida debe ser menor o igual que el saldo");
        }else return true;
    }

    public static boolean telefonoCorrecto(String telefono) {
        if (telefono.length() != 9) {
            throw new TamanhoCaracteresTelefonoException("El telefono debe tener 9 caracteres");
        }

        /**if(telefono.length()!= 9)
            return false;
        if(telefono.charAt(0)!= '6')
            return false;

        for(char c: telefono.toCharArray()) {
            if(!Character.isDigit(c))
                return false;
        }

        return true;
    }*/
        return true;
    }

        public static float transferir(float saldo, float cantidad, String telf) {
            if (cantidadIntervalo(cantidad)) {
                if (cantidadCorrecta(cantidad, saldo)) {
                    if (telefonoCorrecto(telf)) {
                        return saldo - cantidad;
                    }
                }
            }
            return 0.0F;
        }

    }


