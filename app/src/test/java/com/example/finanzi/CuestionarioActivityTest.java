package com.example.finanzi;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CuestionarioActivityTest {
    @Test
    public void testNivelBloqueado(){
        int vidas = 3;
        String Completado = "";
        boolean result;
        if(vidas > 0){
            if(!Completado.isEmpty()){
                result = true;
            }else {
                result = false;
            }
        }else{
            result = false;
        }
        assertEquals(false,result);
    }
    @Test
    public void testSinVidas(){
        int vidas = 0;
        String Completado = "";
        boolean result;
        if(vidas > 0){
            if(!Completado.isEmpty()){
                result = true;
            }else {
                result = false;
            }
        }else{
            result = false;
        }
        assertEquals(false,result);
    }
    @Test
    public void testentrarNivel(){
        int vidas = 3;
        String Completado = "Completado";
        boolean result;
        if(vidas > 0){
            if(!Completado.isEmpty()){
                result = true;
            }else {
                result = false;
            }
        }else{
            result = false;
        }
        assertEquals(true,result);
    }
    @Test
    public void testFallarPregunta(){
        int vidas = 3;
        String respuesta = "A";
        boolean result;
        if(respuesta == "B"){

        }else{
            vidas -=1;
        }
        if(vidas == 2){
            result = true;
        }else{
            result = false;
        }
        assertEquals(true,result);
    }
    @Test
    public void testacertarPregunta(){
        int vidas = 3;
        String respuesta = "B";
        boolean result;
        if(respuesta == "B"){

        }else{
            vidas -=1;
        }
        if(vidas == 3){
            result = true;
        }else{
            result = false;
        }
        assertEquals(true,result);
    }

}
