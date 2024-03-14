package com.example.finanzi;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivityTest {
    @Test
    public void testnombreValido() {
        String nombre = "Juan";
        boolean result = verificarString(nombre);
        assertEquals(true, result);
    }
    @Test
    public void testnombreInValido() {
        String nombre = "(8";
        boolean result = verificarString(nombre);
        assertEquals(false, result);
    }
    @Test
    public void testnombreOapellidoVacio(){
        String nombre = "";
        boolean result = nombre.isEmpty();
        assertEquals(true,result);
    }
    @Test
    public void testapellidoValido() {
        String nombre = "Cadavid Gaviria";
        boolean result = verificarString(nombre);
        assertEquals(true, result);
    }
    @Test
    public void testapellidoInValido() {
        String nombre = "C@d@v1d";
        boolean result = verificarString(nombre);
        assertEquals(false, result);
    }
    @Test
    public void testCorreoValido() {
        String correo = "juan@gmail.com";
        Boolean result = emailValido(correo);
        assertEquals(true, result);
    }
    @Test
    public void testCorreoInValido() {
        String correo = "juangmail.com";
        Boolean result = emailValido(correo);
        assertEquals(false, result);
    }
    @Test
    public void testCorreoVacio(){
        String correo = "";
        Boolean result = correo.isEmpty();
        assertEquals(true,result);
    }
    @Test
    public void testcontraseñasCortas(){
        String contraseña = "123456";
        String Ccontraseña = "123456";
        boolean result;
        if(contraseña.length() > 6 || Ccontraseña.length()>6){
            result = false;
        }else{
            result = true;
        }
        assertEquals(true,result);
    }
    @Test
    public void testcontraseñasCorrectas(){
        String contraseña = "1234567";
        String Ccontraseña = "1234567";
        boolean result;
        if(contraseña.length() > 6 || Ccontraseña.length()>6){
            if(contraseña == Ccontraseña){
                result =true;
            }else{
                result = false;
            }
        }else{
            result = false;
        }
        assertEquals(true,result);
    }

    public static boolean verificarString(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    public boolean emailValido(String correo){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
