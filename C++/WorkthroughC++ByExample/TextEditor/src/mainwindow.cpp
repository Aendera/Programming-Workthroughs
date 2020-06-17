#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <iostream>
MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    QObject::connect(ui->plainTextEdit, &QPlainTextEdit::textChanged,
        [&]() {std::cout << "Text has changed." << std::endl; });

    QObject::connect(ui->actionSave, &QAction::triggered,
        [&]() {ui->plainTextEdit->appendPlainText("Save triggered"); });
    QObject::connect(ui->actionOpen, &QAction::triggered,
        [&]() {ui->plainTextEdit->appendPlainText("Open triggered"); });

}

MainWindow::~MainWindow()
{
    delete ui;
}
