package ie.dit;

import processing.core.PApplet;

/**
 * Created by Eoin on 07/03/2016.
 */
public class GUI extends PApplet {

    public void settings() {
        size(800, 500);
    }

    public void draw(){
        background(0);
        stroke(255);
        fill(0);

        for(int i = 0; i<20; i+=2)
        {
            float h = height/20;
            beginShape();
            line(width / 2, height / 20 , width / 2, height - (height / 20) - i);
            stroke(255);
            //arc(3*(width/4),height, 2*sqrt(((81*height*height) + (25 *width *width))/400), 2*sqrt(((81*height*height) + (25 *width *width))/400), -PI,0);
            //curve(width/4,height/4, width/2,height/20, width-(width/20),height/20, width+(width/4),height/4);
            drawarc(width/2 ,h, width - (width / 20) , h, 200);
            line(width - (width / 20) +i,h+i, width - (width / 20)+i, height - (height / 20) +i);
            drawarc(width/2 , height - (height / 20)+i , width - (width / 20)+i, height - (h)+i , 200-(i*12));
            //curve(width/4,height +(height/4), width/2,height-(height/20), width-(width/20),height-(height/20), width+(width/4),height+(height/4) );
            endShape();
        }
    }

    private void drawarc(float x1, float y1, float x2, float y2, float h)
    {
        float l = (x1-x2)/2;
        curve(x1-(l-h),y1+h,x1,y1,x2,y2,x2+(l-h),y2+h);
    }
}
