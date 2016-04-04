package ie.dit;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import processing.core.PApplet;

public class Text  extends PApplet {

    ArrayList<String> lines = new ArrayList<>();

    public Text(String fileName)
    {
        loadFile(fileName);
    }

    public void loadFile(String fileName)
    {
        if (fileName.equals(""))
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

    public void loadPDFFile(String fileName)
    {

    }

    public void fileDialog(File selection) {
        if (selection == null)
        {
            System.out.println("No file selected");
        }
        else
        {
            String selectionPath = selection.getPath();
            String fileType = "";
            int i = selectionPath.lastIndexOf('.');
            if (i > 0)
            {
                fileType = selectionPath.substring(i + 1);
            }
            if (fileType.equals("pdf"))
            {
                loadPDFFile(selectionPath);
            }
            else
            {
                loadFile(selectionPath);
            }
            readText();
        }
    }

    public void readText()
    {
        for (int i = 0; i < lines.size(); i++)
        {
            System.out.println(lines.get(i));
        }

        for (int i = 0; i < lines.size(); i++)
        {
            ArrayList<String> returnedSentence = splitSentence(lines.get(i));
            for (int j = 0; j < returnedSentence.size(); j++)
            {
                System.out.println(returnedSentence.get(j));
            }
        }
    }

    public ArrayList<String> splitSentence(String sentence)
    {
        ArrayList<String> words = new ArrayList<>();
        for (String word: sentence.split(" "))
        {
            words.add(word);
        }
        return words;
    }
}
