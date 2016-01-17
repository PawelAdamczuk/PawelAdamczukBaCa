//Pawel Adamczuk
#ifndef __SHAPE_H__
#define __SHAPE_H__
#include "display.h"
class Shape {
  protected:
    Display* display;
  public:
    static bool firstEver;
    Shape(Display*);
    virtual void draw() = 0;
    void changeDisplay(Display*);

};
#endif // !__SHAPE_H__
