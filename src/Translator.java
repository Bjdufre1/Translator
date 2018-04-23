import java.io.*;

public class Translator {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
        while (br.readLine() != null){
            System.out.println("line");
        }
    }

}
