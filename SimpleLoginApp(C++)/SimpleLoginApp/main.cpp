/* -In this lecture, we created a simple login application using
 * the concepts learned preceding this point.
 * -In this, we also learned about the GroupBox Widget which basically
 * seems like the div from HTML. Besides this, to select multiple widgets
 * in the designer, hold ctrl and then click the widgets you want to have[for
 * lack of better words].
 * -In this same file, we also learned how to add an image in the right hand corner
 * of the mainwindow widget. According to the video, there are two ways to add images to
 * your Qt GUI programs.
 * -In this same file, we also learned about the QStatusBar object that Qt Provides. Although,
 * you may have not realized it, the QStatusBar obejct is a member of your mainwindow class by
 * DEFAULT. The StatusBar is used to display Statuses. For each widget, the status bar is located
 * at the bottom of the widget. Also, according to the video, we, the programmers, have the ability to
 * add custom widgets to the status bar.
 * -In this same file, we also were introduced to resource collection files. This came about when we referenced
 * an image on our file system because it restricts our program from working on OTHER systems, UNLESS they have the
 * same image in the same position AND folder on their system. Also, adjacent to other program languages, when using file
 * i/o it is recommended to use relative paths opposed to absolute paths. IMPT: To create a resource file, we simply follow
 * the same procedure as if we are creating another custom widget. However, instead of choosing Qt Designer Form Class, we choose
 * Qt Resource File. Another thing to know is that Resource Files have the .qrc extension. IMPT: In short, the resource files are
 * basically the portable version of a file system that your Qt GUI program will be using. Due to this, you have the ability to
 * add prefixes, which is basically adding directories, and add files is for adding files that are referenced in said directories. Once
 * you do this, then you use the paths inside of the resource folder onto your functions, etc. that are referencing filepaths to certain
 * files. Also, when doing this, remember to right click the file in the .qrc file and click copy path NOT copy url.
 * -In this same file, we also learned how to use the QLineEdit object to create a password field which is used to encapsulate user input data.
 * THis is done by setting the echoMode member var of the QLineEdit Object[aka instance of QLineEdit] to password instead of Normal.
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
