import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

class MyPrintWriter {
    /**
     * @Overview:MyPrintWriter将所有的输出统一到一个文件中。
     */
    private PrintWriter printWriter;

    MyPrintWriter(String filename) {
        /*
         * @REQUIRES:
         *      filename!=null;
         * @MODIFIES:
         *      \this.printWriter;
         * @EFFECTS:
         *      normal_behavior:
         *          \this.printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)), true)
         *      exception_behavior(IOException e):
         *          System.out.println("ERROR");
         */
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)), true);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public boolean repOK() {
        /*
         * @REQUIRES:None;
         * @MODIFIES:None;
         * @EFFECTS:
         *      \result==printWriter!=null;
         */
        return printWriter!=null;
    }

    synchronized void print(String s) {
        /*
         * @REQUIRES:None;
         * @MODIFIES:
         *      \this.printWriter;
         * @EFFECTS:
         *      \this.printWriter.print(s);
         *      \this.printWriter.flush();
         * @THREAD_REQUIRES:
         *      \locked(\this);
         * @THREAD_EFFECTS:
         *      \locked();
         */
        printWriter.print(s);
        printWriter.flush();
    }

    void close() {
        /*
         * @REQUIRES:None;
         * @MODIFIES:
         *      \this.printWriter;
         * @EFFECTS:
         *      \this.printWriter.close();
         */
        printWriter.close();
    }
}
