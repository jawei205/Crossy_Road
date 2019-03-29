import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Crossy_Road extends PApplet {

Barriere[] barrieren = new Barriere[60];
float spielerX;
float spielerY;
float g;
int score=0;
int hightscore;
float c;

public void setup() {
  
  spielerY=height*0.95f;
  spielerX = width/2;
  rectMode(CENTER);
  colorMode(HSB);
  int index = 0;
  g=width/1000;
  float h =  height*0.7f/barrieren.length;
  for (float i = height*0.1f; i<height*0.8f; i +=h) {
    barrieren[index] = new Barriere(i, h);
    index++;
  }
}

public void draw() {
  background(51);
  //fill(255);
  ellipse(spielerX, spielerY, 20, 20);

  for (int i=0; i<barrieren.length; i++) {
    barrieren [i].calc();
    barrieren [i].show();
  }

  if (spielerY<height*0.1f) {
    colorMode(HSB);
    c=random(20, 255);
    spielerY=height*0.95f;
    spielerX=width/2;
    g*=1.25f;
    score++;       
    fill (c, 255, 255);
  }
  //fill(255);
  textSize(32);
  text("Score:"+score, 20, 30);
  text("Highscore" + hightscore, 20, 70);
  if (score>hightscore) {
    hightscore++;  
    
    {
      
    }
  }
}


public void keyPressed() {
  if (keyCode==UP) {
    spielerY -= 15;
  } 
  if (keyCode==RIGHT) {
    spielerX += 15;
  } 
  if (keyCode==LEFT) {
    spielerX -= 15;
  }
}
class Barriere {
  float x;
  float y;
  float xoff;
  float h;


  Barriere(float y, float h) {
    this.x = random(width);
    this.y = y;
    this.h = h;

    xoff = random(0, 100);
  }
  public void calc() {
    this.x += map(noise(xoff), 0, 1, -g, g);
    if (this.x>=width) {
      this.x=0;
    }
    if (this.x<0) {
      this.x=width;
    }
    this.xoff+=0.01f;
c= 255;
    if (abs(spielerX - this.x)<35 && abs(spielerY - this.y)<this.h+10) {
      spielerX = width/2;
      spielerY = height/6*5;
      score = 0;
      g=width/1000;
      fill(c);
    }
  }
  public void show() {

    rect(x, y, 50, this.h);
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Crossy_Road" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
