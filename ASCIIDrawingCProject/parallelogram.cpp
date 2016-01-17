//Pawel Adamczuk
#include "parallelogram.h"

Parallelogram::Parallelogram(Display* display, int a1, int a2, int b1, int b2) : Shape(display), a1(a1), a2(a2), b1(b1), b2(b2) {}

void Parallelogram::draw() {
  display->drawParallelogram(a1, a2, b1, b2);
}