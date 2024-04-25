package com.example.finanzi;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivityTest {
    @Test
    public void testnombreValido() {
        //Arange
        String nombre = "Juan";
        //Act
        boolean result = RegistroActivity.verificarNombre(nombre);
        //Assert
        assertEquals(true, result);
    }
    @Test
    public void testnombreInValido() {
        //Arange
        String nombre = "(8";
        //Act
        boolean result = RegistroActivity.verificarNombre(nombre);
        //Assert
        assertEquals(false, result);
    }
    @Test
    public void testnombreOapellidoVacio(){
        //Arange
        String nombre = "";
        //Act
        boolean result = RegistroActivity.campoVacio(nombre);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testapellidoValido() {
        //Arange
        String apellido = "Cadavid Gaviria";
        //Act
        boolean result = RegistroActivity.verificarNombre(apellido);
        //Assert
        assertEquals(true, result);
    }
    @Test
    public void testapellidoInValido() {
        //Arange
        String apellido = "C@d@v1d";
        //Act
        boolean result = RegistroActivity.verificarNombre(apellido);
        //Assert
        assertEquals(false, result);
    }
    @Test
    public void testCorreoValido() {
        //Arange
        String correo = "juan@gmail.com";
        //Act
        Boolean result = RegistroActivity.emailValido(correo);
        //Assert
        assertEquals(true, result);
    }
    @Test
    public void testCorreoInValido() {
        //Arange
        String correo = "juangmail.com";
        //Act
        Boolean result = RegistroActivity.emailValido(correo);
        //Assert
        assertEquals(false, result);
    }
    @Test
    public void testCorreoVacio(){
        //Arange
        String correo = "";
        //Act
        Boolean result = RegistroActivity.campoVacio(correo);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testcontraseñasCortas(){
        //Arange
        String contraseña = "123456";
        String Ccontraseña = "123456";
        //Act
        boolean result = RegistroActivity.verificarClaves(contraseña,Ccontraseña);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testcontraseñasCorrectas(){
        //Arange
        String contraseña = "1234567";
        String Ccontraseña = "1234567";
        //Act
        boolean result = RegistroActivity.verificarClaves(contraseña,Ccontraseña);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void testcontraseñasdistintas(){
        //Arange
        String contraseña = "1234567";
        String Ccontraseña = "123456";
        //Act
        boolean result = RegistroActivity.verificarClaves(contraseña,Ccontraseña);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testcontraseñasdistintasdoble(){
        assertFalse(RegistroActivity.verificarClaves("12345678","1234567"));
    }
}
