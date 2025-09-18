import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person p;

    @BeforeEach
    void setUp(){
        p = new Person ("0000A", "Jeel", "Patel", "Ms.", 2004);
    }


    @Test
    void testToString() {
        String s = p.toString();
        assertTrue(s.contains("Jeel"));
        assertTrue(s.contains("Patel"));
        assertTrue(s.contains("2004"));
        assertTrue(s.contains("0000A"));


    }

    @Test
    void setIDNum() {
        p.setIDNum("0000B");
        assertEquals("0000B", p.getIDNum());
    }

    @Test
    void setFirstName() {
        p.setFirstName("Pranjal");
        assertEquals("Pranjal", p.getFirstName());
    }

    @Test
    void setLastName() {
        p.setLastName("Patel");
        assertEquals("Patel", p.getLastName());
    }

    @Test
    void setTitle() {
        p.setTitle("Dr.");
        assertEquals("Dr.", p.getTitle());
    }

    @Test
    void setYOB() {
        p.setYOB(1999);
        assertEquals(1999, p.getYOB());
    }

    @Test
    void toCSVDataString() {
        String csv = p.toCSVDataString();
        assertEquals("0000A,Jeel,Patel,Ms.,2004", csv);
    }

    @Test
    void toJSONDataString() {
        String json = p.toJSONDataString();
        assertTrue(json.startsWith("{"));
        assertTrue(json.contains("\"IDNum\":\"0000A\""));
        assertTrue(json.contains("\"firstName\":\"Jeel\""));
        assertTrue(json.contains("\"lastName\":\"Patel\""));
        assertTrue(json.contains("\"title\":\"Ms.\""));
        assertTrue(json.contains("\"YOB\":2004"));
        assertTrue(json.endsWith("}"));

    }

    @Test
    void toXMLDataString() {
        String xml = p.toXMLDataString();
        assertTrue(xml.startsWith("<Person>"));
        assertTrue(xml.contains("<IDNum>0000A</IDNum>"));
        assertTrue(xml.contains("<firstName>Jeel</firstName>"));
        assertTrue(xml.contains("<lastName>Patel</lastName>"));
        assertTrue(xml.contains("<title>Ms.</title>"));
        assertTrue(xml.contains("<YOB>2004</YOB>"));
        assertTrue(xml.endsWith("</Person>"));

    }
    @Test
    void testEquals() {
        Person same = new Person("0000A", "Jeel", "Patel", "Ms.", 2004);
        Person diff = new Person("0000B", "Pranjal", "Pokharel", "Mr.", 2002);
        assertEquals(p, same);
        assertNotEquals(p, diff);
    }




}