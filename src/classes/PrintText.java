package classes;

import java.util.Scanner;

public class PrintText {

    /* * * * * * * * * * * * * * * * * */
    /* * * *  FIXED TEXT METHODS * * * */
    /* * * * * * * * * * * * * * * * * */

    public static void printLogo() {
        System.out.println("");
        System.out.println("      ██╗    ██╗██╗███████╗ █████╗ ██████╗ ██████╗ ███████╗");
        System.out.println("      ██║    ██║██║╚══███╔╝██╔══██╗██╔══██╗██╔══██╗██╔════╝");
        System.out.println("      ██║ █╗ ██║██║  ███╔╝ ███████║██████╔╝██║  ██║███████╗");
        System.out.println("      ██║███╗██║██║ ███╔╝  ██╔══██║██╔══██╗██║  ██║╚════██║");
        System.out.println("      ╚███╔███╔╝██║███████╗██║  ██║██║  ██║██████╔╝███████║");
        System.out.println("       ╚══╝╚══╝ ╚═╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝");
        System.out.println("");
        System.out.println("                      ██╗   ██╗███████╗");
        System.out.println("                      ██║   ██║██╔════╝");
        System.out.println("                      ██║   ██║███████╗");
        System.out.println("                      ╚██╗ ██╔╝╚════██║");
        System.out.println("                       ╚████╔╝ ███████║");
        System.out.println("                        ╚═══╝  ╚══════╝");
        System.out.println("");
        System.out.println("  ██╗    ██╗ █████╗ ██████╗ ██████╗ ██╗ ██████╗ ██████╗ ███████╗");
        System.out.println("  ██║    ██║██╔══██╗██╔══██╗██╔══██╗██║██╔═══██╗██╔══██╗██╔════╝");
        System.out.println("  ██║ █╗ ██║███████║██████╔╝██████╔╝██║██║   ██║██████╔╝███████╗");
        System.out.println("  ██║███╗██║██╔══██║██╔══██╗██╔══██╗██║██║   ██║██╔══██╗╚════██║");
        System.out.println("  ╚███╔███╔╝██║  ██║██║  ██║██║  ██║██║╚██████╔╝██║  ██║███████║");
        System.out.println("   ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
        System.out.println("");
    }

    public static void printMenu(String army1, String army2){
        System.out.println();
        System.out.println("        _________________________________");
        System.out.println("      / \\                                \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''/");
        System.out.println("       (                                (");
        System.out.println("       )       1. Create An Army        )");
        System.out.println("       )       2. Import An Army        )");
        System.out.println("       )       3. Start The Battle      )");
        System.out.println("       )       4. Export Army to CSV    )");
        System.out.println("       (       5. See Armies            (");
        System.out.println("       )       9. Exit The Game         )");
        System.out.println("       (                                (");
        System.out.println("       /\\''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/________________________________/");
        System.out.println("");
        if ((army1 == "" ) && (army2 != ""))
            System.out.println("          " + army2.toUpperCase() + " IS WAITING FOR A RIVAL!");
        if ((army1 != "" ) && (army2 == ""))
            System.out.println("          " + army1.toUpperCase() + " IS WAITING FOR A RIVAL!");
        if ((army1 != "" ) && (army2 != ""))
            System.out.println("          " + army1.toUpperCase() + " VS. " + army2.toUpperCase());
        System.out.println();
    }

    public static void printOptionsAfterCreateArmy() {
        System.out.println();
        System.out.println("       ______________________________");
        System.out.println("      / \\                            \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       )     1.Play with this army   )");
        System.out.println("       (                             (");
        System.out.println("       )      2.Export this army     )");
        System.out.println("       (                             (");
        System.out.println("       )      3.Go back              )");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/____________________________/");
        System.out.println();
    }

    public static void printArmiesToReplace(String army1, String army2) throws InterruptedException {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       )  Type the number of the army to replace   )");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();
        PrintText.printBoxedText("1. " + army1);
        PrintText.printBoxedText("2. " + army2);
        PrintText.printBoxedText("3. Go back and no replace any army");

    }

    public static void printArmiesToExport(String army1, String army2) throws InterruptedException {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       )  Type the number of the army to export   )");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();
        PrintText.printBoxedText("1. " + army1);
        PrintText.printBoxedText("2. " + army2);
        PrintText.printBoxedText("3. Go back and no export any army");

    }

        public static void firstAction(){
        System.out.println();
        System.out.println("       ______________________________");
        System.out.println("      / \\                            \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       (                             (");
        System.out.println("       )     1.Create First Army     )");
        System.out.println("       (                             (");
        System.out.println("       )       2.Exit The Game       )");
        System.out.println("       (                             (");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/____________________________/");
        System.out.println();
        System.out.println("CHOOSE WISELY:");
    }

    public static void secondAction() {
        System.out.println();
        System.out.println("       ______________________________");
        System.out.println("      / \\                            \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       (                             (");
        System.out.println("       )     1.Create Second Army    )");
        System.out.println("       (     2.Export First Army     (");
        System.out.println("       )       3.Exit The Game       )");
        System.out.println("       (                             (");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/____________________________/");
        System.out.println();
        System.out.println("CHOOSE WISELY:");
    }

    public static void thirdAction() {
        System.out.println();
        System.out.println("       ______________________________");
        System.out.println("      / \\                            \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       (                             (");
        System.out.println("       )      1.Start The Battle     )");
        System.out.println("       (     2.Export First Army     (");
        System.out.println("       )     3.Export Second Army    )");
        System.out.println("       (       4.Exit The Game       (");
        System.out.println("       )                             )");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/____________________________/");
        System.out.println();
        System.out.println("CHOOSE WISELY:");

    }

    public static void armyName(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       )         Set army name:      )");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }

    public static void printErrorArmiesUnset(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''/");
        System.out.println("       )  You have to set the armies first )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }
    public static void firstArmyName(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       )     Set first army name:   )");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }

    public static void secondArmyName(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''/");
        System.out.println("       )     Set second army name:  )");
        System.out.println("       /\\''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }

    public static void setArmyTotalSize(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Set army total size (min size 1) )");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();


    }

    public static void askWarriorName(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''/");
        System.out.println("       )       Insert Warrior's name      )");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }

    public static void askWizardName(){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''/");
        System.out.println("       )       Insert Wizard's name       )");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();

    }

    public static void askWarriorHp(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Warrior's hp  (Min: " + Warrior.getMinHpWarrior() + ", Max: " + Warrior.getMaxHpWarrior() + ")    )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void askWizardHp(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Wizard's hp  (Min: " + Wizard.getMinHpWizard() + ", Max: " + Wizard.getMaxHpWizard() + ")      )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void askWarriorStamina(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Warrior's stamina  (Min: " + Warrior.getMinStaminaWarrior() + ", Max: " + Warrior.getMaxStaminaWarrior() + ")    )");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void askWizardMana(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Wizard's mana  (Min: " + Wizard.getMinManaWizard() + ", Max: " + Wizard.getMaxManaWizard() + ")     )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void askWarriorStrength(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Warrior's strength  (Min: " + Warrior.getMinStrengthWarrior() + ", Max: " + Warrior.getMaxStrengthWarrior() + ")    )");
        System.out.println("      \\ /'''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println();
    }

    public static void askWizardIntelligence(){
        System.out.println();
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       ) Insert Wizard's intelligence  (Min: " + Wizard.getMinIntelligenceWizard() + ", Max: " + Wizard.getMaxIntelligenceWizard() + ")  )");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("    (O)===)><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void printOptionsPickFighter(String army) {
        System.out.println();
        System.out.println("       CHOOSE A FIGHTER FROM ARMY " + army.toUpperCase() );
        System.out.println("       _________________________________________");
        System.out.println("      / \\                                      \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       )                                        )");
        System.out.println("       )        1. Choose by Fighter Name       )");
        System.out.println("       (        2. Choose Random Fighter        (");
        System.out.println("       )                                        )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       \\/______________________________________/");
        System.out.println();
        System.out.println("CHOOSE WISELY:");
    }

    public static void continueGame() {
        System.out.println();
        System.out.println("       _________________________________________");
        System.out.println("      / \\                                      \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''''''''/");
        System.out.println("       )                                        )");
        System.out.println("       )        1. Continue the battle          )");
        System.out.println("       (        2. Quit the game                (");
        System.out.println("       )                                        )");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       \\/______________________________________/");
        System.out.println();
    }

    public static void printPickFightersName() {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("       (       Write your Fighter's Name       (");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
        System.out.println("CHOOSE WISELY:");
    }

    public static void printWrongFigtherName() {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("       )  This fighter doesn't exist. Choose a valid fighter  (");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void printWrongOption() {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("       )          Error! Choose a valid option!         (");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void printErrorImport() {
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("       )    An error occurred during import. Army not created (");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();
    }

    public static void seeArmies(Battle battle) throws InterruptedException {
        if(battle.getArmy1() != null) {
            printFramedText(battle.getArmy1().getName() + " Fighters:");
            battle.getArmy1().printCharactersInfo();

            if (battle.getArmy2() != null) {
                System.out.print("Press Enter to see next army . . . ");
                Scanner scanner =  new Scanner(System.in);
                scanner.nextLine();
                printFramedText(battle.getArmy2().getName() + " Fighters:");
                battle.getArmy2().printCharactersInfo();
            } else{

                System.out.println();
                System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><>)==(O)");
                System.out.println("       /\\''''''''''''''''''''''''''''''''''''\\");
                System.out.println("       )        Second army not set yet      (");
                System.out.println("       /\\'''''''''''''''''''''''''''''''''''''\\");
                System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><>)==(O)");
                System.out.println();

            }
        } else {
            printErrorArmiesUnset();
        }
    }

    public static void exportOnlyFirstArmy(String name){
        System.out.println();
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''''\\");
        System.out.println("       )        " + name + " is exported");
        System.out.println("       /\\'''''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><><><><>)==(O)");
        System.out.println();

    }

    public static void printStartWholeBattle(){
        System.out.println("");
        System.out.println("   .                                                  .");
        System.out.println("  / \\                                                / \\");
        System.out.println("  | |    _.-=-._.-=-._.-=-._._.-=-._.-=-._.-=-._     | |");
        System.out.println("  | |    *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+     | |");
        System.out.println("  |.|    ╔╗ ╔═╗╔╦╗╔╦╗╦  ╔═╗  ╔═╗╔╦╗╔═╗╦═╗╔╦╗╔═╗ ┬    |.|");
        System.out.println("  |.|    ╠╩╗╠═╣ ║  ║ ║  ║╣   ╚═╗ ║ ╠═╣╠╦╝ ║ ╚═╗ │    |.|");
        System.out.println("  |:|    ╚═╝╩ ╩ ╩  ╩ ╩═╝╚═╝  ╚═╝ ╩ ╩ ╩╩╚═ ╩ ╚═╝ o    |:|");
        System.out.println("  |:|    *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+     |:|");
        System.out.println("`--8--´  `-._.-´'`-._.-´'`-._.-´'`-._.-´'`-._.-´   `--8--´");
        System.out.println("   8                                                  8");
        System.out.println("   O                                                  O");
        System.out.println("");
    }

    public static void printBattleTie() {
        System.out.println("");
        System.out.println("     _.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._");
        System.out.println("     *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*");
        System.out.println("     || N O | A R M Y | W O N | T H E | B A T T L E ||");
        System.out.println("     *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*");
        System.out.println("     `-._.-´`-._.-´`-._.-´`-._.-´`-._.-´`-._.-´`-._.-´");
        System.out.println("");
        System.out.println("              ╔╦╗╦╔═╗╔╦╗  ╔╗ ╔═╗╔╦╗╔╦╗╦  ╔═╗");
        System.out.println("               ║ ║║╣  ║║  ╠╩╗╠═╣ ║  ║ ║  ║╣");
        System.out.println("               ╩ ╩╚═╝═╩╝  ╚═╝╩ ╩ ╩  ╩ ╩═╝╚═╝");
        System.out.println("");
    }

    public static void printGraveyardTitle() {
        System.out.println("");
        System.out.println("                    .▄#▓██████████▓▄▄,");
        System.out.println("                 .▄███████████████████▄,");
        System.out.println("               ╓▓████████████████████████▄");
        System.out.println("            .▓█████████████████████████████▄");
        System.out.println("            █ ╔═╗╦═╗╔═╗╦  ╦╔═╗╦ ╦╔═╗╦═╗╔╦╗ █");
        System.out.println("            █ ║ ╦╠╦╝╠═╣╚╗╔╝║╣ ╚╦╝╠═╣╠╦╝ ║║ █");
        System.out.println("            █ ╚═╝╩╚═╩ ╩ ╚╝ ╚═╝ ╩ ╩ ╩╩╚══╩╝ █");
        System.out.println("            ▀███████████████████████████████ ");
        System.out.println("             (████▀▀▀▀▀▀▀████████╙╙╙╙▀▀▀███▀");
        System.out.println("              ╙██▄       ║██████        └██▌");
        System.out.println("               ██▌      ▓████▀███,    ┌▄▓███▄");
        System.out.println("            (███████▓▓▓████▌  └████▓█████████▌");
        System.out.println("          ▄▄▄▀████▀████████    ████████▀▀███- ..");
        System.out.println("         (███▄       └▀█████▄╓▄████▀╙       (███)");
        System.out.println("       ▄#█████▓,      .█████████████      .▄████▌▄");
        System.out.println("       ██████████▄▄   \"████████████▀  .▄▓█████████▌");
        System.out.println("        -    .▀▀█████▄, └\"▀▀█▀▀▀╙  ,▄▓████▀▀└  .└└");
        System.out.println("                 .▀▀████▓▄     .▄▓████▀▀└");
        System.out.println("                     .▀▀████▓▓████▀╙");
        System.out.println("                        ▄███████▄,");
        System.out.println("                 .▄▄▄#████▀▀. ╙▀▀██▓▄▄▓,");
        System.out.println("                 ╙█████╙          └███▀.");
        System.out.println("                   └█▀              ╙└");
        System.out.println("");
    }

    public static void printOrnateSeparator() {
        System.out.println("* ~~~~~ * ~~~~~ * ~~~~~ * ~~~~~ * ~~~~~ * ~~~~~ * ~~~~~ * ~~~~~ *");
    }

    /* * * * * * * * * * * * * * * * * * */
    /* * * *  DYNAMIC TEXT METHODS * * * */
    /* * * * * * * * * * * * * * * * * * */

    public static String createTextBody(String s, int desiredLength) {
        StringBuilder sb = new StringBuilder();
        String[] splitString = s.trim().toUpperCase().split(" ");
        int i;
        for (i = 0; i < splitString.length - 1; i++) {
            sb.append(splitString[i]);
            sb.append(" | ");
        }
        sb.append(splitString[splitString.length - 1]);
        String spacedString = sb.toString();
        sb.setLength(0);
        int blanksNeeded = desiredLength - spacedString.length() - 4;
        String paddingLeft = "";
        String paddingRight = "";
        for (i = 0; i <= blanksNeeded / 2; i++) {
            sb.append(" ");
        }
        paddingLeft = sb.toString();
        paddingRight = sb.toString();
        sb.setLength(0);
        String textBody = "||" + paddingLeft + "| " + spacedString + " |" + paddingRight + "||";
        if (spacedString.length() >= desiredLength) {
            textBody = "|| " + paddingLeft + spacedString + paddingRight + " ||";
        }
        return textBody;
    }

    public static void printMenuCreateParty(int size) {

        System.out.println();
        System.out.println("       ____________________________________");
        System.out.println("      / \\                                  \\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("      \\ /''''''''''''''''''''''''''''''''''/");
        System.out.println("       (                                   (");
        System.out.println("       )         1.Create a Warrior        )");
        System.out.println("       (         2.Create a Wizard         (");
        System.out.println("       )  3.Set Army Size and Autocomplete )");
        System.out.println("       (    4.Import Army From CSV File    (");
        System.out.println("       )      5.Confirm Army Completed     )");
        System.out.println("       (                                   (");
        System.out.println("       /\\''''''''''''''''''''''''''''''''''\\");
        System.out.println("   (O)===)><><><><><><><><><><><><><><><><><)==(O)");
        System.out.println("       \\/__________________________________/");
        if (size == 1)
            System.out.println("       " + size + " FIGHTER HAS ALREADY JOINED THE ARMY");
        if (size > 1)
            System.out.println("       " + size + " FIGHTERS HAVE ALREADY JOINED THE ARMY");
        System.out.println();
        System.out.println("CHOOSE WISELY:");
    }

    public static String createUpperBorder(int borderRepeats) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < borderRepeats) {
            sb.append("_.-=-.");
            i++;
        }
        sb.append("_");
        String upperBorder = sb.toString();
        sb.setLength(0);
        return upperBorder;
    }

    public static String createLowerBorder(int borderRepeats) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < borderRepeats) {
            sb.append("'-._.-");
            i++;
        }
        sb.append("'");
        String lowerBorder = sb.toString();
        sb.setLength(0);
        return lowerBorder;
    }

    public static String createInnerLine(int textLength) {
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        int lineLength = (textLength - 1) / 2;
        int i = 0;
        while (i < lineLength - 1) {
            sb.append("-+");
            i++;
        }
        sb.append("-*");
        String innerLine = sb.toString();
        sb.setLength(0);
        return innerLine;
    }

    public static void printGoodbye() throws InterruptedException {
        printFramedText("Good bye");
    }


    public static void printFramedText(String text) throws InterruptedException {
        String[] splitText = text.split(" ");
        int extraTextLength = ((splitText.length - 1) * 2) + 6;
        int minBodyLength = text.length() + extraTextLength;
        while (!(minBodyLength % 6 == 0)) {
            minBodyLength++;
        }
        minBodyLength +=2;

        String textBody = createTextBody(text, minBodyLength);

        int borderRepeats = textBody.length() / 6;
        String upperBorder = createUpperBorder(borderRepeats);
        String lowerBorder = createLowerBorder(borderRepeats);
        String innerLine = createInnerLine(textBody.length());

        System.out.println("");
        System.out.println(upperBorder);
        System.out.println(innerLine);
        System.out.println(textBody);
        System.out.println(innerLine);
        System.out.println(lowerBorder);
//        System.out.println("");
        // ralentizar la ejecución cuando salga un texto
        Thread.sleep(1000);
    }

    public static void printBoxedText(String text) throws InterruptedException {
        String[] splitText = text.split(" ");
        int extraTextLength = ((splitText.length - 1) * 2) + 4;
        int minBodyLength = text.length() + extraTextLength;
        while (!(minBodyLength % 6 == 0)) {
            minBodyLength++;
        }
        minBodyLength +=2;

        String textBody = createTextBody(text, minBodyLength);

        int borderRepeats = textBody.length() / 4;
        String innerLine = createInnerLine(textBody.length());

        System.out.println("");
        System.out.println(innerLine);
        System.out.println(textBody);
        System.out.println(innerLine);
        // ralentizar la ejecución cuando salga un texto
        Thread.sleep(1000);
    }


//  FRAMED TEXT
//  _.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._
//  *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*
//  ||     | DESPUES | DE | 12 | DUELOS | Y | 48 | TURNOS | ... |     ||
//  *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*
//  '-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'-._.-'

//  BOXED TEXT
//  *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*
//  ||     | DESPUES | DE | 12 | DUELOS | Y | 48 | TURNOS | ... |     ||
//  *-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*

}
