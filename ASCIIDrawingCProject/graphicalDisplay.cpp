//Pawel Adamczuk
#include "graphicalDisplay.h"

bool GraphicalDisplay::liesWithinTriangle(int a1, int a2, int b1, int b2, int p1, int p2) {

  float x = p1;
  float y = p2;

  float x1 = 0;
  float y1 = 0;
  float x2 = a1;
  float y2 = a2;
  float x3 = b1;
  float y3 = b2;
  

  float a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
  float b = ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
  float c = 1 - a - b;

  return 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1;


}

void GraphicalDisplay::drawTriangle(int a1, int a2, int b1, int b2) {
  //std::cout << "Drawing a triangle from vectors (" << a1 << "," << a2 << "), (" << b1 << "," << b2 << ").\n";
  for (int i = a2; i >= b2; --i)
  {
    if (!Display::firstEver)
      std::cout << std::endl;
    Display::firstEver = false;
    for (int j = 0; j <= std::max(a1, b1); ++j)
    {
      if (liesWithinTriangle(a1, a2, b1, b2, j, i) || (j == a1 && i == a2) || (j == b1 && i == b2))
        std::cout << 't';
      else
        std::cout << ' ';
    }    
  }
}

void GraphicalDisplay::drawCircle(int r) {
  //std::cout << "Drawing a circle with radius " << r << ".\n";

  int x = r;
  int y = 0;

  for (int i = r; i >= -r; --i)
  {
    if (!Display::firstEver)
      std::cout << std::endl;
    Display::firstEver = false;

    for (int j = 0; j <= 2*r; ++j)
    {
      if ( (j - x) * (j - x) + (i - y) * (i - y) <= r * r )
        std::cout << 'c';
      else
        std::cout << ' ';
    }
  }


}

void GraphicalDisplay::drawParallelogram(int a1, int a2, int b1, int b2) {
  //std::cout << "Drawing a parallelogram from vectors (" << a1 << "," << a2 << "), (" << b1 << "," << b2 << ").\n";

  for (int i = a2; i >= b2; --i)
  {
    if (!Display::firstEver)
      std::cout << std::endl;
    Display::firstEver = false;

    for (int j = 0; j <= a1 + b1; ++j)
    {
      if (liesWithinTriangle(a1, a2, a1 + b1, a2 + b2, j, i) || liesWithinTriangle(a1 + b1, a2 + b2, b1, b2, j, i) || liesWithinTriangle(a1, a2, b1, b2, j, i) || (j == a1 && i == a2) || (j == b1 && i == b2))
        std::cout << 'p';
      else
        std::cout << ' ';
    }
  }

}