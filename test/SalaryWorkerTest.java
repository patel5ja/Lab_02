import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SalaryWorkerTest {

    private SalaryWorker sw;

    @BeforeEach
    void setUp() {
        sw = new SalaryWorker("S001", "Amit", "Patel", "Mr.", 1976, 25.0, 52000.0);
    }

    @Test
    void setAnnualSalary() {
        sw.setAnnualSalary(60000.0);
        assertEquals(60000.0 / 52.0, sw.calculateWeeklyPay(40), 0.001);
    }

    @Test
    void calculateWeeklyPay() {
        double weekly = sw.calculateWeeklyPay(40);
        assertEquals(52000.0 / 52.0, weekly, 0.001);
    }

    @Test
    void displayWeeklyPay() {
        SalaryWorker sw = new SalaryWorker("S001", "Amit", "Patel", "Mr.", 1976, 25.0, 52000.0);
        sw.displayWeeklyPay(40);
    }

    @Test
    void testToString() {
        String s = sw.toString();
        assertTrue(s.contains("Amit"));
        assertTrue(s.contains("Patel"));
        assertTrue(s.contains("1976"));
        assertTrue(s.contains("52000"));
    }

    @Test
    void toCSVDataString() {
        String csv = sw.toCSVDataString();
        assertTrue(csv.contains("S001"));
        assertTrue(csv.contains("Amit"));
        assertTrue(csv.contains("Patel"));
        assertTrue(csv.contains("1976"));
        assertTrue(csv.contains("52000.0"));
    }

    @Test
    void toXMLDataString() {
        String xml = sw.toXMLDataString();
        assertTrue(xml.startsWith("<SalaryWorker>"));
        assertTrue(xml.contains("<IDNum>S001</IDNum>"));
        assertTrue(xml.contains("<firstName>Amit</firstName>"));
        assertTrue(xml.contains("<lastName>Patel</lastName>"));
        assertTrue(xml.contains("<title>Mr.</title>"));
        assertTrue(xml.contains("<YOB>1976</YOB>"));
        assertTrue(xml.contains("<annualSalary>52000.0</annualSalary>"));
        assertTrue(xml.endsWith("</SalaryWorker>"));
    }

    @Test
    void toJSONDataString() {
        String json = sw.toJSONDataString();
        assertTrue(json.startsWith("{"));
        assertTrue(json.contains("\"IDNum\":\"S001\""));
        assertTrue(json.contains("\"firstName\":\"Amit\""));
        assertTrue(json.contains("\"lastName\":\"Patel\""));
        assertTrue(json.contains("\"title\":\"Mr.\""));
        assertTrue(json.contains("\"YOB\":1976"));
        assertTrue(json.contains("\"annualSalary\":52000.0"));
        assertTrue(json.endsWith("}"));
    }
}