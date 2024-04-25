package com.example.finanzi;

import static org.junit.Assert.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.Test;
import org.mockito.Mockito;
import com.google.android.gms.tasks.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivityTest {
    @Test
    public void testCorreoValido(){
        //Arange
        String correo = "juan@gmail.com";
        //Act
        Boolean result = MainActivity.emailValido(correo);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void testCorreoNoValido(){
        //Arange
        String correo = "juan";
        //Act
        Boolean result = MainActivity.emailValido(correo);
        //Assert
        assertFalse(result);
    }
    @Test
    public void testCorreoVacio(){
        //Arange
        String correo = " ";
        //Act
        Boolean result = MainActivity.emailValido(correo);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testContraseñaVacio(){
        //Arange
        String contrasena = "";
        //Act
        Boolean result = MainActivity.campoVacio(contrasena);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testContraseñaNoVacia(){
        //Arange
        String contrasena = "contraseña";
        //Act
        Boolean result = MainActivity.campoVacio(contrasena);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void testSuccessfulLogin() throws Exception {
        // Arrange
        MainActivity activity = new MainActivity();
        String email = "test@example.com";
        String password = "valid_password";

        // Mock FirebaseAuth
        FirebaseUser mockUser = Mockito.mock(FirebaseUser.class);
        FirebaseAuth mockAuth = Mockito.mock(FirebaseAuth.class);
        Task<AuthResult> mockTask = Mockito.mock(Task.class);
        OnCompleteListener<AuthResult> mockListener = Mockito.mock(OnCompleteListener.class);
        Mockito.when(mockAuth.signInWithEmailAndPassword(email, password)).thenReturn(mockTask);
        activity.mAuth = mockAuth;

        // Act
        activity.mbtniniciar.performClick(); // Simulate button click
        Mockito.verify(mockTask).addOnCompleteListener(mockListener); // Verify listener added

        // Simulate successful completion (modify based on your library version)
        Mockito.verify(mockListener).onComplete(Mockito.any(Task.class)); // Might need to adjust argument type

        // Assert
        assertEquals("test@example.com", currentUser.getEmail());
        // (assertions might involve checking text views or navigation calls)
    }


}