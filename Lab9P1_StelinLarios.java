/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_stelinlarios;

import javax.swing.JOptionPane;

/**
 *
 * @author stelinlarios
 *
 * 1 - 14
 */
public class Lab9P1_StelinLarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean areCoordsValid = false;
        int filas = 0;
        int columnas = 0;

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Lab 9 - Q4 2023",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Gusanito", "Salir"},
                "Gusanito");

        if (seleccion != 0) {
            return;
        }

        while (!areCoordsValid) {
            String size = JOptionPane.showInputDialog(
                    null,
                    "Ingrese las dimensiones del tablero en el formato ancho,alto",
                    JOptionPane.QUESTION_MESSAGE);

            String[] tablero = size.split(",");

            filas = Integer.parseInt(tablero[0]);
            columnas = Integer.parseInt(tablero[1]);

            if (filas >= 4 && filas <= 10 && columnas >= 4 && columnas <= 10) {
                areCoordsValid = true;
            } else {

            }
        }

//        B = BICHO
//        M = MANZANA
//        O = OBSTACULO
        Gusanito bicho = new Gusanito(filas, columnas);

    }

}
