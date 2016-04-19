package ie.dit;

import com.github.sarxos.webcam.Webcam;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame{

    JButton finish, choose, settings, openCamera;
    JLabel title, filechoosen;

    Text load;

    Webcam webcam = null;

    Camera camera = new Camera(webcam);

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
        event2 fin = new event2();
        finish.addActionListener(fin);

        openCamera = new JButton("Camera");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 3;
        add(openCamera, l);
        event3 cameraEvent = new event3();
        openCamera.addActionListener(cameraEvent);

    }

    public class event implements ActionListener{

        public void actionPerformed(ActionEvent e){
            choosefile();
        }

    }

    public class event2 implements  ActionListener{
        public void actionPerformed(ActionEvent fin) {
            pros();
        }
    }

    public class event3 implements ActionListener{
        public void actionPerformed(ActionEvent cameraEvent) {
            camera();
        }
    }

    public static void main(String[] args) {

        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300, 300);
        gui.setVisible(true);
        gui.setTitle("Book Reader");

        //camera.detectMotion();
        //camera.webcamPanel();
    }

    public void choosefile()
    {
        load = new Text("");

        //book = new ArrayList<>();
        //book = load.lines;

    }


    public void pros()
    {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new GUI(load, camera));
        //load.read();

    }

    public void camera()
    {
        if (camera.cameraOn)
        {
            camera.stopMotionDetection();
        }
        else
        {
            camera.webcamPanel();
            camera.detectMotion();
            camera.startMotionDetection();
        }
    }
}
