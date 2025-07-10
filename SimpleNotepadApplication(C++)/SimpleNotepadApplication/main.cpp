
/* Here, we created a simple notepad application. This application
 * used knowledge from QAction, QMenu, and more. Also, in this process,
 * we learned that separators can be added to the toolbar by right clicking
 * any icon on the toolbar, and following the self-explanatory instructions.
  -IMPT: Also, in this file, we learned about the QFontDialog which is used to
allow the user to select the font that their text has, and more. In this same file,
we also learned about the QColorDialog, which is a object with static members and member
functions that allows you to choose the color for different things[particularly widgets].
-For the last video for this experience, we learned about the QPrintDialog and QPrinter objects.
[COURSE COMPLETE]
*/
#include "mainwindow.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    w.show();
    return a.exec();
}
