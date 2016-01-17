//Pawel Adamczuk
#ifndef __GRAPHICAL_DISPLAY_H__
#define __GRAPHICAL_DISPLAY_H__
#include "display.h"
#include <iostream>
#include <algorithm>

class GraphicalDisplay : public Display {
public:
  void drawTriangle(int a1, int a2, int b1, int b2);
  void drawCircle(int r);
  void drawParallelogram(int a1, int a2, int b1, int b2);
  static bool liesWithinTriangle(int a1, int a2, int b1, int b2, int p1, int p2);
};
#endif // !__TEXT_DISPLAY_H__
