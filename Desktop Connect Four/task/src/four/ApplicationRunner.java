package four;

public class ApplicationRunner
{
    public static void main(String[] args)
    {
        new ConnectFour();

        //CheckUponExit demoCheckWindow = new CheckUponExit();
        //demoCheckWindow.setVisible(true);

        //I can call this here
        // OR
        // I can just call it from the ConnectFour() constructor
        //new ColorGrid();

        //Currently, I'm calling here and the ConnectFour() constructor
        //So there are TWO different windows when running the program

    }
}