// Copyright 2023 Ardoine Docteur
#ifndef _RECTANGLE_H
#define _RECTANGLE_H
#include <iostream>
#include "pixelshape.h"
using CSCE240_Program6::PixelShape;
namespace CSCE240_Program6 {
class Rectangle: public PixelShape {
 private:
  int len_;
  int width_;
 public:
  explicit Rectangle(int = 2, int = 1, char = '*');
  ~Rectangle();
  int GetLength() {return len_;}
  void SetLength(int);
  int GetWidth() {return width_;}
  void SetWidth(int);
  // Returned by reference for cascade calls.
  Rectangle& operator *= (double);
  // Overrides virtual function and explicitly
  // states that the function must be virtual
  // in the base/super class.
  void Print(bool = true) override;
};
}  // End namespace CSCE240_Program6



#endif
