// Copyright 2023 Ardoine Docteur
#include "rectangle.h"
using CSCE240_Program6::Rectangle;
namespace CSCE240_Program6 {
  Rectangle::Rectangle(int l , int w , char new_pc):
  CSCE240_Program6::PixelShape("rectangle", new_pc) , len_(2) , width_(1) {
    SetLength(l); SetWidth(w);
  }
  Rectangle::~Rectangle() {
  }
  void Rectangle::SetLength(int new_l) {
    len_ = new_l > 0 ? new_l : len_;
  }
  void Rectangle::SetWidth(int new_w) {
    width_ = new_w > 0 ? new_w : width_;
  }
  Rectangle& Rectangle::operator *= (double rightoperand) {
    if (len_ * rightoperand < 1 || width_ * rightoperand < 1) {
        len_ = len_;
        width_ = width_;
    } else {
        len_ = len_ * rightoperand;
        width_ = width_ * rightoperand;
    }
    return *this;
  }
  void Rectangle::Rectangle::Print(bool interior) {
    CSCE240_Program6::PixelShape::Print(interior);
    int size = width_ + width_ - 1;
    // size includes the width and the spaces between the characters.
    char output[len_][size + 1];
    // Dimensions of grid containing the rectangle
    // including the space appended on the last character.
    for (int i = 0; i < len_; ++i) {
      for (int j = 0; j < size; ++j) {
        output[i][j] = ' ';  //<-- Default value be4 modification.
        output[i][size] = ' ';
        }
    }
    for (int i = 0; i < len_; ++i) {
        // Assigns pixel to up-down perimeter
        output[i][0] = output[i][size-1] = GetPixel();
    }
    for (int j = 0; j < size; j+=2) {
        // Assigns pixel to left-right perimeter.
        output[0][j] = output[len_-1][j] = GetPixel();
    }
    if (interior == true) {
         for (int i = 0; i < len_; ++i) {
          for (int j = 0; j < size-1; j+=2) {
           // Fills the middle with the current pixel.
           output[i][j] = GetPixel();
           output[i][j+1] = ' ';
        }
    }
    }
    for (int i = 0; i < len_; ++i) {
      for (int j = 0; j < size+1; ++j) {
         std::cout << output[i][j];
      }
      std::cout << "\n";
    }
  }
}  // end of namespace CSCE240_Program6
