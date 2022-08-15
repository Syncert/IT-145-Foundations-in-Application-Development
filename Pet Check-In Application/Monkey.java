import java.util.Scanner;  
import java.lang.String; 

public class Monkey extends RescueAnimal {
    /*In a new Java file, create the Monkey class, using the specification document as a guide. The Monkey class must do the following:
Inherit from the RescueAnimal class.
Implement all attributes to meet the specifications.
Include a constructor. You may use a default constructor. To score “exemplary” on this criterion, you must include the more detailed constructor that takes all values for the attributes and sets them. Refer to the constructor in the Dog class for an example.
Include accessors and mutators for all implemented attributes.
    */
    //need tail length, height, body length, species
    /*rescue animal attributes
     private String name;
    private String animalType;
    private String gender;
    private String age;
    private String weight;
    private String acquisitionDate;
    private String acquisitionCountry;
	private String trainingStatus;
    private boolean reserved;
	private String inServiceCountry; */

    //create list of eligible monkey species
    String monkeyTailLength; 
    String monkeyHeight;
    String monkeyBodyLength;
    String monkeySpecies;
    Scanner scnr = new Scanner(System.in);
    int i;

//constructor
    public Monkey(String name, String monkeySpecies, String gender, String age,
    String weight,String monkeyTailLengthInput, String monkeyHeightInput, 
    String monkeyBodyLengthInput, String acquisitionDate, 
    String acquisitionCountry,String trainingStatus, boolean reserved, 
    String inServiceCountry) {
        setName(name);
        setMonkeySpecies(monkeySpecies);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setMonkeyTailLength(monkeyTailLengthInput);
        setMonkeyHeight(monkeyHeightInput);
        setMonkeyBodyLength(monkeyBodyLengthInput);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    //accessors and mutators

    //tail length , height, body length, species

    public void setMonkeyTailLength(String tailLengthInput) {
        monkeyTailLength = tailLengthInput;
    }
    public String getMonkeyTailLength() {
        return monkeyTailLength;
    }

    public void setMonkeyHeight(String heightInput) {
        monkeyHeight = heightInput;
    }
    public String getMonkeyHeight() {
        return monkeyHeight;
    }
    public void setMonkeyBodyLength(String bodyLengthInput) {
        monkeyBodyLength = bodyLengthInput;
    }
    public String getMonkeyBodyLength() {
        return monkeyBodyLength;
    }
    public String getMonkeySpecies () {
        return monkeySpecies; 
    }

    public void setMonkeySpecies(String speciesInput) {
        monkeySpecies = speciesInput;
    }

}