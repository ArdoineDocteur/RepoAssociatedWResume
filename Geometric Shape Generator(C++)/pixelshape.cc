// Copyright 2023 Ardoine Docteur
#include "pixelshape.h"
#include <iostream>
namespace CSCE240_Program6 {
    CSCE240_Program6::PixelShape::PixelShape(std::string sn, char pc):
    shape_name_("?"), pix_char_('*') {
        SetName(sn);
        SetPixel(pc);
    }
    CSCE240_Program6::PixelShape::~PixelShape() {
    }
    void CSCE240_Program6::PixelShape::SetName(std::string new_name) {
        if (new_name.length() > 0)
          shape_name_ = new_name;
    }
    void CSCE240_Program6::PixelShape::SetPixel(char new_pc) {
        // Here, I casted the passed in char param to obtain
        // the ASCII value of the char param to ensure that
        // the val's ASCII value is in the interval [33,126]
        if (static_cast<int>(new_pc) >= 33 &&
        static_cast<int>(new_pc) <= 126) {
          pix_char_ = new_pc;
        }
    }
    void CSCE240_Program6::PixelShape::Print(bool interior) {
        std::cout << shape_name_ << std::endl;
    }
}  // End namespace CSCE240_Program6
