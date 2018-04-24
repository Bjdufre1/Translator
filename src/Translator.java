import java.io.*;

public class Translator {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        bw = new BufferedWriter(new FileWriter("output.txt"));
        String line = "";
        //ignoring first line that will always be beg{
        br.readLine();
        bw.write("public class translated {\n");
        bw.write("public static void main(String[] args) {\n");
        bw.flush();
        while ((line = br.readLine()) != null){
            if(line.length() >= 3) {
                String beginning = line.substring(0,3);
                if (beginning.equals("int")) {
                    bw.write(line + "\n");
                    bw.flush();
                }
                if(beginning.equals("dbl")){
                    bw.write("double" + line.substring(3, line.length()) + "\n");
                    bw.flush();
                }
                if(beginning.equals("flt")){
                    bw.write("float" + line.substring(3, line.length()) + "\n");
                    bw.flush();
                }
                if(beginning.equals("chr")){
                    bw.write("char" + line.substring(3, line.length()) + "\n");
                    bw.flush();
                }
                if(beginning.equals("boo")){
                    bw.write("bool" + line.substring(3, line.length()) + "\n");
                    bw.flush();
                }
                if(beginning.equals("str")){
                    bw.write("String" + line.substring(3, line.length()) + "\n");
                    bw.flush();
                }
                if (beginning.equals("fnl")) {
                    bw.write("public static" + line.substring(3,line.length()) + "\n");
                    bw.flush();
                }
                if (beginning.equals("if(")) {
                    bw.write(line + "\n");
                    bw.flush();
                }
                if (beginning.equals("el{")) {
                    bw.write("else{" + "\n");
                    bw.flush();
                }
                if(beginning.equals("for")){
                    bw.write(line + "\n");
                    bw.flush();
                }
                if(beginning.equals("whl")){
                    bw.write("while" + line.substring(3,line.length()) + "\n");
                    bw.flush();
                }
                if(beginning.equals("pnt")){
                    line = line.replaceAll("@","+");
                    bw.write("System.out.print(" + line.substring(4, line.length() - 1) + ";\n");
                    bw.flush();
                }
            }
            else if(line.length() >= 1){
                char beginning = line.charAt(0);
                if(beginning == '{'){
                    bw.write("{\n");
                }
                else if(beginning == '}'){
                    bw.write("}\n");
                }
                else{
                    bw.write(line + "\n");
                }
            }

        }
        bw.write("}\n");
        bw.write("}");
        bw.flush();
    }

}
