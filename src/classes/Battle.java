package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    /////////////////////////////
    //////// PROPERTIES /////////
    /////////////////////////////

    private Party army1;
    private Party army2;

    private ArrayList<Character> graveyard;

    private ArrayList<Integer> graveyardArmies = new ArrayList<>(); // Arraylist para almacenar los ejercitos a los que
                                                                    // pertenece el personaje que ha muerto y pintarlo en el showgraveyard

    private int turns; //Para llevar la cuenta de turnos que ha habido
    private int duels; //Para llevar la cuenta del número de duelos que ha habido
    private int rounds; //Para llevar la cuenta del número de rondas dentro del duelo actual

    private boolean goOut;

    /////////////////////////////
    //////// CONSTRUCTOR ////////
    /////////////////////////////

    public Battle() //He creado este nuevo para poder crear una batalla antes de
    {
        this.graveyard = new ArrayList<>();
        this.turns = 0;
        this.duels = 0;
        this.rounds = 0;
        this.goOut = false;
    }
    public Battle(
            Party army1,
            Party army2
    )
    {
        this.army1 = army1;
        this.army2 = army2;
        this.graveyard = new ArrayList<>();
        this.turns = 0;
        this.duels = 0;
        this.rounds = 0;
        this.goOut = false;
    }


    /////////////////////////////
    ////// BATTLE METHODS ///////
    /////////////////////////////

    //Batalla completa: contiene un bucle de duelos entre caracteres mientras haya vivos en ambos bandos
    public void wholeBattle() throws InterruptedException {
        PrintText.printStartWholeBattle();
        int comando = 1;
        do { //Bucle para repetir duelos hasta que en algún bando no queden caracteres vivos
            duels++;
            rounds=0;

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            do {

                switch (comando){
                    case 1:
                        Character fighter1 = army1.pickFighter();
                        Character fighter2 = army2.pickFighter();

                        beginDuel(fighter1, fighter2);
                        if((army1.hasAliveCharacters()) && (army2.hasAliveCharacters()) && (!goOut)) {
                            PrintText.printFramedText(army1.getName() + " Remaining Fighters:");
                            army1.printCharactersInfo();
                            PrintText.printFramedText(army2.getName() + " Remaining Fighters:");
                            army2.printCharactersInfo();

                        }
                        break;
                    case 2:
                        goOut = true;
                        break;
                    default:
                        PrintText.printWrongOption();
                        break;
                }

                if((army1.hasAliveCharacters()) && (army2.hasAliveCharacters()) && (!goOut)) {
                    PrintText.continueGame();
                    try {
                        String lectorComando = scanner.nextLine();
                        comando = Integer.parseInt(lectorComando);
                    } catch (InputMismatchException e) {
                        comando = 99;
                        //scanner.nextLine();
                    } catch (NumberFormatException e) {
                        comando = 99;
                        //scanner.nextLine();
                    }
                }

            } while ((comando !=1 ) && (comando != 2));

        } while ((army1.hasAliveCharacters()) && (army2.hasAliveCharacters()) && (!goOut));

        if (!goOut) { //If the player has not chosen to quit the game
            if (army1.hasAliveCharacters() && !army2.hasAliveCharacters()) {
                printBattleWinner(army1);
            } else if (!army1.hasAliveCharacters() && army2.hasAliveCharacters()) {
                printBattleWinner(army2);
            } else {
                PrintText.printBattleTie();
            }

            //Mostrar los personajes que han acabado en el cementerio
            showGraveyard();
        }

    }

    private void beginDuel(Character fighter1, Character fighter2) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        printDuelNumber(fighter1, fighter2); //PRINT METHOD
        do{

            rounds++;
            newRound(fighter1, fighter2);

            if ((fighter1.isAlive()) && (fighter2.isAlive())) {
                System.out.print("Press Enter to continue . . . ");
                scanner.nextLine();
            }
        } while ((fighter1.isAlive()) && (fighter2.isAlive()));

        resolveDuel(fighter1, fighter2);  //PRINT METHOD
        System.out.println("");
        System.out.print("Press Enter to continue . . . ");
        scanner.nextLine();
    }

    private void newRound(Character fighter1, Character fighter2) {
        printRoundNumber();      //PRINT METHOD
        turns++;

        int attack1 = fighter1.attack();
        int attack2 = fighter2.attack();

        PrintText.printOrnateSeparator();

        fighter1.takeDamage(attack2);
        fighter2.takeDamage(attack1);

        if(!fighter1.checkStats()) {

            army1.removeCharacter(fighter1);  //Se reduce el número de caracteres vivos en el ejército
            graveyardArmies.add(1); // Se añade el número del ejercito al que pertenece el personaje que ha muerto posteriormente se consigue el nombre en showgraveyard
            graveyard.add(fighter1);
        }

        if(!fighter2.checkStats()) {

            army2.removeCharacter(fighter2);  //Se reduce el número de caracteres vivos en el ejército
            graveyardArmies.add(2); //Se añade el número del ejercito al que pertenece el personaje que ha muerto posteriormente se consigue el nombre en showgraveyard
            graveyard.add(fighter2);
        }
        System.out.println("");
    }

    /////////////////////////////
    ////////// PRINTS ///////////
    /////////////////////////////

    private void printDuelNumber(Character fighter1, Character fighter2) throws InterruptedException {

        System.out.println("");
        PrintText.printFramedText("duel " +  duels + ": "+ fighter1.getName() + " VS. " + fighter2.getName());
        System.out.println("");
    }

    private void printRoundNumber() {
        System.out.println("");
        if (rounds < 10) {
            System.out.println("     * +-+-+-+-+-+ +-+-+ *");
            System.out.println("     | |R|o|u|n|d| | " + rounds + " | |");
            System.out.println("     * +-+-+-+-+-+ +-+-+ *");
        } else {
            System.out.println("     * +-+-+-+-+-+ +-++-+ *");
            System.out.println("     | |R|o|u|n|d| | " + rounds + " | |");
            System.out.println("     * +-+-+-+-+-+ +-++-+ *");
        }
        System.out.println("        ╔═╗╦╔═╗╦ ╦╔╦╗┬");
        System.out.println("        ╠╣ ║║ ╦╠═╣ ║ │");
        System.out.println("        ╚  ╩╚═╝╩ ╩ ╩ o");
        System.out.println("");
    }

    private void resolveDuel(Character fighter1, Character fighter2) throws InterruptedException {
        if(fighter1.isAlive() && !fighter2.isAlive()) {
            System.out.println("");
            PrintText.printBoxedText(fighter1.getName() + " won the duel for " + army1.getName() + " army!");
            System.out.println("");
            System.out.println("\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 " + fighter2.getName().toUpperCase() + " DIED \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80");
            System.out.println("");
        } else if (!fighter1.isAlive() && fighter2.isAlive()) {
            System.out.println("");
            PrintText.printBoxedText(fighter2.getName() + " won the duel for " + army2.getName() + " army!");
            System.out.println("");
            System.out.println("\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 " + fighter1.getName().toUpperCase() + " DIED \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80");
            System.out.println("");
        } else if (!fighter1.isAlive() && !fighter2.isAlive()) {
            System.out.println("");
            PrintText.printBoxedText("the duel ended in a tie");
            System.out.println("");
            System.out.println("\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 BOTH FIGHTERS DIED \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80");
            System.out.println("");
        }

    }

    private void printBattleWinner(Party army) throws InterruptedException {
        PrintText.printFramedText(army.getName() + " has won the battle");
    }

    //showGraveyard method
    private void showGraveyard() {
        PrintText.printGraveyardTitle();

        System.out.println("\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 " + " THESE ARE THE FALLEN FIGHTERS:  \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80");

        // Nuevo método para recorrer el graveyard y mostrar su nombre, tipo y la armada a la que pertenece
        // (El anterior no pintaba por consola bien el ejercito al que pertenecía)

        for (int i = 0; i < this.graveyard.size(); i++) {

            String fighterArmy = (this.graveyardArmies.get(i) == 1 ? army1.getName() : army2.getName());

            System.out.println("Name: " + this.graveyard.get(i).getName() + ", Class: " +  this.graveyard.get(i).getClass().getSimpleName() + ", Army: " + fighterArmy);
        }


    }

    @Override
    public String toString() {
        String result = "Battle {";
        if (army1 != null){
            result = result + army1.getName();
            if (army2 != null){
                result = result + " vs. " + army2.getName();
            } else {
                result = result + " waiting for a rival";
            }

        } else{
            result = result + "no armies set yet";
        }
        result = result + ", turns=" + turns +
                ", duels=" + duels +
                ", rounds=" + rounds +
                '}';
        return result;
    }
    
    /////////////////////////////
    ///// GETTERS / SETTERS /////
    /////////////////////////////

    public Party getArmy1() {
        return army1;
    }

    public void setArmy1(Party army1) {
        this.army1 = army1;
    }

    public Party getArmy2() {
        return army2;
    }

    public void setArmy2(Party army2) {
        this.army2 = army2;
    }

    public ArrayList<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(ArrayList<Character> graveyard) {
        this.graveyard = graveyard;
    }
}
