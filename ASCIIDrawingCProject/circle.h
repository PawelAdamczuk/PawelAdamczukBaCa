//Pawel Adamczuk
#ifndef __CIRCLE_H__
#define __CIRCLE_H__
#include "shape.h"

class Circle : public Shape {

  private:
  int r;

  public:
  Circle(Display*, int);
  void draw();




};
#endif // !__SHAPE_H__
