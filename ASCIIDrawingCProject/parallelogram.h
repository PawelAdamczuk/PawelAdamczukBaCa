//Pawel Adamczuk
#ifndef __PARALLELOGRAM_H__
#define __PARALLELOGRAM_H__
#include "shape.h"

class Parallelogram : public Shape {

  private:
  int a1;
  int a2;
  int b1;
  int b2;

  public:
  Parallelogram(Display*, int, int, int, int);
  void draw();

};
#endif // !__PARALLELOGRAM_H__
