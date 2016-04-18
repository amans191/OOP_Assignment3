package ie.dit;

import processing.core.PApplet;

public class Main{

    public static void main(String[] args) {
        Text test = new Text("");

        String[] a = {"MAIN"};
       // PApplet.runSketch(a, new GUI(test));

        String speechTest = "This is a test";
        Speech speech = new Speech(speechTest);
        speech.say();
    }
}
