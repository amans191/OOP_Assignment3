package ie.dit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import processing.core.PApplet;

public class Text  extends PApplet {

    private String fileName;

    ArrayList<String> lines = new ArrayList<>();

    public Text(String fileName)
    {
        loadFile(fileName);
    }

    public void loadFile(String fileName)
    {
        if (fileName == "")
        {
            selectInput("Please Select a File,", "fileDialog");
        }
        else {
            try {
                System.out.println(fileName);
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String current = "";
                while ((current = reader.readLine()) != null) {
                    lines.add(current);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileDialog(File selection) {
        if (selection == null)
        {
            System.out.println("No file selected");
        }
        else
        {
            loadFile(selection.getPath());
            readText();
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
