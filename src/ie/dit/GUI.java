package ie.dit;

import processing.core.*;

import java.awt.event.KeyListener;

/**
 * Created by Eoin on 07/03/2016.
 */
public class GUI extends PApplet {



    public void settings() {
        size(1600, 700 , P3D);
        turn = false;
    }

    public boolean turn;
    

    public void draw(){
        background(0);
        stroke(255);
        fill(0);
        int noc;
        noc = 10;
        int[] colour = new int[noc];
        colour[0] = color(219,150,98);
        colour[1] = color(232,195,136);
        colour[2] = color(252,214,117);



        float s = height/20;
        float w = width/2;
        //float h = height - s;
        //line(w,s,w,height - s);
        //curve(w,height, w,h, width-(width/20), h-5, width,height);

        //for animation

        float h = height/20;
        pushMatrix();
        translate(width/2,0);

        float angle = 0;
        if(turn) {
            angle = 0;
            println("fa");
            for(int i = 0; i< width*100; ++i) {
                angle++;
            }
            turn = false;
        }
        beginShape();;
        rotateY(angle);
        line(0, height / 20 ,0, height - (height / 20) );
        stroke(255);
        fill(colour[2]);
        //arc(3*(width/4),height, 2*sqrt(((81*height*height) + (25 *width *width))/400), 2*sqrt(((81*height*height) + (25 *width *width))/400), -PI,0);
        //curve(width/4,height/4, width/2,height/20, width-(width/20),height/20, width+(width/4),height/4);
        drawarc(0 ,h, width/2 - (width / 20) , h, 200);
        drawarc(0 ,height -h, width/2 - (width / 20) , height-h, 200);
        rect(0, h, (width) - ((width / 2) + (width / 20)), height - (2 * (h)));
        line(width/2 - (width / 20) ,h, width/2 - (width / 20), height - (height / 20));
        //drawarc(width/2 , height-h , width - (width / 20), height - (h) , 200);
        //curve(width/4,height +(height/4), width/2,height-(height/20), width-(width/20),height-(height/20), width+(width/4),height+(height/4) );
        endShape();
        popMatrix();


         //draw right side
        int j= 0;
        for(int i = 0; i<20; i+=2,j++)
        {
            int c = (int) random(0,3);
            //float h = height/20;

            if(i == 0) {
                //fill(222, 151, 36);
                //fill(232,195,136);
                //fill(237,234,227);
                fill(colour[2]);
                //stroke(222, 151, 36);
                stroke(colour[2]);

                //right side
                rect((width / 2), h, (width) - ((width / 2) + (width / 20)), height - (2 * (h)));
                stroke(0);
                drawarc(width/2 ,h, width - (width / 20) , h, 200);

                //left side
                stroke(colour[2]);
                rect( (width/2), h, -((width) - ((width / 2) + (width / 20))),height - (2 * (h)) );
                stroke(0);
                drawarc(width/2 ,h,  (width / 20) , h, 200);

            }
            else {
                stroke(255);
                //drawarc(width/2 ,h, width - (width / 20) , h, 200);
                stroke(0);
                fill(colour[j % 2]);
            }
            beginShape();
            line(width / 2, height / 20 , width / 2, height - (height / 20) - i);
            rectMode(CORNER);
            drawarc(width/2 , height - (height / 20)+i , width - (width / 20)+i, height - (h)+i , 200-(i*12));
            line(width - (width / 20) +i,h+i, width - (width / 20)+i, height - (height / 20) +i);
            endShape();

            //draw left side
            beginShape();
            line(width / 2, height / 20 , width / 2, height - (height / 20) - i);
            stroke(0);
            drawarc(width/2 , height -(height / 20)+i ,(width / 20)-i, (height - (h))+i , 200-(i*12));
            line((width / 20) -i,h+i, (width / 20)-i, height - (height / 20) +i);
            endShape();
        }

        //draw left side
       /* for(int i = 0; i<20; i+=2)
        {
            float h = height/20;
            beginShape();
            line(width / 2, height / 20 , width / 2, height - (height / 20) - i);
            stroke(255);
            //arc(3*(width/4),height, 2*sqrt(((81*height*height) + (25 *width *width))/400), 2*sqrt(((81*height*height) + (25 *width *width))/400), -PI,0);
            //curve(width/4,height/4, width/2,height/20, width-(width/20),height/20, width+(width/4),height/4);
            drawarc(width/2 ,h,  (width / 20) , h, 200);
            drawarc(width/2 , height -(height / 20)+i ,(width / 20)-i, (height - (h))+i , 200-(i*12));
            line((width / 20) -i,h+i, (width / 20)-i, height - (height / 20) +i);
            //curve(width/4,height +(height/4), width/2,height-(height/20), width-(width/20),height-(height/20), width+(width/4),height+(height/4) );

            endShape();
        }*/



    }

    private void drawarc(float x1, float y1, float x2, float y2, float h)
    {
        float l = (x2-x1)/2;
        curve(x1-(l),y1+h,0,x1,y1,0,x2,y2,0,x2+(l-h),y2+h,0);
    }


    @Override
    public void keyPressed() {
        super.keyPressed();
        if(key == 'm')
        {
            turn = true;

        }
    }
}
