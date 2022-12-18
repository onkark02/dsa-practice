package practice.java.concepts;

import java.io.*;


/*
* This is an example of Decorator design pattern
* InputStream is the abstract class which has different implementations like BufferedInputStream
* FilterInputStream class is a decorator for InputStream, by extending FilterInputStream one can define own decorators
* FilterInputStream & extending it an
* */
public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = in.read();
        return c == -1 ? c : Character.toLowerCase(c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for(int i=off; i < off+result; i++){
            b[i] = (byte) Character.toLowerCase((char)b[i]);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        InputStream lowerCaseStream = new LowerCaseInputStream(new BufferedInputStream( new FileInputStream("C:\\Users\\tc0oby\\Downloads\\new4.txt")));
        int c;
        while((c = lowerCaseStream.read()) > 0){
            System.out.print((char)c);
        }

    }
}
