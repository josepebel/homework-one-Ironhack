package classes;

import java.io.*;
import java.util.*;

public class Party {
    private String name;  // Posibilidad de dar un nombre al equipo.
    private ArrayList<Character> characters;
    private int size;

    //Constructor para incluir de forma manual los caracteres
    public Party(String name) {
        this.name = name;
        this.characters = new ArrayList<>();
        this.size = 0;
        //createParty();
    }

    //Constructor para incluir de forma manual los caracteres
    public Party(String name, ArrayList<Character> characters) {
        this.name = name;
        this.characters = characters;
        this.size = characters.size();
    }

    public void createParty() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        characters = new ArrayList<>();

        int comando;
        boolean isAFighterCreated = false;
        do {
            //Options: 1-Create Warrior 2-Create Wizard 3-Random autocomplete 4-Import party from CSV file 5-Confirm army
            PrintText.printMenuCreateParty(size);

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
            switch (comando) {
                case 1:
                    checkAndAddToParty(createWarrior());
                    isAFighterCreated = true;
                    break;
                case 2:
                    checkAndAddToParty(createWizard());
                    isAFighterCreated = true;
                    break;
                case 3:
                    do {
                        int size = 0;
                        PrintText.setArmyTotalSize();
                        try {
                            String lectorComando = scanner.nextLine();
                            size = Integer.parseInt(lectorComando);
                        } catch (InputMismatchException e){
                            size = 0;
                            //scanner.nextLine();
                        }
                        catch (NumberFormatException e){
                            size = 0;
                            //scanner.nextLine();
                        }
                        if (size > 0){
                            // bucle para llamar tantas veces a la generación de character Random como sea necesario
                            int i = characters.size();
                            while (i < size) {
                                checkAndAddToParty(createRandom());
                                i++;
                            }
                        }
                    } while (size < 1);
                    break;
                case 4:
                    listPartyFileNames();
                    
                    System.out.println("Enter CSV file name: ");
                    String fileName = scanner.nextLine(); //introducimos el nombre del fichero (p.ej. party_1.csv)
                    fileName = "src\\csv\\" + fileName;

                    if (!importParty(fileName))
                        comando=0;
                    break;
                case 5:
                    if(!isAFighterCreated) { //No se ha creado previamente ni un warrior ni un wizard y por tanto el army está vacía
                        System.out.println("Please, create a Warrior or a Wizard before confirming the army");
                        comando=0;
                    } else {
                        System.out.println("Army completed and ready to fight!");
                    }
                    break;

                default:
                    PrintText.printWrongOption();
                    comando=0;
            }
            
        } while (comando!=3 && comando!=4 && comando !=5); // en cualquiera de los comandos 3 y 4 se acaba la creación del ejercito

        if (comando != 4)
            printArmyCompleted();

    }

    // Métodos para crear warriors y wizzards por pantalla
    private Character createWarrior() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PrintText.askWarriorName();
        String name= scanner.nextLine();
        PrintText.askWarriorHp();
        int hp = 0;
        try {
            String lectorComando = scanner.nextLine();
            hp = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            hp = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            hp = 0;
            //scanner.nextLine();
        }
        PrintText.askWarriorStamina();
        int stamina = 0;
        try {
            String lectorComando = scanner.nextLine();
            stamina = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            stamina = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            stamina = 0;
            //scanner.nextLine();
        }
        PrintText.askWarriorStrength();
        int strength = 0;
        try {
            String lectorComando = scanner.nextLine();
            strength = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            strength = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            strength = 0;
            //scanner.nextLine();
        }
        Character warrior = new Warrior(name, hp, stamina, strength);
        PrintText.printBoxedText("Created: " + warrior.toString());
        return warrior;
    }

    private Character createWizard() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PrintText.askWizardName();
        String name= scanner.nextLine();
        PrintText.askWizardHp();
        int hp = 0;
        try {
            String lectorComando = scanner.nextLine();
            hp = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            hp = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            hp = 0;
            //scanner.nextLine();
        }
        PrintText.askWizardMana();
        int mana = 0;
        try {
            String lectorComando = scanner.nextLine();
            mana = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            mana = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            mana = 0;
            //scanner.nextLine();
        }
        PrintText.askWizardIntelligence();
        int intelligence = 0;
        try {
            String lectorComando = scanner.nextLine();
            intelligence = Integer.parseInt(lectorComando);
        } catch (InputMismatchException e){
            intelligence = 0;
            //scanner.nextLine();
        }
        catch (NumberFormatException e){
            intelligence = 0;
            //scanner.nextLine();
        }
        Character wizard = new Wizard(name, hp, mana, intelligence);
        PrintText.printBoxedText("Created: " + wizard.toString());
        return wizard;
    }

    private Character createRandom(){

        Character randomCharacter;
        //System.out.println("Generate automatic Warrior or Wizzard");
        int randomMethod = new Random().nextInt(2);

        if(randomMethod == 0){
            randomCharacter = Wizard.randomWizard();
        } else{
            randomCharacter = Warrior.randomWarrior();
        }
        //System.out.println("Created: " + randomCharacter);
        return randomCharacter;
    }
    
    //Para mostrar los csv disponibles para importar por pantalla
    public void listPartyFileNames() {
        File[] fileList = new File("src\\csv\\").listFiles(); //directorio
        if (fileList.length > 0) {
            System.out.println("Showing available files...");
            for (int i = 0; i < fileList.length; i++) {
                System.out.println(fileList[i].getName());
            }
        } else {
            System.out.println("No files available");
        }
    }
    
    public boolean importParty(String fileName) throws InterruptedException {
        List<List<String>> partyCsv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                partyCsv.add(Arrays.asList(values));
            }
        } catch (IOException e){
            System.err.println("Error! " + e.getMessage());
            //e.getStackTrace();
            return false;
        }

        if (partyCsv == null) {
            PrintText.printErrorImport();
            return false;
        }
        else {
            partyCsv.remove(0); //eliminamos la primera linea (headers)

            //Cada character es una linea del fichero csv
            for (List<String> characterCSV : partyCsv) {
                Character character = null;

                //Atributos comunes a magos y guerreros
                String name = characterCSV.get(0); //name: columna 1
                int hp = Integer.parseInt(characterCSV.get(1)); //hp: columna 2

                //Los guerreros tendrán completa la casilla correspondiente al atributo stamina (columna 3)
                if (!characterCSV.get(2).equals("0")) {
                    int stamina = Integer.parseInt(characterCSV.get(2)); //stamina: columna 3
                    int strength = Integer.parseInt(characterCSV.get(3)); //strength: columna 4
                    character = new Warrior(name, hp, stamina, strength);
                }

                //Los magos tendrán completa la casilla correspondiente al atributo mana (columna 5)
                if (!characterCSV.get(4).equals("0")) {
                    int mana = Integer.parseInt(characterCSV.get(4)); //mana: columna 5
                    int intelligence = Integer.parseInt(characterCSV.get(5)); //intelligence: columna 6
                    character = new Wizard(name, hp, mana, intelligence);
                }
                checkAndAddToParty(character);

            }

            printArmyImported();
            return true;
        }

    }

    private void checkAndAddToParty(Character character) {
        //Se comprueba si el nombre del character no existe ya
        while(!checkValidName(character)){
            character.setName(character.getName() + " Jr"); //Si existe, se entra en el bucle para añadir Jr tanto
            // como sea necesario
        }

        addToParty(character);
    }

    private boolean checkValidName(Character character) {

        for (Character charParty : characters) {
            if (character.getName().equals(charParty.getName()))
                return false;
        }
        return true;
    }

    public void addToParty(Character character){
        this.size ++;
        characters.add(character);
    }

    public boolean hasAliveCharacters(){
        return this.characters.size() > 0;
    }

    public Character getCharacter(String name){
        Character characterToGet = null;

        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().toUpperCase().equals(name.toUpperCase())){
                characterToGet = characters.get(i);
            }
        }

        return characterToGet;
    }

    public void exportParty() throws InterruptedException {
        PrintText.printFramedText(getName() + " is exported");

        List<String> header = Arrays.asList("name", "hp", "stamina", "strength", "mana", "intelligence");

        List<List<String>> charactersCsv = new ArrayList<>();
        charactersCsv.add(header);
        List<String> characterCsv = null; //lista de String que representa a cada character

        ArrayList<Character> characters = getCharacters();

        for(int i = 0; i < characters.size(); i++){
            Character character = characters.get(i);

            if(character instanceof Warrior){
                Warrior warrior = (Warrior) character;
                characterCsv = Arrays.asList(warrior.getName(), String.valueOf(warrior.getHp()),
                        String.valueOf(warrior.getStamina()), String.valueOf(warrior.getStrength()), "0", "0");
            }
            if(character instanceof Wizard){
                Wizard wizard = (Wizard) character;
                characterCsv = Arrays.asList(wizard.getName(), String.valueOf(wizard.getHp()),
                        "0", "0", String.valueOf(wizard.getMana()), String.valueOf(wizard.getIntelligence()));
            }
            charactersCsv.add(characterCsv);
        }

        //para no sobreescribir los ficheros existentes, crearemos unos nuevos, sumándole 1 al id
        //int id = 1;
        //File[] fileList = new File("src\\csv\\").listFiles(); //directorio
        //if(fileList.length > 0){
        //    List<Integer> ids = new ArrayList<>(); //lista de ids de los ficheros (x en party_x.csv)
        //    for (int i = 0; i < fileList.length; i++) {
        //        ids.add(Integer.parseInt(fileList[i].getName().split("_|\\.")[1])); //id
        //    }
        //    Collections.sort(ids); //ordenamos los ids
        //    id = ids.get(ids.size() - 1) + 1; //sumamos 1 al mayor id
        //}

        //Cambiamos el "party" por el nombre del ejército que hayamos creado
        //String filename = "src\\csv\\party_" + id + ".csv";
        String fileName = "src\\csv\\" + getName() + ".csv";
        try (FileWriter writer = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(writer)) {
            String charactersCsvString = "";
            for(List<String> characterCsvAux: charactersCsv){
                charactersCsvString += String.join(";", characterCsvAux);
                charactersCsvString += "\n";
            }
            bw.write(charactersCsvString);
        } catch(IOException e) {
            System.err.println("Error!");
            e.printStackTrace();
        }
    }

    // Método para eliminar personaje de la party
    public void removeCharacter(Character character){
        this.characters.remove(character);
        this.size--;
    }

    public Character pickFighter() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int comando;
        Character fighter = null;

        do {
            PrintText.printOptionsPickFighter(getName());
//            System.out.println("Choose a Fighter from Army " + getName() + ":");
//            System.out.println("1. Choose by Fighter Name");
//            System.out.println("2. Choose Random Fighter");
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
                    PrintText.printFramedText(getName() +  " Fighters");
                    printCharactersInfo();
                    PrintText.printPickFightersName();
                    String fighterName = scanner.nextLine();
                    fighter = getCharacter(fighterName);
                    if (fighter == null){
                        PrintText.printWrongFigtherName();
                    } else{
                        PrintText.printBoxedText(fighter.getName() + " is the chosen one for " + getName() + " army");
                    }
                    break;
                case 2:
                    int rand = random.nextInt(getSize());
                    fighter = getCharacters().get(rand);
                    PrintText.printBoxedText(fighter.getName() + " is the chosen one for " + getName() + " army");
//                    System.out.println(fighter.getName() + " is the chosen one!");
                    break;
                default:
                    PrintText.printWrongOption();

                    break;
            }
        } while (fighter == null);
        return fighter;
    }


    /////////////////////////////
    ////////// PRINTS ///////////
    /////////////////////////////

    private void printArmyCompleted() throws InterruptedException {
        PrintText.printFramedText(getName() +  " Army completed:");
        printCharactersInfo();
    }

    private void printArmyImported() throws InterruptedException {
        PrintText.printFramedText(getName() +  " Army imported:");
        printCharactersInfo();
    }

    public void printCharactersInfo() throws InterruptedException {
        for (Character character : this.characters) {
            PrintText.printBoxedText(character.toString());
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Character character : this.characters) {
            result +=character.toString() + "\n";
        }

        return result;
    }

    /////////////////////////////
    ///// GETTERS / SETTERS /////
    /////////////////////////////

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

