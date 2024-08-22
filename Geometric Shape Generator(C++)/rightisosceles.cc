// Copyright 2023 Ardoine Docteur
#include <iostream>
#include "rightisosceles.h"
#include "pixelshape.h"
using CSCE240_Program6::RightIsosceles;
namespace CSCE240_Program6 {
  RightIsosceles::RightIsosceles(int length, char pc):
  CSCE240_Program6::PixelShape("right isosceles triangle", pc), leg_(2) {
    SetLeg(length);
    // Used initializer lists to set a default name
    // for each instance and as a failsafe for
    // the int leg_ member var.
  }
  RightIsosceles::~RightIsosceles() {
  }
  void RightIsosceles::SetLeg(int new_len) {
    if (new_len >= 2) {
        leg_ = new_len;
    } else {
      leg_ = leg_;
    }
  }
  RightIsosceles& RightIsosceles::operator*=(double rightoperand) {
    // Ensures that the product is at least two.
    leg_ = leg_ * rightoperand >= 2 ? leg_ * rightoperand : leg_;
    return *this;
  }
  void RightIsosceles::Print(bool interior) {
    CSCE240_Program6::PixelShape::Print(interior);
    int size = 2*leg_ - 1;
    char** output = new char*[leg_];
    // Here, I used a pointer to pointer array to
    // print out my shapes exterior and interior.
    for (int i = 0; i < leg_; ++i) {
        // sizer is used to determine the correct size
        // for each row of the triangle since, from top to bottom,
        // the length increases by 2 * <<row n between 0 and leg_ - 1>>.
        int sizer = (size-(2*i) > 0 ? (size-(2*i)) : 1);
          output[leg_-1-i] = new char[sizer+2];
          // Allocating memory @ each index from
          // the bottom of the triangle to the top.
       for (int j = 0; j < sizer; j+=2) {
         if (leg_-1-i == 0) {
            output[leg_-1-i][0] = output[leg_-1-i][2] = GetPixel();
            output[leg_-1-i][1] = ' ';
            break;
         }
           output[leg_-1-i][j] = GetPixel();
           if (i == leg_-1) {
            break;  // Prevents top of triangle from having unnecessary space.
       } else {
            output[leg_-1-i][j+1] = ' ';
            output[leg_-1-i][sizer+1] = ' ';
       }
       }
       if (interior == false) {
        for (int j = 1; j < sizer-1; ++j) {
          if (j == sizer-1) {
            // Ensures that the perimeter is printed properly.
            output[leg_-1-i][j] = GetPixel();
           } else if (i > 0) {
            // Ensures that the interior isn't filled.
            output[leg_-1-i][j] = ' ';
          }
        }
       }
    }
    // Responsible for printing out the shape properly.
    for (int i = 0; i < leg_; ++i) {
      int sizer = 2*i > 0 ? 2*i : 0;
      for (int j = 0; j < sizer+2; ++j) {
        if (output[i][j] == ' ' || output[i][j] == GetPixel()) {
           std::cout << output[i][j];
         }
      }
      std::cout << "\n";
    }
    // Deletes memory properly to prevent memory
    // leaks
    delete[] output;
}
}  // end namespace CSCE240_Program6
