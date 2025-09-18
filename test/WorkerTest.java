import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    private Worker w;

    @BeforeEach
    void setUp()
    {
        w = new Worker("001", "Jeel", "Patel", "Ms.", 2004, 35.0);
    }

    @Test
    void setHourlyPayRate() {
        Worker w = new Worker("W001", "Jeel", "Patel", "Ms.", 2004, 20.0);
        w.setHourlyPayRate(25.0);
        assertEquals(1000.0, w.calculateWeeklyPay(40), 0.001);

    }

    @Test
    void calculateWeeklyPay() {
        Worker w = new Worker("W002", "Pranjal", "Pokharel", "Mr.", 2002, 30.0);
        double pay = w.calculateWeeklyPay(45);
        assertEquals(1425.0, pay, 0.001);
    }

    @Test
    void displayWeeklyPay() {
        Worker w = new Worker("W003", "Jigna", "Patel", "Mrs.", 1983, 22.0);
        w.displayWeeklyPay(40);

    }


    @Test
    void testToString() {
        String s = w.toString();
        assertTrue(s.contains("Jeel"));
        assertTrue(s.contains("Patel"));
        assertTrue(s.contains("2004"));
        assertTrue(s.contains("001"));
        assertTrue(s.contains("hourly"));
    }

    @Test
    void toCSVDataString() {
        String csv = w.toCSVDataString();
        assertEquals("001,Jeel,Patel,Ms.,2004,35.0", csv);
    }

    @Test
    void toXMLDataString() {
        String xml = w.toXMLDataString();
        assertTrue(xml.startsWith("<Worker>"));
        assertTrue(xml.contains("<IDNum>001</IDNum>"));
        assertTrue(xml.contains("<firstName>Jeel</firstName>"));
        assertTrue(xml.contains("<lastName>Patel</lastName>"));
        assertTrue(xml.contains("<title>Ms.</title>"));
        assertTrue(xml.contains("<YOB>2004</YOB>"));
        assertTrue(xml.contains("<hourlyPayRate>35.0</hourlyPayRate>"));
        assertTrue(xml.endsWith("</Worker>"));
    }

    @Test
    void toJSONDataString() {
        String json = w.toJSONDataString();
        assertTrue(json.startsWith("{"));
        assertTrue(json.contains("\"IDNum\":\"001\""));
        assertTrue(json.contains("\"firstName\":\"Jeel\""));
        assertTrue(json.contains("\"lastName\":\"Patel\""));
        assertTrue(json.contains("\"title\":\"Ms.\""));
        assertTrue(json.contains("\"YOB\":2004"));
        assertTrue(json.contains("\"hourlyPayRate\":35.0"));
        assertTrue(json.endsWith("}"));
    }
}