// Copyright 2023 Ardoine Docteur
#ifndef _RIGHT_ISOCELES_H
#define _RIGHT_ISOCELES_H
#include <iostream>
#include "pixelshape.h"
namespace CSCE240_Program6 {
class RightIsosceles: public PixelShape {
 private:
  int leg_;
 public:
  explicit RightIsosceles(int = 2, char = '*');
  ~RightIsosceles();
  int GetLeg() {return leg_;}
  void SetLeg(int);
  void Print(bool = true) override;
  RightIsosceles& operator *= (double);
};
}  // end namespace CSCE240_Program6

#endif
