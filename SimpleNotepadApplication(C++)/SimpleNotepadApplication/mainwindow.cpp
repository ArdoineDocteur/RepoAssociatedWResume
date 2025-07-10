#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFileDialog>//<-- This was used for navigating through file system,
// to acheive functionality of the actionOpen triggered event.
#include <QFile>
#include <QTextStream>
// Pair of include preprocessor directives above are here for the same reason
// as the QFileDialog object.
#include <QMessageBox>
#include <QFontDialog>//<-- Used this when we updated notepad to supply different
// fonts
#include <QColorDialog>//<-- Used this when we updated notepad to supply different
// colors
#include <QPrinter>//<-- Used this when updated notepad with a print option
#include <QPrintDialog>//<-- Used this when updated notepad with a print option
MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    this->setCentralWidget(ui->textEdit);
    // When run this setCentralWidget function,
    // it removes the whitespace around the borders
    // of the label.
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_actionNew_triggered()
{
    // Here, we make certain things happen when
    // user wants to make a new file.
    file_path_ = "";//<-- This resets the curretn filepath so
    // it can be replaced with a new one[hence the name], if
    // user chooses to save it.
    ui->textEdit->setText("");//<-- Resets contents of file as well.

}
void MainWindow::on_actionCpy_triggered() {
    ui->textEdit->copy();//<-- Here, we use QTextEdit's
    // copy() function which is pretty self-explantory.

}
void MainWindow::on_actionOpen_triggered() {
    QString file_name = QFileDialog::getOpenFileName(this,"Open the file");
    // As you should know from QFileDialog video, this opens the QFileDialog.
    // Another thing to know is that you can pass in param #3 to establish a
    // default location for the user to start when they press the open option.
    QFile file(file_name);//<-- This is used to reference the file at the filepath
    // chosen by the user.
    file_path_ = file_name;//<-- THis is important so the member var is updated properly
    // We use the code below to read the file and put the contents on the current
    // notepad file.
    if(!file.open(QFile::ReadOnly | QFile::Text)) {
        QMessageBox::warning(this,"..","file not open");
        return;
    }
    // If file is openning is successful:
    QTextStream in(&file);
    QString text = in.readAll();//<-- Obtains string of file's contents.
    ui->textEdit->setText(text);//<-- This is the code responsible for user getting their desired file's contents.
    file.close();
    // As learned previously, remember that the file.flush() is ONLY NEEDED when writing to files!
}
void MainWindow::on_actionSave_triggered() {
	// [cont reading here]
    QFile file(file_path_);
    // We use the code below to WRITE to the file
    if(!file.open(QFile::WriteOnly | QFile::Text)) {
        QMessageBox::warning(this,"..","File not open");
        return;
    }
    // If file is openning is successful:
    QTextStream out(&file);
    QString text = ui->textEdit->toPlainText();//<-- Obtains string of user's session contents.
    ui->textEdit->setText(text);//<-- This is the code repsonsible for user getting their desired file's contents.
    out << text;//<-- Here we use the stream insertion operator to write the text to the file.
    file.flush();//<-- As learned, this function is used to flush the stream aka get rid of the open stream.
    file.close();//<-- This then closes the stream, analogous to closing a toilet when you're finished using it.
    // As learned previously, remember that the file.flush() is ONLY NEEDED when writing to files!


}
void MainWindow::on_actionSave_as_triggered() {
    QString file_name = QFileDialog::getSaveFileName(this,"Open the file");
    // As you should know from QFileDialog video, this opens the QFileDialog.
    // Another thing to know is that you can pass in param #3 to establish a
    // default location for the user to start when they press the open option.
    QFile file(file_name);//<-- This is used to reference the file at the filepath
    // chosen by the user.
    file_path_ = file_name;//<-- This is important because we are writing to the
    // file.

    // We use the code below to WRITE to the file
    if(!file.open(QFile::WriteOnly | QFile::Text)) {
        QMessageBox::warning(this,"..","File not open");
        return;
    }
    // If file is openning is successful:
    QTextStream out(&file);
    QString text = ui->textEdit->toPlainText();//<-- Obtains string of user's session contents.
    ui->textEdit->setText(text);//<-- This is the code repsonsible for user getting their desired file's contents.
    out << text;//<-- Here we use the stream extraction operator to write the text to the file.
    file.flush();//<-- As learned, this function is used to flush the stream aka get rid of the open stream.
    file.close();//<-- This then closes the stream, analogous to closing a toilet when you're finished using it.
    // As learned previously, remember that the file.flush() is ONLY NEEDED when writing to files!



}
void MainWindow::on_actionCut_triggered() {
    ui->textEdit->cut();//<-- Here, we use QTextEdit's
    // cut() function which is pretty self-explantory.

}
void MainWindow::on_actionPaste_triggered() {
    ui->textEdit->paste();//<-- Here, we use QTextEdit's
    // paste() function which is pretty self-explantory.

}
void MainWindow::on_actionRedo_triggered() {
    ui->textEdit->redo();//<-- Here, we use QTextEdit's
    // redo() function which is pretty self-explantory.
}
void MainWindow::on_actionUndo_triggered() {
    ui->textEdit->undo();//<-- Here, we use QTextEdit's
    // undo() function which is pretty self-explantory.
}
// The self-explanatory functions have more complex variants that
// may be useful to look in to.
void MainWindow::on_actionAbout_Notepad_triggered() {
    QString about_text;
    about_text = "Author: Me\n";
    about_text += "Date : 12/9/22\n";
    about_text += "(C) Notepad (R)";
    QMessageBox::about(this,"About Notepad",about_text);
}

void MainWindow::on_actionFont_triggered()
{
    // Here, we change the font based on what user whats.
    bool ok;//<-- This bool value is to check whether any font is selected.
    QFont font = QFontDialog::getFont(&ok,this);//<-- We passed the mem address
    // because of the variable allocated on stack because the required param is of
    // type pointer. Besides that, we use the getFont function to obtain the current
    // font that the user has selected.
    if(ok) {
        // Body of code runs if the font has changed[which is dependent on the user's decision].
        ui->textEdit->setFont(font);
    } else {
        return;
    }

}


void MainWindow::on_actionColor_triggered()
{  // When user selects color action, it allows user to choose a color.
    QColor color = QColorDialog::getColor(Qt::white,this,"Choose Color");
    if(color.isValid()) {
        ui->textEdit->setTextColor(color);//<-- Here, we use this to
        // set the color to the text inside of the input widget.

    }

}


void MainWindow::on_actionBackground_Color_triggered()
{
    // When user selects color action, it allows user to choose a color.
    QColor color = QColorDialog::getColor(Qt::white,this,"Choose Color");
    if(color.isValid()) {
        ui->textEdit->setTextBackgroundColor(color);//<-- Here, we use this to
        // set the color to background of the text.

    }
}


void MainWindow::on_actionNotepad_Color_triggered()
{
    // When user selects color action, it allows user to choose a color.
    QColor color = QColorDialog::getColor(Qt::white,this,"Choose Color");
    if(color.isValid()) {
        ui->textEdit->setPalette(QPalette(color));//<-- Here, we use this to
        // set the color to notepad canvas.[As of 5/13/24: It seems like the palette
        // can only be white or black for some reason].

    }
}


void MainWindow::on_actionPrint_triggered()
{
    // Here, we put the neccessary func to allow user to
    // print out their contents on their notepad.
    QPrinter printer;
    printer.setPrinterName("doublons print inc");//<-- Here, this allows user to set the name of their printer.
    QPrintDialog dialog(&printer,this);
    if(dialog.exec() == QDialog::Rejected) {
        return;
    }
     ui->textEdit->print(&printer);


}

