package com.example.finanzi;

import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertTrue;

import android.content.Intent;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class InicioActivityTest {
    private InicioActivity inicioActivity;

    @BeforeEach
    public void setUp() {
        inicioActivity = new InicioActivity();
    }
    @Test
    public void testComprar1vida(){
        //Arrange
        int vidas = 2;
        int monedas = 5;
        //Actt
        boolean result = InicioActivity.verificar5Monedas(monedas)&& InicioActivity.verificar3Vidas(vidas);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testComprar3vidas(){
        //Arange
        int vidas = 0;
        int monedas = 12;
        //Act
        boolean result = InicioActivity.verificar12Monedas(monedas)&& InicioActivity.verificarVidas(vidas);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testvidasLlenas(){
        //Arrange
        int vidas = 3;
        int monedas = 12;
        //Act
        boolean result = InicioActivity.verificar3Vidas(vidas)&& InicioActivity.verificar12Monedas(monedas);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testMonedasInsuficientes(){
        //Arrange
        int vidas = 0;
        int monedas = 11;
        //Act
        boolean result = InicioActivity.verificarVidas(vidas)&&InicioActivity.verificar12Monedas(monedas);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testMenosDe12Monedas(){
        //Arrange
        int monedas = 11;
        //Act
        boolean result = InicioActivity.verificar12Monedas(monedas);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void testMenosDe5Monedas(){
        //Arrange
        int monedas = 4;
        //Act
        boolean result = InicioActivity.verificar5Monedas(monedas);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void test0Vidas(){
        //Arrange
        int vidas = 0;
        //Act
        boolean result = InicioActivity.verificarVidas(0);
        //Assert
        assertEquals(false,result);
    }
    @Test
    public void testVerificarVidas(){
        //Arrange
        int vidas = 1;
        //Act
        boolean result = InicioActivity.verificarVidas(vidas);
        //Assert
        assertEquals(true,result);
    }
    @Test
    public void testVidasDiferentesA3(){
        //Arrange
        int vidas = 2;
        //Act
        boolean result = InicioActivity.verificar3Vidas(vidas);
        //Assert
        assertEquals(false,result);
    }

}
