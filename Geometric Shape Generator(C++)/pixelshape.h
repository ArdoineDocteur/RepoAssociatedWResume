// Copyright 2023 Ardoine Docteur
#ifndef _PIXEL_SHAPE_H
#define _PIXEL_SHAPE_H
#include <iostream>
#include <string>
namespace CSCE240_Program6 {
class PixelShape {
 private:
  std::string shape_name_;
  char pix_char_;
 public:
  explicit PixelShape(std::string = "?", char = '*');
  virtual ~PixelShape();
  std::string GetName() {return shape_name_;}
  void SetName(std::string);
  char GetPixel() {return pix_char_;}
  void SetPixel(char);
  virtual void Print(bool = true);
    // Below lies The pure virtual function
    // that transforms the class into an abstract class.
  virtual PixelShape& operator *= (double) = 0;
};
}  // end of namespace CSCE240_Program6
#endif
