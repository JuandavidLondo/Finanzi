package com.example.finanzi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testCorreo(){
        MainActivity mainActivity = new MainActivity();
        String Correo = "juan@gmail.com";
        Boolean result = mainActivity.emailValido(Correo);
        Assertions.assertEquals(result,true);
    }
}
