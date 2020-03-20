
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {
    Visitor visitor =  new Visitor("Pfano","Funie", "bad", "2020-03-19", timeOfVisits "21:31:12.119468", age "22");
    @Test
    void readNoFileFoundError() {
        Exception exception = assertThrows(Exception.class, () -> {
            visitor.load("No File Found");
        });
        String actualMessage = exception.getMessage();
        assertFalse(actualMessage.contains("The was a problem in writing to the file"));
    }

}