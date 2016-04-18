package ie.dit;

import processing.core.PApplet;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{

    JButton finish, choose, settings;
    JLabel title, filechoosen;
    public Main()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints l = new GridBagConstraints();

        title = new JLabel("BOOK READER");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 0;
        add(title,l);

        choose = new JButton("choose file");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 1;
        l.gridy = 1;
        add(choose,l);
        event e = new event();
        choose.addActionListener(e);

        filechoosen = new JLabel("choose file");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 3;
        l.gridy = 1;
        add(filechoosen,l);

        settings = new JButton("Settings");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 1;
        l.gridy = 2;
        add(settings,l);

        finish = new JButton("READ");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 3;
        l.gridy = 2;
        add(finish,l);
    }

    public class event implements ActionListener{

        public void actionPerformed(ActionEvent e){
            choosefile();
        }
    }

    public static void main(String[] args) {

        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,300);
        gui.setVisible(true);
        gui.setTitle("Book Reader");


    }

    Text load;

    public void choosefile()
    {
        load = new Text("");
        //book = new ArrayList<>();
        //book = load.lines;

    }


    public void pros()
    {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new GUI(load));

        String speechTest = "This is a test";
        Speech speech = new Speech(speechTest);
        speech.say();
    }
}
