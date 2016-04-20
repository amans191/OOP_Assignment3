package ie.dit;

//webcam library
import com.github.sarxos.webcam.Webcam;

//processing library
import processing.core.PApplet;

//camera libraries
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame{

    //main menu code
    JButton finish, choose, openCamera;
    JLabel title, fileChosen, instructionsM, instructionsN, instructionsS;

    //text class
    Text load;

    //camera class
    Webcam webcam = null;

    Camera camera = new Camera(webcam);

    public Main()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints l = new GridBagConstraints();

        //buttons
        title = new JLabel("BOOK READER");
        l.fill = GridBagConstraints.CENTER;
        l.gridx = 2;
        l.gridy = 0;
        add(title,l);

        fileChosen = new JLabel("Choose file");
        l.fill = GridBagConstraints.CENTER;
        l.gridx = 2;
        l.gridy = 1;
        add(fileChosen,l);

        instructionsM = new JLabel("[M] - Turn page right");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 4;
        add(instructionsM,l);

        instructionsN = new JLabel("[N] - Turn page left");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 5;
        add(instructionsN,l);

        instructionsS = new JLabel("[S] - Speak Text");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 6;
        add(instructionsS,l);

        choose = new JButton("Choose File");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 1;
        l.gridy = 2;
        add(choose,l);
        event e = new event();
        choose.addActionListener(e);

        openCamera = new JButton("Camera");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 3;
        l.gridy = 2;
        add(openCamera, l);
        event3 cameraEvent = new event3();
        openCamera.addActionListener(cameraEvent);

        finish = new JButton("READ");
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 2;
        l.gridy = 3;
        add(finish,l);
        event2 fin = new event2();
        finish.addActionListener(fin);

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
    }

    public void choosefile()
    {
        load = new Text("");
        fileChosen.setText("Book Chosen");

        //book = new ArrayList<>();
        //book = load.lines;

    }


    public void pros()
    {
        String[] a = {"MAIN"};
        PApplet.runSketch(a, new GUI(load, camera));

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
