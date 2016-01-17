//Pawel Adamczuk
#ifndef __TEXT_DISPLAY_H__
#define __TEXT_DISPLAY_H__
#include "display.h"
#include <iostream>

class TextDisplay : public Display {
public:
  void drawTriangle(int a1, int a2, int b1, int b2);
  void drawCircle(int r);
  void drawParallelogram(int a1, int a2, int b1, int b2);

};
#endif // !__TEXT_DISPLAY_H__
