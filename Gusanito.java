/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_stelinlarios;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author stelinlarios
 */
public class Gusanito {

    public static ArrayList<String> instrucciones = new ArrayList<String>();
    public static char[][] tablero;
    public static int coordFilaBicho;
    public static int coordColumnaBicho;
    public static int coordFilaManzana;
    public static int CoordColumnaManzana;

    public Gusanito(int filas, int columnas) {

        this.tablero = new char[filas][columnas];

        this.tablero = fillTablero(this.tablero);
        boolean areManzanaCoordsValid = false;

        Random rand = new Random();

        coordFilaBicho = rand.nextInt(0, filas);
        coordColumnaBicho = rand.nextInt(0, columnas);

        while (!areManzanaCoordsValid) {

            coordFilaManzana = rand.nextInt(0, filas);
            CoordColumnaManzana = rand.nextInt(0, columnas);

            if (coordFilaManzana != coordFilaBicho && CoordColumnaManzana != coordColumnaBicho) {
                areManzanaCoordsValid = true;
            }
        }

        tablero[coordFilaBicho][coordColumnaBicho] = 'B';
        tablero[coordFilaManzana][CoordColumnaManzana] = 'M';

        int totalDeObstaculos;

        if (columnas > filas) {
            totalDeObstaculos = rand.nextInt(filas, columnas);
        } else if (columnas < filas) {
            totalDeObstaculos = rand.nextInt(columnas, filas);
        } else {
            totalDeObstaculos = rand.nextInt(1, filas);
        }

        while (totalDeObstaculos > 0) {

            int fila = rand.nextInt(0, filas);
            int columna = rand.nextInt(0, filas);

            if (tablero[fila][columna] != 'B' && tablero[fila][columna] != 'M') {
                tablero[fila][columna] = 'O';
                totalDeObstaculos--;
            }
        }

        String currentTablero = PrintT(tablero);
        boolean isPlaying = true;

        while (isPlaying) {
            String userOption = JOptionPane.showInputDialog(
                    null,
                    currentTablero + "\n 1. Ingresar instrucciones \n 2. Ejecutar instrucciones",
                    "Mapa",
                    JOptionPane.QUESTION_MESSAGE);

            if ("1".equals(userOption)) {
                String instruccion = JOptionPane.showInputDialog(
                        null,
                        currentTablero + "\n Ingrese la opción de la forma magnitudDireccion (ej. 2UP)",
                        "Mapa",
                        JOptionPane.QUESTION_MESSAGE);

                instrucciones.add(instruccion);

            } else {
                isPlaying = false;

            }
        }

        
    }

    public static char[][] fillTablero(char[][] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }

        return tablero;
    }

    public String PrintT(char[][] tablero) {

        String formattedTablero = "";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                formattedTablero = formattedTablero + "[" + tablero[i][j] + "] ";
            }
            formattedTablero = formattedTablero + "\n";
        }

        return formattedTablero;

    }

}
