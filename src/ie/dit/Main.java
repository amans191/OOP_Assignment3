package ie.dit;

import processing.core.PApplet;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new GUI());

        Text test = new Text("test.txt");

        test.readText();
    }
}
