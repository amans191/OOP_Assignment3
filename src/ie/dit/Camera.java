package ie.dit;

//camera libraries
import com.github.sarxos.webcam.*;

import javax.swing.*;
import java.awt.*;

//Camera class
public class Camera implements WebcamMotionListener{

    Webcam webcam;
    WebcamMotionDetector detector;
    JFrame window;
    Point p;
    boolean cameraOn, motionDetected;

    Camera(Webcam webcam){
        this.webcam = Webcam.getDefault();
        this.p = null;
        this.cameraOn = false;
        this.motionDetected = false;
    }

    public void webcamPanel(){
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);

        window = new JFrame("Test webcam panel");
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    public void detectMotion(){
        detector = new WebcamMotionDetector(webcam);
        detector.setInterval(500); // one check per 500 ms
        detector.setInertia(4);
        detector.addMotionListener(this);
    }

    public void startMotionDetection(){
        detector.start();
        cameraOn = true;
    }

    public void stopMotionDetection(){
        window.dispose();
        detector.removeMotionListener(this);
        detector.stop();
        cameraOn = false;
    }

    public double returnX() {
        if (motionDetected && p != null) {
            return p.getX();
        }
        else{
            return 0;
        }
    }

    @Override
    public void motionDetected(WebcamMotionEvent wme) {
        if (motionDetected) {
            p = wme.getCog();
            System.out.println(p.getX());
        }
        else{
            motionDetected = true;
        }
    }
}
