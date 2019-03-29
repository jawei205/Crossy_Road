Barriere[] barrieren = new Barriere[60];
float spielerX;
float spielerY;
float g;
int score=0;
int hightscore;
float c;

void setup() {
  fullScreen();
  spielerY=height*0.95;
  spielerX = width/2;
  rectMode(CENTER);
  colorMode(HSB);
  int index = 0;
  g=width/1000;
  float h =  height*0.7/barrieren.length;
  for (float i = height*0.1; i<height*0.8; i +=h) {
    barrieren[index] = new Barriere(i, h);
    index++;
  }
}

void draw() {
  background(51);
  //fill(255);
  ellipse(spielerX, spielerY, 20, 20);

  for (int i=0; i<barrieren.length; i++) {
    barrieren [i].calc();
    barrieren [i].show();
  }

  if (spielerY<height*0.1) {
    colorMode(HSB);
    c=random(20, 255);
    spielerY=height*0.95;
    spielerX=width/2;
    g*=1.25;
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


void keyPressed() {
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