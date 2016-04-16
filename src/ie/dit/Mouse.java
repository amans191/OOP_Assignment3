package ie.dit;

import processing.core.*;
import processing.video.*;

/**
 * Created by amansingh on 15/04/2016.
 */

public class Mouse extends PApplet {

    Capture cam;

    public void settings() {
        size(640, 480, P3D);

        String[] cameras = Capture.list();

        if (cameras.length == 0) {
            println("There are no cameras available for capture.");
            exit();
        } else {
            println("Available cameras:");
            for (int i = 0; i < cameras.length; i++) {
                println(cameras[i]);
            }

            // The camera can be initialized directly using an
            // element from the array returned by list():
            cam = new Capture(this, cameras[0]);
            cam.start();
        }
    }

    public void draw() {
        if (cam.available() == true) {
            cam.read();
        }
        image(cam, 0, 0);
        // The following does the same, and is faster when just drawing the image
        // without any additional resizing, transformations, or tint.
        //set(0, 0, cam);
    }

}