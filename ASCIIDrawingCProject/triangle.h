//Pawel Adamczuk
#ifndef __TRIANGLE_H__
#define __TRIANGLE_H__
#include "shape.h"

class Triangle : public Shape {

  private:
  int a1;
  int a2;
  int b1;
  int b2;

  public:
  Triangle(Display*, int, int, int, int);
  void draw();

};
#endif // !__TRIANGLE_H__
