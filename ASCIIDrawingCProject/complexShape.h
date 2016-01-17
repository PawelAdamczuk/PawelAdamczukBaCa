//Pawel Adamczuk
#ifndef __COMPLEX_SHAPE_H__
#define __COMPLEX_SHAPE_H__
#include "shape.h"
#include "circle.h"
#include "triangle.h"
#include "parallelogram.h"

class ComplexShape : public Shape {
  private:
  Shape** shapes;
  int shapeCount;

  public:
  ComplexShape(Display*);
  ~ComplexShape();
  void changeDisplay(Display*);

  void draw();
  bool add(Shape*);

};
#endif // !__COMPLEX_SHAPE_H__
