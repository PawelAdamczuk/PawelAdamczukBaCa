//Pawel Adamczuk
#include "complexShape.h"

ComplexShape::ComplexShape(Display* display) : Shape(display) { 
  shapes = new Shape*[5];
  shapeCount = 0;
}

ComplexShape::~ComplexShape() {

  delete shapes;
}

bool ComplexShape::add(Shape* shape) {
  if (shapeCount == 5)
    return 0;
  else
    shapes[shapeCount++] = shape;
  return 1;
}

void ComplexShape::draw() {
  for (int i = 0; i < shapeCount; ++i)
  {
    shapes[i]->draw();
  }
}

void ComplexShape::changeDisplay(Display* display) {
  this->display = display;
}