/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsRace;

import java.util.*;

/**
 *
 * @author Kamson8
 */
public class Zawodnik extends Thread {

    int numer;
    double[] array;

    Random r = new Random();

    public Zawodnik(int numer) {
        this.numer = numer;
        array = new double[1000];
    }

    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.tan(r.nextInt(100));
        }

    }
}
