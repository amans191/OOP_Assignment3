package ie.dit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class Text {

    private String fileName;

    ArrayList<String> lines = new ArrayList<>();

    public Text(String fileName)
    {
        loadFile(fileName);
    }

    public void loadFile(String fileName)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String current = "";
            while ((current = reader.readLine()) != null)
            {
                lines.add(current);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void readText()
    {
        for (int i = 0; i < lines.size(); i++)
        {
            System.out.println(lines.get(i));
        }
    }
}
