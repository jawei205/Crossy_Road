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
  void calc() {
    this.x += map(noise(xoff), 0, 1, -g, g);
    if (this.x>=width) {
      this.x=0;
    }
    if (this.x<0) {
      this.x=width;
    }
    this.xoff+=0.01;
c= 255;
    if (abs(spielerX - this.x)<35 && abs(spielerY - this.y)<this.h+10) {
      spielerX = width/2;
      spielerY = height/6*5;
      score = 0;
      g=width/1000;
      fill(c);
    }
  }
  void show() {

    rect(x, y, 50, this.h);
  }
}