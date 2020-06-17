#include "mainwindow.h"
#include "ui_mainwindow.h"

#include <QActionGroup>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    auto action_group = new QActionGroup(this);
    action_group->addAction(ui->actionFreehand);
    action_group->addAction(ui->actionCircles);
    action_group->addAction(ui->actionSquares);

    ui->actionFreehand->setChecked(true);
}

MainWindow::~MainWindow()
{
    delete ui;
}
