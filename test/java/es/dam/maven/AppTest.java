package es.joseluisgs.dam.DamZum.test.java.es.dam.maven;



import es.joseluisgs.dam.DamZum.main.java.es.dam.BusinessLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * float transferir(float saldo, float cantidad, String destino)
     * X: (saldo-cantidad) -- OK
     * -1: 0.50<= cantidad <= saldo -- OK
     * -2: cantidad>saldo --> cantidad <= saldo -- OK
     * -3: destino[8] == 6 && ddestino.length == 9 -- OK
     */
    @Test
    public void transferirTest() {
        // Caso correcto
        float saldo = 500.00f;
        float cantidad = 300.00f;
        String telf = "666666666";

        assertEquals(200, BusinessLogic.transferir(saldo, cantidad, telf));

        // Caso Cantidad en intervalo
        saldo = 500.00f;
        float c1 = 0.50f;
        float c2 = 0.50f;
        telf = "666666666";
        assertEquals(499.5, BusinessLogic.transferir(saldo, c1, telf));
        assertEquals(499.5, BusinessLogic.transferir(saldo, c2, telf));

        //Caso Cantidad mayor que saldo
        saldo = 500.00f;
        float c3 = 0.50f;
        telf = "666666666";
        assertEquals(499.5, BusinessLogic.transferir(saldo, c3, telf));

        // Caso Cantidad mayor que saldo
        saldo = 500.00f;
        cantidad = 300.00f;
        telf = "766666666";
        assertEquals(499.5, BusinessLogic.transferir(saldo, c3, telf));
    }

   /** @Test
    public void getNuevoSaldoTest() {
        float saldo = 500.00f;
        float cantidad = 300.00f;

        assertEquals(200, BusinessLogic.cantidadCorrecta(saldo, cantidad));
        assertNotEquals(100, BusinessLogic.cantidadCorrecta(saldo, cantidad));

    }*/

    @Test
    void cantidadIntervaloTest() {
        float cantidadTrue = 100f;
        float cantidadC1 = 0.51f;
        float cantidadC2 = 0.50f;
        float cantidadC3 = 0.49f;
        float cantidadC4 = 499.99f;
        float cantidadC5 = 500.00f;
        float cantidadC6 = 500.01f;

        Exception e = Assertions.assertThrows(Exception.class, () -> {
            BusinessLogic.cantidadIntervalo(cantidadC3);
        });
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            BusinessLogic.cantidadIntervalo(cantidadC6);
        });

        Assertions.assertAll(
                () -> assertTrue(BusinessLogic.cantidadIntervalo(cantidadTrue)),
                () -> assertTrue(BusinessLogic.cantidadIntervalo(cantidadC1)),
                () -> assertTrue(BusinessLogic.cantidadIntervalo(cantidadC2)),
                () -> assertTrue(BusinessLogic.cantidadIntervalo(cantidadC4)),
                () -> assertTrue(BusinessLogic.cantidadIntervalo(cantidadC5)),
                () -> assertEquals(ex.getMessage(),"El intervalo debe ser de 0,50 - 500,00"),
                () -> assertEquals(e.getMessage(),"El intervalo debe ser de 0,50 - 500,00")
        );

    }

    @Test
    public void cantidadCorrectaTest() {
        float saldo = 500.00f;

        Assertions.assertAll(
                () -> assertTrue(BusinessLogic.cantidadCorrecta(499.5f, saldo))
                //() -> assertTrue(BusinessLogic.cantidadCorrecta(499.5f, saldo)),
                //() -> assertFalse(BusinessLogic.cantidadCorrecta(499.5f, saldo))
        );
    }



    @Test
    public void telefonoCorrectoTest() {
        String c1 = "666666666";
        //String c2 = "766666666";
        //String c3 = "866666666";
        //String c4 = "966666666";
        //String c5 = "6666A6666";



        Assertions.assertAll(
                () -> assertTrue(BusinessLogic.telefonoCorrecto(c1))
                //() -> assertFalse(BusinessLogic.telefonoCorrecto(c2)),
                //() -> assertFalse(BusinessLogic.telefonoCorrecto(c3)),
                //() -> assertFalse(BusinessLogic.telefonoCorrecto(c4))
                //() -> assertFalse(BusinessLogic.telefonoCorrecto(c5))
        );
    }
}
