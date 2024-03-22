package org.iesvdm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AlturaAlumnoTest {
    @Test
    void verdadero() {
        assertTrue(1==1);
    }


    @Test
    void aniadeNombreTest1() {

        final String[] array = new String[2];

        array[0]="Jose";
        array[1]="Paco";

        String nombre = "María";
        String[] arrayActual = AlturaAlumno.añadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length-1].equals(nombre));

        for (int i = 0; i< array.length;i++)
            assertEquals(array[i], arrayActual[i]);

//        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
//        arrayExpected[arrayExpected.length-1]=nombre;
//
//        assertArrayEquals(arrayExpected, arrayActual);

    }

    @Test
    void aniadeNombreTest2() {


        final String[] array = new String[0];
        int longInicial = array.length;

        String nombre = "María";
        String[] arrayActual = AlturaAlumno
                .añadeNombre(array, nombre);

//        assertTrue(arrayActual[arrayActual.length-1]
//                .equals(nombre) );
        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[longInicial+1]);

    }

    @Test
    void aniadeAlturaTest1(){
        final double[] array = new double[2];

        array[0]=1.2;
        array[1]=1.6;

        double[] result = AlturaAlumno.añadeAltura(array);

        assertTrue(result[result.length-1]==1.5);

        for (int i = 0; i< array.length;i++)
            assertEquals(array[i], result[i]);

    }

    @Test
    void modificaAlturaPosicionEnElArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = 1;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
        for (int i = 0; i < array.length; i++) {
            if (i != posicion) {
                assertEquals(array[i], array2[i]);
            }
        }

    }

    @Test
    void modificaAlturaPosicionFueraDeRangoArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);
        int posicion = array.length+2;
        double altura = 1.9;


        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);


        //Then (Entonces)

        //altura esta en la posicion
        //assertTrue( altura == array[posicion]);

        //Todos los demas elementos del array no cambian
//        for (int i = 0; i < array.length; i++) {
//                assertEquals(array[i], array2[i]);
//        }
        assertArrayEquals(array2, array);

    }

    @Test
    void buscaNombreTest1(){
        String[] arrayNombres = {"Juan","Manuel","Javier"};

        int result=AlturaAlumno.buscaNombre(arrayNombres, "Javier");
        // probando con un nombre que se encuentra en el array
        assertTrue(result!=-1);
        assertEquals(2, result);

        // probando un nombre que no se encuentre en el array
        result=AlturaAlumno.buscaNombre(arrayNombres, "Fran");
        assertEquals(-1, result);

    }

    @Test
    void calcularMaximoTest1(){
        double[]array={1.2,5,8,9,15,16,2,3.5};

        double[]result=AlturaAlumno.calculaMaximo(array);

        assertEquals(5, result[0]);
        assertEquals(16, result[1]);

    }

    @Test
    void calcularMediaTest1(){
        double[] array={1,2,3,4,5,6,7,8,9,10};

        double media=AlturaAlumno.calculaMedia(array);

        assertEquals(5.5, media);

    }

}
