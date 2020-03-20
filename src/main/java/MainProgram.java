
import java.util.Scanner;


public class MainProgram {

    public static void main(String[] args) throws Exception {


        Scanner inputReader = new Scanner(System.in);

        System.out.println("Enter Full Name : ");
        String fullName = inputReader.nextLine();

        System.out.println("What is your Assistant name : ");
        String nameOfPersonWhoAssistedTheVisitor = inputReader.nextLine();

        System.out.println("Comments : ");
        String comments = inputReader.nextLine();

        String dateOfVisit = "";

        String timeOfVisits = "";
        System.out.println("How old are you : ");
        int age = inputReader.nextInt();

        Visitor V = new Visitor(fullName,nameOfPersonWhoAssistedTheVisitor,comments,dateOfVisit,timeOfVisits, age);


        V.save();
        

        V.load(fullName);
    }
}