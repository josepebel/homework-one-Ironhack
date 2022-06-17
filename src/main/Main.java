package main;

import classes.Battle;
import classes.Party;
import classes.PrintText;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Battle battle;

    public static void main(String[] args) throws InterruptedException {

        launch();

    }

    public static void launch() throws InterruptedException {
        sound();
        PrintText.printLogo();
        battle = new Battle();
        Scanner scanner = new Scanner(System.in);
        int comando;
        String name1 = "";
        String name2 = "";
        boolean gameOver = false;

        do {
            name1 = (battle.getArmy1() == null) ? "" : battle.getArmy1().getName();
            name2 = (battle.getArmy2() == null) ? "" : battle.getArmy2().getName();

            PrintText.printMenu(name1, name2);
            try {
                String lectorComando = scanner.nextLine();
                comando = Integer.parseInt(lectorComando);
            } catch (InputMismatchException e){
                comando = 99;
                //scanner.nextLine();
            }
            catch (NumberFormatException e){
                comando = 99;
                //scanner.nextLine();
            }
            switch (comando){
                case 1:
                    PrintText.armyName();
                    String armyName = scanner.nextLine();
                    createOneArmy(armyName);
                    break;
                case 2:
                    PrintText.armyName();
                    String armyImport = scanner.nextLine();
                    if (!importArmy(armyImport));
                    comando=99;
                    break;
                case 3:
                    gameOver = startGame();
                    break;
                case 4:
                    exportParties();
                    break;
                case 5:
                    PrintText.seeArmies(battle);
                    break;
                case 9:
                    break;
                default:
                    PrintText.printWrongOption();
                    break;
            }

        } while ((comando != 9) && !(gameOver));

        PrintText.printGoodbye();
    }

    private static void createOneArmy(String name) throws InterruptedException {

        Party army = new Party(name);
        army.createParty();
        Scanner scanner = new Scanner(System.in);
        int comando = 0;

        do {
            PrintText.printOptionsAfterCreateArmy();
            try {
                comando = scanner.nextInt();
            } catch (InputMismatchException e){
                comando = 99;
                scanner.nextLine();
            }

            switch (comando){
                case 1:
                    if (battle.getArmy1() == null){
                        battle.setArmy1(army);
                    }else if (battle.getArmy2() == null){
                        battle.setArmy2(army);
                    } else {
                        int comando2 = 0;
                        do {
                            PrintText.printArmiesToReplace(battle.getArmy1().getName(), battle.getArmy2().getName());
                            try {
                                comando2 = scanner.nextInt();
                            } catch (InputMismatchException e){
                                comando2 = 99;
                                scanner.nextLine();
                            }
                            switch (comando2){
                                case 1:
                                    battle.setArmy1(army);
                                    break;
                                case 2:
                                    battle.setArmy2(army);
                                    break;
                                case 3:
                                    break;
                                default:
                                    PrintText.printWrongOption();
                                    break;
                            }

                        }while ((comando2 != 1) && (comando2 != 2) && (comando2 != 3));

                    }
                    break;
                case 2:
                    army.exportParty();
                    break;
                case 3:
                    break;
                default:
                    PrintText.printWrongOption();
                    break;
            }

        } while ((comando != 1) && (comando != 2)&& (comando != 3));


    }

    private static boolean importArmy(String name) throws InterruptedException {

        Party army = new Party(name);
        army.listPartyFileNames();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CSV file name: ");
        String fileName = scanner.next(); //introducimos el nombre del fichero (p.ej. party_1.csv)
        fileName = "src\\csv\\" + fileName;

        if (!army.importParty(fileName))
            return false;
        else {
            if (battle.getArmy1() == null) {
                battle.setArmy1(army);
            } else if (battle.getArmy2() == null) {
                battle.setArmy2(army);
            } else {
                int comando2 = 0;
                do {
                    PrintText.printArmiesToReplace(battle.getArmy1().getName(), battle.getArmy2().getName());
                    try {
                        comando2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        comando2 = 99;
                        scanner.nextLine();
                    }
                    switch (comando2) {
                        case 1:
                            battle.setArmy1(army);
                            break;
                        case 2:
                            battle.setArmy2(army);
                            break;
                        default:
                            PrintText.printWrongOption();
                            break;
                    }

                } while ((comando2 != 1) && (comando2 != 2));

            }
            return true;
        }
    }

    private static boolean startGame() throws InterruptedException {
        if ((battle.getArmy1() != null) && (battle.getArmy2() != null)) {
            battle.wholeBattle();
            return true;
        } else{
            PrintText.printErrorArmiesUnset();
            return false;
        }
    }

    private static void exportParties() throws InterruptedException {

        if (battle.getArmy1() == null) {

            PrintText.printErrorArmiesUnset();

        } else if (battle.getArmy2() == null) {

            //PrintText.exportOnlyFirstArmy(battle.getArmy1().getName());
            battle.getArmy1().exportParty();

        } else {
            Scanner scanner = new Scanner(System.in);
            int comando = 0;

            do {
                PrintText.printArmiesToExport(battle.getArmy1().getName(), battle.getArmy2().getName());
                try {
                    comando = scanner.nextInt();
                } catch (InputMismatchException e) {
                    comando = 99;
                    scanner.nextLine();
                }

                switch (comando) {
                    case 1:
                        battle.getArmy1().exportParty();
                        break;
                    case 2:
                        battle.getArmy2().exportParty();
                        break;
                    case 3:
                        break;
                    default:
                        PrintText.printWrongOption();
                        break;
                }

            } while ((comando != 1) && (comando != 2) && (comando != 3)) ;
        }
    }

    public static void sound() {
        try{
            AudioInputStream song = AudioSystem.getAudioInputStream(new File("sound.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(song);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-15.0f);
            clip.loop(10);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
