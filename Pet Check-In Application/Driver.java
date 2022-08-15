import java.util.ArrayList;
import java.util.Scanner;


public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)
    public static int counter = 0;
    //create list of eligible monkey species
    public static String [] monkeySpeciesAvail = {"Capuchin", "Guenon", "Macaque","Marmoset","Squirrel monkey","Tamarin"};

    //monkey species functions
    public static boolean checkMonkeySpecies(String speciesInput) {
        boolean output = false;
        for (int i = 0; i < monkeySpeciesAvail.length; ++i) {
            if (monkeySpeciesAvail[i].equals(speciesInput)) {
                output = true;
                break;
            }
        }
        return output;
    }

    public static void listMonkeySpecies () {
        for (int i = 0; i < monkeySpeciesAvail.length; ++i) {
            System.out.println(monkeySpeciesAvail[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput;

        initializeDogList();
        initializeMonkeyList();

        userInput = "Go";
        while( !userInput.equals("q") ) {
        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        displayMenu();        
        userInput = scnr.nextLine();

        if (userInput.equals("1")) {
            intakeNewDog();
        }
        else if (userInput.equals("2")) {
            intakeNewMonkey();
        }
        else if (userInput.equals("3")) {
            reserveAnimal();
        }
        else if (userInput.equals("4")) {
            String Dog = "Dog";
            printAnimals(Dog);
        }
        else if (userInput.equals("5")) {
            String Monkey = "Monkey";
            printAnimals(Monkey);
        }
        else if (userInput.equals("6")) {
            String Available = "Available";
            printAnimals(Available);
        }
        else if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
        !userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && !userInput.equals("q")) {
            System.out.println("Please make a selection from the menu.");
            displayMenu();
            userInput = scnr.next();
        }
        }
        scnr.close();
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        //Dog(name, breed, gender, age, weight, acquisition date, acquisition country, training status, reserved, inservice country)
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in-service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        //Monkey(name, monkey species, gender, age, weight, tail length, height, body length, acquisition date, acquisition country, training status, Bool reserved, in service country) ALL STRINGS
        //Species Capuchin, Guenon, Macque, Marmoset, Squirrel monkey, Tamarin
        Monkey monkey1 = new Monkey("Boobah", "Capuchin", "Male", "5", "19.8", "3.4", "2.33", "2.12", "05-09-2019", "United States", "Phase II", false, "United States");
        Monkey monkey2 = new Monkey("Horheuy", "Guenon", "Female", "3", "5.3","23.5" , "23.45", "23.52" , "02-04-2020", "Chile", "Phase III", true, "Canada");
        Monkey monkey3 = new Monkey("Yayeuh", "Tamarin", "Male", "6", "7.9", "5.23", "6.34", "4.56", "05-20-2019", "Canada", "in-service", false, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog() {
        //test adding multiple dogs, make sure newDog is non-issue name
        //Dog(name, breed, gender, age, weight, acquisition date, acquisition country, training status, reserved, inservice country)
        System.out.println("What is the dog's name?");
        Scanner scnr = new Scanner(System.in);
        String name = scnr.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dogs breed?");
        String breed = scnr.nextLine();

        System.out.println("What is the dogs gender (Male/Female)?");
        String gender = scnr.nextLine();
        while (!gender.equals("Male") && !gender.equals("Female")) {
            System.out.println("You did not enter Male or Female. Try Again.");
            System.out.println("What is the dogs gender (Male/Female)?");
            gender = scnr.nextLine(); 
        }

        System.out.println("What is the dogs age (0-30)?");
        String age = scnr.nextLine();
        while(Double.parseDouble(age) < 1 || Double.parseDouble(age) > 31) {
            System.out.println("Age is not between 0 and 30. Try Again.");
            System.out.println("What is the dogs age (0-30)?");
            age = scnr.nextLine();            
        }

        System.out.println("What is the dogs weight (00.00)?");
        String weight = scnr.nextLine();
        while(Double.parseDouble(weight) < 00.01 || Double.parseDouble(weight) > 99.98) {
            System.out.println("The weight was not between 00.01 and 99.98. Try Again.");
            System.out.println("What is the dogs weight (00.00)?");
            weight = scnr.nextLine();
        }

        System.out.println("What is the dogs acquisition date (mm-dd-yyyy)?");
        String acquisitionDate = scnr.nextLine();
        while (acquisitionDate.length() != 10) {
            System.out.println("Date entered was invalid. Use mm-dd-yyyy format.");
            System.out.println("What is the dogs acquisition date (mm-dd-yyyy)?");
            acquisitionDate = scnr.nextLine();            
        }

        System.out.println("What is the dogs acquisition country?");
        String acquisitionCountry = scnr.nextLine();

        System.out.println("What is the dogs training status (Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, farm)?");
        String trainingStatus = scnr.nextLine();
        if (!trainingStatus.equals("Phase I") && !trainingStatus.equals("Phase II") && !trainingStatus.equals("Phase III") && 
        !trainingStatus.equals("Phase IV") && !trainingStatus.equals("Phase V") && !trainingStatus.equals("in-service") && 
        !trainingStatus.equals("farm") ) {
            System.out.println("Invalid input. Try again.");
            System.out.println("What is the dogs training status (Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, farm)?");
            trainingStatus = scnr.nextLine();
        }

        boolean reserved = false;
        System.out.println("Is the dog reserved? (Yes/No)");
        String reservedInput = scnr.nextLine();
        while (!reservedInput.equals("Yes") && !reservedInput.equals("No")) {
            System.out.println("Is the dog reserved? (Yes/No)");
            reservedInput = scnr.nextLine();
        }

        if (reservedInput.equals("Yes")) {
            reserved = true;
        }

        else if (reservedInput.equals("No")) {
            reserved = false;
        }

        System.out.println("What is the dog's in service country?");
        String serviceCountry = scnr.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, serviceCountry); 

        dogList.add(newDog);

    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey() {
            //Monkey(name, species, gender, age, weight, taillengthinput, height input, bodylength input, acquisition date, acquisitionCountry, trainingStatus, reserved Bool, inservicecountry) ALL STRINGS
            //Species Capuchin, Guenon, Macque, Marmoset, Squirrel monkey, Tamarin
            Scanner scnr = new Scanner(System.in);
            System.out.println("What is the monkey's name?");
            String name = scnr.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            System.out.print("What is the monkeys species? (");
            for (int i = 0; i < monkeySpeciesAvail.length - 1; ++i) {
                System.out.print(monkeySpeciesAvail[i] + ", ");
            }
            System.out.println(monkeySpeciesAvail[monkeySpeciesAvail.length - 1] + ")");
            String monkeySpecies = scnr.nextLine();
            while (!checkMonkeySpecies(monkeySpecies)) {
                System.out.println("This is not a valid monkey species. Valid species are listed below.");
                listMonkeySpecies();                
                System.out.println("What is the monkeys species?");
                monkeySpecies = scnr.nextLine();
            }

    
            System.out.println("What is the monkeys gender (Male/Female)?");
            String gender = scnr.nextLine();
            while (!gender.equals("Male") && !gender.equals("Female")) {
                System.out.println("You did not enter Male or Female. Try Again.");
                System.out.println("What is the dogs gender (Male/Female)?");
                gender = scnr.nextLine(); 
            }
    
            System.out.println("What is the monkeys age (0-30)?");
            String age = scnr.nextLine();
            while(Double.parseDouble(age) < 1 || Double.parseDouble(age) > 31) {
                System.out.println("Age is not between 0 and 30. Try Again.");
                System.out.println("What is the monkeys age (0-30)?");
                age = scnr.nextLine();            
            }
    
            System.out.println("What is the monkeys weight (00.00)?");
            String weight = scnr.nextLine();
            while(Double.parseDouble(weight) < 00.01 || Double.parseDouble(weight) > 99.98) {
                System.out.println("The weight was not between 00.01 and 99.98. Try Again.");
                System.out.println("What is the monkeys weight (00.00)?");
                weight = scnr.nextLine();
            }
            
            //tailLengthInput
            System.out.println("What is the monkeys tail length (00.00)?");
            String monkeyTailLength = scnr.nextLine();
            while(Double.parseDouble(monkeyTailLength) < 00.01 || Double.parseDouble(monkeyTailLength) > 99.98) {
                System.out.println("The tail length was not between 00.01 and 99.98. Try Again.");
                System.out.println("What is the monkeys tail length (00.00)?");
                monkeyTailLength = scnr.nextLine();
            }

            //monkeyHeightinput
            System.out.println("What is the monkeys height (00.00)?");
            String monkeyHeight = scnr.nextLine();
            while(Double.parseDouble(monkeyHeight) < 00.01 || Double.parseDouble(monkeyHeight) > 99.98) {
                System.out.println("The height was not between 00.01 and 99.98. Try Again.");
                System.out.println("What is the monkeys height (00.00)?");
                monkeyHeight = scnr.nextLine();
            }
            //bodyLengthInput
            System.out.println("What is the monkeys body length (00.00)?");
            String monkeyBodyLength = scnr.nextLine();
            while(Double.parseDouble(monkeyBodyLength) < 00.01 || Double.parseDouble(monkeyBodyLength) > 99.98) {
                System.out.println("The monkeys body length was not between 00.01 and 99.98. Try Again.");
                System.out.println("What is the monkeys body length (00.00)?");
                monkeyBodyLength = scnr.nextLine();
            }

            System.out.println("What is the monkeys acquisition date (mm-dd-yyyy)?");
            String acquisitionDate = scnr.nextLine();
            while (acquisitionDate.length() != 10) {
                System.out.println("Date entered was invalid. Use mm-dd-yyyy format.");
                System.out.println("What is the monkeys acquisition date (mm-dd-yyyy)?");
                acquisitionDate = scnr.nextLine();            
            }
    
            System.out.println("What is the monkeys acquisition country?");
            String acquisitionCountry = scnr.nextLine();
    
            System.out.println("What is the monkeys training status (Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, farm)?");
            String trainingStatus = scnr.nextLine();
            if (!trainingStatus.equals("Phase I") && !trainingStatus.equals("Phase II") && !trainingStatus.equals("Phase III") && 
            !trainingStatus.equals("Phase IV") && !trainingStatus.equals("Phase V") && !trainingStatus.equals("in-service") && 
            !trainingStatus.equals("farm") ) {
                System.out.println("Invalid input. Try again.");
                System.out.println("What is the monkeys training status (Phase I, Phase II, Phase III, Phase IV, Phase V, in-service, farm)?");
                trainingStatus = scnr.nextLine();
            }
    
            boolean reserved = false;
            System.out.println("Is the monkey reserved? (Yes/No)");
            String reservedInput = scnr.nextLine();
            while (!reservedInput.equals("Yes") && !reservedInput.equals("No")) {
                System.out.println("Is the monkey reserved? (Yes/No)");
                reservedInput = scnr.nextLine();
            }
    
            if (reservedInput.equals("Yes")) {
                reserved = true;
            }
    
            else if (reservedInput.equals("No")) {
                reserved = false;
            }
    
            System.out.println("What is the monkeys in-service country?");
            String serviceCountry = scnr.nextLine();
    
            Monkey newMonkey = new Monkey(name, monkeySpecies, gender, age, weight, monkeyTailLength, monkeyHeight, monkeyBodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, serviceCountry); 
    
            monkeyList.add(newMonkey);
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal() {
            Scanner scnr = new Scanner(System.in);

            System.out.println("What type of animal are you reserving? (Dog or Monkey)");
            String animalSpecies = scnr.next();

            //validate
            while (!animalSpecies.equals("Monkey") && !animalSpecies.equals("Dog")) {
                System.out.println("Invalid. Please select Dog or Monkey");
                animalSpecies = scnr.next();
            }
            if (animalSpecies.equals("Dog")) {
                System.out.println("Dogs available are below:");
                for(Dog dog: dogList) {
                    if (dog.getReserved()) {
                    System.out.println("Name: " + dog.getName() + " | Service Location: " + dog.getInServiceLocation());
                    }
                }
                System.out.println("Which dog would you like to reserve?");
                String reserveName = scnr.next();
                    counter = 0;
                    for(Dog dog: dogList) {
                        if (dog.getName().equals(reserveName)) {
                            dog.setReserved(true);
                            ++counter;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("No dog by that name in system. Please try again");
                        scnr.close();
                        return;
                    }
            System.out.println("Dog " + reserveName + " has been reserved!");
            return;
            }

            if (animalSpecies.equals("Monkey")) {
                System.out.println("Monkeys available are below");
                for(Monkey monkey: monkeyList) {
                    if (monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName() + " | Service Location: " + monkey.getInServiceLocation());
                    }
                }
                System.out.println("Which monkey would you like to reserve?");
                String reserveName = scnr.next();
                    //error check 
                    counter = 0;
                    for(Monkey monkey: monkeyList) {
                        if (monkey.getName().equalsIgnoreCase(reserveName)) {
                            monkey.setReserved(true);
                            ++counter;
                        }
                    }
                    if (counter == 0) {
                        System.out.println ("No monkey by that name in system. Please try again.");
                        scnr.close();
                        return;
                    }
            System.out.println("Monkey " + reserveName + " has been reserved!");
            return;
            }
        }

        public static void printAnimals(String userSelection) {
            if (userSelection.equals("Dog")) {
                for(Dog dog: dogList) {
                    System.out.println("Name: " + dog.getName() + " | Status: " + dog.getTrainingStatus() +
                     " | Acquisition Country: " + dog.getAcquisitionLocation() + "Reserve Status: " + dog.getReserved());
                }                
            }

            else if (userSelection.equals("Monkey")) {
                for(Monkey monkey: monkeyList) {
                    System.out.println("Name: " + monkey.getName() + " | Status: " + monkey.getTrainingStatus() +
                     " | Acquisition Country: " + monkey.getAcquisitionLocation() + " | Reserve Status: " + monkey.getReserved());
                } 
            }

            else if (userSelection.equals("Available")) {
                System.out.println("Available Dogs");
                for(Dog dog: dogList) {
                    if(dog.getTrainingStatus().equals("in-service") && !dog.getReserved()) {
                    System.out.println("Name: " + dog.getName() + " | Status: " + dog.getTrainingStatus() + 
                    " | Acquisition Country: " + dog.getAcquisitionLocation() + " | Reserve Status: " + dog.getReserved());
                    }
                }                  
                
                System.out.println("Available Monkeys");
                for(Monkey monkey: monkeyList) {
                    if(monkey.getTrainingStatus().equals("in-service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName() + " | Status: " + monkey.getTrainingStatus() + 
                    " | Acquisition Country: " + monkey.getAcquisitionLocation() + "Reserve Status: " + monkey.getReserved());
                    }
                }                
            }
        }
        
}

