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
    QObject::connect(ui->actionFreehand, SIGNAL(triggered()),
        this, SLOT(onDrawFreehandSelected()));
    QObject::connect(ui->actionCircles, SIGNAL(triggered()),
        this, SLOT(onDrawCirclesSelected()));
    QObject::connect(ui->actionSquares, SIGNAL(triggered()),
        this, SLOT(onDrawSquaresSelected()));
}
void MainWindow::onDrawFreehandSelected() {
    ui->paint_widget->setPaintStyle(Freehand);
}

void MainWindow::onDrawCirclesSelected() {
    ui->paint_widget->setPaintStyle(Circles);
}

void MainWindow::onDrawSquaresSelected() {
    ui->paint_widget->setPaintStyle(Squares);
}
MainWindow::~MainWindow()
{
    delete ui;
}
