package ie.dit;

import processing.core.PApplet;

public class Main{

    public static void main(String[] args) {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new GUI());

        //not sure if this is right
        //PApplet.runSketch(a, new Mouse());

        Text test = new Text("test.txt");
        Text test2 = new Text("");

        test.readText(false);
        test2.readText(false);

        String speechTest = "This is a test";
        Speech speech = new Speech(speechTest);
        speech.speak();

        for (String x : test.lines)
        {
            Speech speechFromFile = new Speech(x);
            speechFromFile.speak();
        }
        for (String x : test2.lines)
        {
            Speech speechFromFile = new Speech(x);
            speechFromFile.speak();
        }

    }
}
