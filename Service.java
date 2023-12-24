public class Service 
{
    public static void main(String[] args) {
        try
        {
            Server s = new Server();
            s.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
