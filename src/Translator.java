import java.io.*;

public class Translator {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
        String line = "";
        //ignoring first line that will always be
        br.readLine();
        bw.write("public class translated {\n");
        bw.write("public static void main(String[] args) {\n");
        bw.flush();
        while ((line = br.readLine()) != null){
            if(line.length() > 3) {
                String beginning = line.substring(0,3);
                if (beginning.equals("int")) {
                    bw.write(line + "\n");
                    bw.flush();
                }
                if (beginning.equals("if(")) {
                    bw.write(line + "\n");
                    bw.flush();
                }
                if(beginning.equals("pnt")){
                    bw.write("System.out.print(" + line.substring(4, line.length() - 1) + ";\n");
                    bw.flush();
                }
            }

        }
        bw.write("}\n");
        bw.write("}");
        bw.flush();
    }

}
