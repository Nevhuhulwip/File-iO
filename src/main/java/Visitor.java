import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.lang.System.out;


public class Visitor {
    public String fullName,comments,dateOfVisit,timeOfVisits,nameOfPersonWhoAssistedTheVisitor;
    public int age;
   static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public Visitor(String fullName, String nameOfPersonWhoAssistedTheVisitor, String comments, String dateOfVisit, String timeOfVisits, int age ) {
        this.fullName = fullName;
        this.nameOfPersonWhoAssistedTheVisitor = nameOfPersonWhoAssistedTheVisitor;
        this.comments = comments;
        this.dateOfVisit = dateOfVisit;
        this.timeOfVisits = timeOfVisits;
        this.age = age;
    }

   public void save() throws Exception {

        String fileNameConvention = "visitor_" + fullName + ".txt";
        String fileName = fileNameConvention.toLowerCase().replace(" ", "_");

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Full Name :"+ fullName + "\n");
            fileWriter.write("Age :"+age + "\n");
            fileWriter.write("Date:"+LocalDate.now() + "\n");
            fileWriter.write("Time:"+LocalTime.now() + "\n");
            fileWriter.write("Comments : "+comments + "\n");
            fileWriter.write("Name Assistance : "+nameOfPersonWhoAssistedTheVisitor);
            logger.info("Saved Successfully!\n");
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new Exception("The was a problem in writing to the file");
        }
    }
   public void load(String name) throws Exception {
        String nameConvention = "visitor_" + name.toLowerCase().replace(" ", "_") + ".txt";
        final String[] fields = {"Full Name", "Age", "Date Of Visit", "Time Of Visit", "Comments", "Assistant Name"};


        String line;
        int Counter = 0;
        try(BufferedReader fileReader = new BufferedReader(new FileReader(nameConvention))){
            while ((line = fileReader.readLine()) != null ){
                out.printf("%-11s \t%s%n", fields[Counter], line);
                Counter++;
            }
            logger.info("Read Successfully!\n");
        }catch (Exception e){

            logger.error(e.getMessage());
            throw new Exception("File not found");
        }
    }


}


