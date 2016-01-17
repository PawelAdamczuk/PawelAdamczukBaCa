//Pawel Adamczuk
#include "shape.h"

bool Shape::firstEver = 0;

Shape::Shape(Display* display) : display(display) {}

void Shape::changeDisplay(Display* display) {
  this->display = display;
}