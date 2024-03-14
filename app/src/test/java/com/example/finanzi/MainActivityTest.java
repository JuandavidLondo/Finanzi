package com.example.finanzi;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivityTest {
    @Test
    public void testCorreoValido() {
        String correo = "juan@gmail.com";
        Boolean result = emailValido(correo);
        assertEquals(true, result);
    }
    @Test
    public void testCorreoNoValido(){
        String correo = "juan";
        Boolean result = emailValido(correo);
        assertEquals(false,result);
    }
    @Test
    public void testCorreoVacio(){
        String correo = "";
        Boolean result = correo.isEmpty();
        assertEquals(true,result);
    }
    @Test
    public void testContraseñaVacio(){
        String contraseña = "";
        Boolean result = contraseña.isEmpty();
        assertEquals(true,result);
    }


    public boolean emailValido(String correo){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}