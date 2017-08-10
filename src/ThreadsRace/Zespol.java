/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsRace;

/**
 *
 * @author Kamson8
 */
public class Zespol extends Thread {

    int numerZespolu;
    Zawodnik[] zawodnik;

    public Zespol(int numer, Zawodnik[] zawodnik) {
        this.numerZespolu = numer;
        this.zawodnik = zawodnik;
    }

    public void run() {
        for (int i = 0; i < zawodnik.length; i++) {
            System.out.println("Zawodnik numer " + zawodnik[i].numer + " z zespołu " + numerZespolu + " wystartował!");
            zawodnik[i].start();
            try {
                zawodnik[i].join();
                System.out.println("Zawodnik numer " + zawodnik[i].numer + " z zespołu " + numerZespolu + " ukończył swój dystans!");

                if (zawodnik[i].numer == zawodnik.length) {
                    System.out.println("Zespół " + numerZespolu + " ukończył sztafetę!");
                }
            } catch (InterruptedException e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zespol[] zespoly = new Zespol[5];

        for (int i = 0; i < zespoly.length; i++) {
            Zawodnik[] zawodnicy = new Zawodnik[4];
            for (int j = 0; j < zawodnicy.length; j++) {
                zawodnicy[j] = new Zawodnik(j + 1);
            }
            zespoly[i] = new Zespol(i + 1, zawodnicy);
        }

        for (int i = 0; i < zespoly.length; i++) {
            zespoly[i].start();
        }

    }

}
