import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// use: java ByteStreamCopyTest readtest.txt writetest.txt

public class ByteStreamCopyTest
{
    public static void main(String[] args)
    {
        byte[] b = new byte[128];
        int bLen = b.length;

        try(FileInputStream fis = new FileInputStream(args[0]);
                    FileOutputStream fos = new FileOutputStream(args[1]))
        {

            System.out.println("Bytes available: " + fis.available());
            int count = 0;
            int read = 0;
            while((read = fis.read(b)) != -1)
            {
                if (read < bLen)
                {
                    fos.write(b, 0, read);
                }
                else
                {
                    fos.write(b);
                }
                count += read;
            }
            System.out.println("Wrote: " + count);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found: " + e);
        }
        catch(IOException e)
        {
            System.out.println("IOException: " + e);
        }
    }
}