import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.acplt.oncrpc.*;

public class Server extends acsServerStub{
    public Server() throws Exception{}
    public response read_file_1(String file_name)
    {
        try
        {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file_name));
            String content = "";
            int c;
            while ((c = reader.read()) != -1)
                content += (char)c;
            reader.close();
            response res = new response();
            res.code = 1;
            res.body = content;
            return res; 
        }
        catch (FileNotFoundException e)
        {
            response res = new response();
            res.code = 0;
            res.body = "file not found";
            return res;    
        }
        catch(Exception e)
        {
            response res = new response();
            res.code = 0;
            res.body = "an error has occured when reading file";
            return res;
        }
    }

    public response write_1(String file_name, String content_file)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_name)));
            writer.write(content_file);
            writer.flush();
            writer.close();
            response res = new response();
            res.code = 1;
            res.body = "file has been created";
            return res;
        }
        catch(Exception e)
        {
            response res = new response();
            res.code = 0;
            res.body = "an error has occured when writing file";
            return res;
        }
    }

    public response delete_1(String file_name)
    {
        File file = new File(file_name);
        if(!file.exists())
        {
            response res = new response();
            res.code = 0;
            res.body = " file doesn't exists";
            return res;
        }
        if(file.delete())
        {
            response res = new response();
            res.code = 1;
            res.body = "file deleted";
            return res;
        }
        else
        {
            response res = new response();
            res.code = 0;
            res.body = "file not deleted";
            return res;
        }
    }

    public response list_1(String dire_name)
    {
        try
        {
            File dir = new File(dire_name);
            if(!dir.isDirectory())
            {
                response res = new response();
                res.code = 0;
                res.body = dire_name + " is a file";
                return res;
            }
            File[] files = dir.listFiles();
            String content = "";
            for(File f : files)
            {
                if (f.isDirectory())
                    content += "D: " + f.getName() + "\n";
                else
                    content += "F: " + f.getName() + "\n";
            }
            response res = new response();
            res.code = 1;
            res.body = content;
            return res;
        }
        catch(Exception e)
        {
            response res = new response();
            res.code = 0;
            res.body = "an error has occured";
            return res;
        }
    }

}
