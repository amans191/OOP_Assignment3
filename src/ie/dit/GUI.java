package ie.dit;

import processing.core.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GUI extends PApplet {

    Text text;
    Camera camera;
    Point p;
    int x;
    Boolean pageLoop;

    ArrayList<Page> Pages;
    public GUI(Text text, Camera camera){
        Pages = new ArrayList<>();
        this.text = text;
        this.camera = camera;
        this.p = camera.p;
        this.x = 0;
        Pages = text.Pages;
        this.pageLoop = false;
        pn =0;
    }

    private int pn ;
    public void settings() {
        size(1400, 600 , P3D);
        animation = false;
        angle = 0;

    }

    private float angle ;
    void animation()
    {
        if(!animation)
        {
            animation = true;
        }
    }
    void animationright()
    {
        if(!animationright)
        {
            animationright = true;
        }
    }
    public void draw(){


        background(0);
        stroke(255);
        fill(0);
        int noc;
        noc = 10;
        int[] colour = new int[noc]; // array for colors

        //colors used in the book
        colour[0] = color(219,150,98);
        colour[1] = color(232,195,136);
        colour[2] = color(252,214,117);

        System.out.println(pn);

        //float s = height/20;
        //float w = width/2;

        //for animation


        if (camera.cameraOn) {
            if (camera.returnX() <= 40 && camera.returnX() >= 0) {
                x = 0;
                angle = 8;
                animationright();
                //TimeUnit.SECONDS.sleep(1);

            } else if (camera.returnX() <= 170 && camera.returnX() >= 130) {
                x = 0;
                angle = 0;
                //animation = true;
                animation();
                if (pn <= 2){
                    pageLoop = true;
                }
            }
        }

        if (pn == Pages.size()){
            pn = 0;
        }
        if (pn <= 2 && pageLoop){
           // pn = Pages.size() - 2;
            pageLoop = false;
        }

        if(animation)
        {
            angle+=0.1;
        }
        else if(animationright)
        {
                 angle-=0.1;
        }
        if( (angle > 7) && (animation))
        {
            animation = false;
            //animation = false;
            if(pn-2 >0) {
                pn -= 2;
            }
        }
        else if( (angle<1 && (animationright)) )
        {
            animationright=false;
            if(pn+2 <= Pages.size()) {

                 pn += 2;
            }
        }
        float h = height/20;
        pushMatrix();
        translate(width/2,0);
        beginShape();
        rotateY(angle);
        line(0, height / 20 ,0, height - (height / 20) );
        stroke(255);
        fill(colour[2]);
        drawarc(0 ,h, width/2 - (width / 20) , h, 200);
        drawarc(0 ,height -h, width/2 - (width / 20) , height-h, 200);
        rect(0, h, (width) - ((width / 2) + (width / 20)), height - (2 * (h)));
        line(width/2 - (width / 20) ,h, width/2 - (width / 20), height - (height / 20));
        endShape();
        popMatrix();


         //draw right side
        int j= 0;
        for(int i = 0; i<20; i+=2,j++)
        {

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





        fill(0);
        //text.readText(true, this); backup textoutput



        //code to print onto pages
        //left page
        int i =0;
        textSize(17);
        for( String x : Pages.get(pn).lines)
        {
            //println(x);
            text(x,(width/20)+40,(height/20)+40+(i*15));
            i++;
        }

        //right page
        i=0;
        for(String x :Pages.get(pn+1).lines)
        {
            text(x,(width/2)+40,(height/20)+40+(i*15));
            i++;
        }


    }

    //function to draw moving page
    private void drawarc(float x1, float y1, float x2, float y2, float h)
    {
        float l = (x2-x1)/2;
        curve(x1-(l),y1+h,0,x1,y1,0,x2,y2,0,x2+(l-h),y2+h,0);
    }


    //changed keys to work with makey makey
    @Override
    public void keyPressed() {
        super.keyPressed();
        if(key == 'w' || key == 'W')
        {
            angle = 0;
            animation = true;
            if(pn-2 >0){
                pn-=2;
            }

            if (pn <= 2){
                pageLoop = true;
            }
            x = 0;
        }
        else if (key == 'a' || key == 'A')
        {
            angle = 8;
            animationright = true;
            if(pn+2 <= Pages.size()) {
                pn += 2;

            }
            x = 0;
        }
        else if (key == 's' || key == 'S')
        {
            Speech speechFromFile = new Speech(Pages.get(pn).lines.get(x));
            speechFromFile.say();
            x++;
        }

    }

   private boolean animation;
   private boolean animationright;

}
