#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMessageBox>//<-- Used this for displaying to user
// if credentials entered were correct or not.
#include <QPixmap>//<-- IMPT: This is a component used to display a picture
// in our QT GUI programs.
MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    // QPixmap pix("C:/Users/adoct/Pictures/Screenshots/Screenshot 2024-04-29 100903.png");//<-- Here, the param we need to pass is the
    // filepath to the picture we want to display.[IMPT: In the lecture where we learned about .qrc files we replaced the
    // filepath with a filepath relative to the .qrc file]
    // Also, ensure that when putting filepath, ensure that you use forward slashes and NOT back slashes.
    // ui->label_picture->setPixmap(pix);
    // IMPT VERY IMPT: The pair of lines of code above are responsible for adding an image to your QT GUI programs.
    // When we first ran the program, our problem was the fact that we couldn't resize the picture. To prevent this,
    // we used the scale(<<pixel count in horiz>>,<<pixel count in vertical>>).

    // ui->label_picture->setPixmap(pix.scaled(100,100,Qt::KeepAspectRatio));//<-- Here, I believe KeepAspectRatio is
    // synonomous to object-contain from css.

    QPixmap pix(":/img/img/Screenshot 2024-04-29 100903.png");//<-- Fp referenced relative to the resource collection file which
    // allows the application to run the same on ALL operating systems.

    // Another thing we found is that we can have the picture take up the entire space of the label by doing the following:
    int w = ui->label_picture->width(), h = ui->label_picture->height();
    ui->label_picture->setPixmap(pix.scaled(w,h,Qt::KeepAspectRatio));

    // The code above represents the first way of displaying images in our qt GUI programs. The second way will be shown below.
    // IMPT: The alternative way is searching for the pixmap property that the QLabel already has and then clicking the dropdown
    // button, and then clicking 'choose file', and then choosing the file that you want to display. However, adjacent to html, in
    // order to resize the image that you set, you must use css in this method which is what we get into in the next lecture.
    ui->statusbar->addPermanentWidget(ui->label_3);
    ui->statusbar->addPermanentWidget(ui->progressBar);//<-- IMPT: Here, we use the addPermanentWidget function to add widgets to the
    // status bar of our current widget[which is the main window in this case].
    // IMPT: According to the video, widgets added to the status bar are placed on the right hand side and
    // MESSAGES added to the status bar are displayed on the LEFT hand side.
    // The second param in the addPermanentWidget function acts the same as the fr css property from the css grid property which splits
    // up free space on the line based on the value of the fr. However, in qt, they call it stretch




}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_pushButton_Login_clicked()
{
    // Here, we used a signal and slot to verify
    // that the user entered valid credentials.
    QString username = ui->lineEdit_username->text();//<-- Here, we instantiated the QString class.
    // Here, we accessed the lineEdit object created in the body of the MainWindow object, and then
    // we used the text() function, which has the same functionality as the innerText method from the DOM
    // in javascript, and the function of the same name in XML, which returns the text in the body of the widget.
    QString password = ui->lineEdit_password->text();
    // Below, we verify that the user input is valid.
    if(username == "test" && password == "test") {
        // Here, we display a message using the QMessageBox object.
        /* IMPT: The code below was commented out for the QStatusBar lecture. When reviewing this for the simpleLoginApp
         * lecture, uncomment this code out and comment the group of code below it accordingly.
         * QMessageBox::information(this,"Login","Username and Password is Correct");
        a = new SecDialog(this);
        a->show();//<-- Here, we call this to show the second window.
        hide();//<-- Called this to make the login page go away and so
        // user focuses on the second window.
        */
        // ui->statusbar->showMessage("Username and Password is Correct");//<-- This showMessage function from the QStatusBar object
        // takes in two parms with the second one being optional. The first one is pretty self-explanatory, but the second one works
        // similar to how the setInterval or setTimeout function from Javascript works. It takes an integer value and limits the
        // display of the message to <<integer>>*10^-3 seconds.
        ui->statusbar->showMessage("Username and Password is Correct",5000);
        // Alternate way to display the message.
        ui->label_3->setText("Invalid STUPIWD");

    } else {
        // QMessageBox::warning(this,"Login","Username and Password is incorrect"); <-- Commented out for the same reason as the group commented out above.
        // ui->label_picture->setPixmap(pix.scaled(100,100,Qt::KeepAspectRatio));
        ui->statusbar->showMessage("Username and Password is incorrect",5000);
        ui->label_3->setText("VAalid STUPIWD");

    } // Below this code, we added code that opens another window upon successful verification.

}

