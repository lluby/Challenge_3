import org.example.FileBinar;
import org.example.Struk;
import org.junit.jupiter.api.Test;

import java.io.*;


public class TestMain {

    @Test
    public void testTampilkanMenu() {
        String input = "1";
        InputStream Input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testPilihMenu(){
        String input = "3";
        InputStream Input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testPesandanBayar(){
        String input = "99";
        InputStream Input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testMasukkanJumlah(){
        String input = "5";
        InputStream Input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testBayar(){
        int totalPrice = 100;
        Struk struk = new Struk(totalPrice);
        FileBinar file = new FileBinar("struk.txt");
        final PrintStream originalOut = System.out;
        OutputStream outputStream = System.out;
        System.setOut(new PrintStream(outputStream));
        System.setOut(originalOut);
    }

}
