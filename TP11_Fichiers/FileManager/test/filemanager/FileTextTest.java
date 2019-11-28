package filemanager;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitaires sur la classe FileText.
 */
public class FileTextTest {
    
    @Test
    public void testAction1() {        
        FileText fileText = new FileText();
        assertEquals(19, fileText.action1("ressources/dont1.txt"));
        assertEquals(19, fileText.action1("ressources/dont2.txt"));
        assertEquals(-1, fileText.action1("ressources/../ressources/dont 3@#.)&.txt"));     
    }
    
    @Test
    public void testAction2() {
        FileText fileText = new FileText();
        assertEquals(-1, fileText.action2("ressources/dont1.txt"));
        assertEquals(-1, fileText.action2("ressources/dont2.txt"));
        assertEquals(150, fileText.action2("ressources/../ressources/dont 3@#.)&.txt")); 
    }
    
    @Test
    public void testAction3() {
        FileText fileText = new FileText();
        fileText.action3("ressources/write1/citation1.txt");
        fileText.action3("ressources/write2/citation2.txt");
        fileText.action3("ressources/write3/citation3.txt");
    }
    
}
