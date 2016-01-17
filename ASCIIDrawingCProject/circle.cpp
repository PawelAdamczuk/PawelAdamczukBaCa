//Pawel Adamczuk
#include "circle.h"

Circle::Circle(Display* display, int r) : Shape(display), r(r) {}

void Circle::draw() {
  display->drawCircle(r);
}