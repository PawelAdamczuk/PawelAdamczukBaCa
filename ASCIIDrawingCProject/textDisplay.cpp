//Pawel Adamczuk
#include "textDisplay.h"

void TextDisplay::drawTriangle(int a1, int a2, int b1, int b2) {
  if (!Display::firstEver)
    std::cout << std::endl;
  Display::firstEver = false;
  std::cout << "Drawing a triangle from vectors (" << a1 << ", " << a2 << "), (" << b1 << ", " << b2 << ").";
}

void TextDisplay::drawCircle(int r) {
  if (!Display::firstEver)
    std::cout << std::endl;
  Display::firstEver = false;
  std::cout << "Drawing a circle with radius " << r << ".";

}

void TextDisplay::drawParallelogram(int a1, int a2, int b1, int b2) {
  if (!Display::firstEver)
    std::cout << std::endl;
  Display::firstEver = false;
  std::cout << "Drawing a parallelogram from vectors (" << a1 << ", " << a2 << "), (" << b1 << ", " << b2 << ").";
}