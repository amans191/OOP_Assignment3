package ie.dit;

import com.github.sarxos.webcam.*;

import javax.swing.*;
import java.awt.*;

public class Camera implements WebcamMotionListener{

    Webcam webcam;

    Camera(Webcam webcam){
        this.webcam = Webcam.getDefault();
        //webcam.setViewSize(new Dimension(320, 240));
    }

    public void webcamPanel(){
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        JFrame window = new JFrame("Test webcam panel");
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    public void detectMotion(){
        WebcamMotionDetector detector = new WebcamMotionDetector(webcam);
        detector.setInterval(500); // one check per 500 ms
        detector.addMotionListener(this);
        detector.start();
    }

    @Override
    public void motionDetected(WebcamMotionEvent wme) {
        System.out.println("Detected motion I, alarm turn on you have");
    }
}
