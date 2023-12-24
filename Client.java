import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

import org.acplt.oncrpc.*;

public class Client 
{
    acsClient rpc ;

    public Client() throws Exception
    {
        this.rpc = new acsClient(InetAddress.getByName("127.0.0.1"),OncRpcProtocols.ONCRPC_TCP);
    }

    public void get(String src,String dist) throws Exception
    {
        response res = this.rpc.read_file_1(src);
        if(res.code == 0)
        {
            System.err.println(res.body);
            return;
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dist)));
        writer.write(res.body);
        writer.flush();
        System.out.println("file is downloaded");
    }

    public void put(String src,String dist) throws Exception
    {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(src));
        String content = "";
        int c;
        while ((c = reader.read()) != -1)
            content += (char)c;
        reader.close();
        response res = this.rpc.write_1(dist,content);
        System.out.println(res.body);
    }

    public void delete(String file) throws Exception
    {
        response res = this.rpc.delete_1(file);
        System.out.println(res.body);
    }

    public void list(String dir) throws Exception
    {
        response res = this.rpc.list_1(dir);
        System.out.println(res.body);
    }

    public static void help()
    {
        System.out.println("command manual:");
        System.out.println("\t help disply this manual");
        System.out.println("\t get [source] [distination]  : get a file from the server");
        System.out.println("\t put [source] [distination]  : uploade a file to the server");
        System.out.println("\t delete [file]  : delete a file from the server");
        System.out.println("\t list [dir]  : list the content of a diractory");
        System.out.println("\t exit  : leave the programme");
    }


    public static String[] sanitise(String [] cmd)
    {
        ArrayList<String> tmp = new ArrayList<>();
        for (String string : cmd)
        {
            if (string.equals("")) continue; 
            tmp.add(string);
        }
        String[] c = new String[tmp.size()];
        for (int i = 0; i < c.length; i++) {
            c[i] = tmp.get(i);
        }
        return c;
    }

    public void interpriter(String cmd) throws Exception
    {
        String[] pars = cmd.split(" ");
        pars = Client.sanitise(pars);
        switch (pars[0])
        {
            case "get":
                if(pars.length != 3)
                    System.out.println("not enough args");
                else
                    this.get(pars [1], pars[2]);
                break;
            case "put":
                if(pars.length != 3)
                    System.out.println("not enough args");
                else
                    this.put(pars[1], pars[2]);
                break;
            case "delete":
                if(pars.length != 2)
                    System.out.println("not enough args");
                else
                    this.delete(pars[1]);
                break;
            case "list":
                if(pars.length != 2)
                    System.out.println("not enough args");
                else
                    this.list(pars[1]);
                break;
            case "exit":
                System.out.println("bye");
                break;
            case "help":
                Client.help();
                break;
            default:
                System.out.println("invalide command ,try help");
                break;    
        }
    }

    public static void main(String[] args) {
        try
        {
            Client c = new Client();
            Client.help();
            String cmd = "";
            Scanner sc = new Scanner(System.in);
            while (!cmd.equals("exit"))
            {
                System.out.print("\n _$ ");
                cmd = sc.nextLine();
                c.interpriter(cmd);
            }
            sc.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
