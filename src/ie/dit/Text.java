package ie.dit;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
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
                String current;
                while ((current = reader.readLine()) != null) {
                    lines.add(current);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadPDFFile(File selection)
    {
        try {
            PDFTextStripper textStripper=new PDFTextStripper();
            PDDocument document=PDDocument.load(selection);
            String text=textStripper.getText(document);
            document.close();
            lines = splitFile(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadDocxFile(File selection)
    {
        System.out.println(selection);
        try{
            FileInputStream fis = new FileInputStream(selection.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();


            for (XWPFParagraph para : paragraphs) {
                lines.add(para.getText());
            }
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
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
                loadPDFFile(selection);
            }
            else if (fileType.equals("docx"))
            {
                loadDocxFile(selection);
            }
            else
            {
                loadFile(selectionPath);
            }
        }
    }

    public void readText(boolean words, GUI gui)
    {
        int i = 10;
        int w = 100;
        for (String x:lines)
        {
            System.out.println(x);
            gui.text(x, w, i * 10);
            if (i * 10 <= 600){
                i++;
            }
            else
            {
                i = 10;
                w = 650;
            }
        }
        if (words) {
            for (String x : lines) {
                ArrayList<String> returnedSentence = splitSentence(x);
                for (String xx : returnedSentence) {
                    System.out.println(xx);
                }
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

    public ArrayList<String> splitFile(String textToBeSplit)
    {
        ArrayList<String> sentences = new ArrayList<>();
        for (String sentence : textToBeSplit.split("\n"))
        {
            sentences.add(sentence);
        }
        return sentences;
    }
}
