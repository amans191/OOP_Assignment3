package ie.dit;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

//text libraries
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

//processing library
import processing.core.PApplet;

import javax.sound.midi.SysexMessage;


public class Text  extends PApplet {

    ArrayList<String> lines = new ArrayList<>();
    ArrayList<Page> Pages = new ArrayList<>();

    String fileName;
    Boolean isDocx;
    int pageCount;

    public Text(String s)
    {
        this.fileName = s;
        this.isDocx = false;
        loadFile(fileName);
    }

    //opens up an explorer and allows you too chose a file
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

    //too load PDF files
    public void loadPDFFile(File selection)
    {
        try {
            PDFTextStripper textStripper=new PDFTextStripper();
            PDDocument document=PDDocument.load(selection);
            String text=textStripper.getText(document);
            document.close();
            lines = splitFile(text);
            Add(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //to load DOCX files
    public void loadDocxFile(File selection)
    {
        System.out.println(selection);
        try{
            FileInputStream fis = new FileInputStream(selection.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();

            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            this.pageCount = extractor.getExtendedProperties().getPages();
            String text = extractor.getText();
            System.out.println(pageCount);
            lines = splitFile(text);
            Add(text);
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //selection of the file and loading function for it
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
                this.isDocx =  true;
                loadDocxFile(selection);
            }
            else
            {
                loadFile(selectionPath);
            }
        }
    }

    //read text version 1(not used)
    public void readText(boolean words, GUI gui)
    {
        int i = 10;
        int w = 100;

        //textSize(45);
        for (String x:lines)
        {
            //System.out.println(x);
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
                //for (String xx : returnedSentence) {
                    //System.out.println(x);
                //}
            }
        }
    }

    //int j;
    //GUI gui;
    //ArrayList<Page> Pages;
    //adding the lines to the pages
    public void Add(String Text)
    {
        //Pages = new ArrayList<>();
        int j=0;
        int i =0;
        Page page = new Page(j+1);

        if (isDocx){
            for(String sentence : Text.split("\n")){
                page.lines.add(sentence);
                j++;

                if (i < pageCount && j == 24){
                    Pages.add(page);
                    i++;
                    page = new Page(i + 1);
                    j = 0;
                }
            }
        }
        else {
            for (String sentence : Text.split("\n")) {
                page.lines.add(sentence);

                //println(sentence);

                if (checkfornumber(sentence, j)) {
                    Pages.add(page);
                    j++;
                    page = new Page(j + 1);

                    //println("p end ...............");
                    //i = 0;
                }
            }
        }
        System.out.println(i);
    }

    //read lines
    //checking the pages lines
    public void read()
    {
        int i =0;
        for( String pi : Pages.get(i).lines)
        {
            println(pi);
        }
    }

    //check page number so it goes to a new page every number on the book
    private boolean checkfornumber( String sentence, int j)
    {
        for (String word: sentence.split(" "))
        {
            if(isNumeric(word)  && word!=" " && (Integer.parseInt(word) == j+2))
            {

                //println(word);
                //println("j is" + j);
                return true;
            }
        }
        return false;
    }

    //to split the sentence into words
    private ArrayList<String> splitSentence(String sentence)
    {
        ArrayList<String> words = new ArrayList<>();
        for (String word: sentence.split(" "))
        {
            words.add(word);
            //println("pg"+isNumeric(word));
            //println(word);
        }
        return words;
    }

    //file is saved into one big string
    //spliting the string by newline
    private ArrayList<String> splitFile(String textToBeSplit)
    {
        ArrayList<String> sentences = new ArrayList<>();
        for (String sentence : textToBeSplit.split("\n")) {
            sentences.add(sentence);
        }
        return sentences;
    }

    //function to check if a string is a number
    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
