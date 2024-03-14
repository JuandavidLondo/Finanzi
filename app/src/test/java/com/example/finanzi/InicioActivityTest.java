package com.example.finanzi;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class InicioActivityTest {
    @Test
    public void testComprar1vida(){
        int vidas = 2;
        int monedas = 5;
        boolean result;
        if(vidas < 3 && monedas >= 5){
            vidas +=1;
            monedas -=5;
        }
        if(vidas == 3 && monedas == 0){
            result = true;
        }else{
            result = false;
        }
        assertEquals(true,result);
    }
    @Test
    public void testComprar3vidas(){
        int vidas = 0;
        int monedas = 12;
        boolean result;
        if(vidas == 0  && monedas >= 12){
            vidas +=3;
            monedas -=12;
        }
        if(vidas == 3 && monedas == 0){
            result = true;
        }else{
            result = false;
        }
        assertEquals(true,result);
    }
    @Test
    public void testvidasLlenas(){
        int vidas = 3;
        int monedas = 12;
        boolean result;
        if(vidas == 0  && monedas >= 12){
            vidas +=3;
            monedas -=12;
        }
        if(vidas == 3 && monedas == 0){
            result = true;
        }else{
            result = false;
        }
        assertEquals(false,result);
    }
    @Test
    public void testMonedasInsuficientes(){
        int vidas = 0;
        int monedas = 11;
        boolean result;
        if(vidas == 0  && monedas >= 12){
            vidas +=3;
            monedas -=12;
        }
        if(vidas == 3 && monedas == 0){
            result = true;
        }else{
            result = false;
        }
        assertEquals(false,result);
    }
}
