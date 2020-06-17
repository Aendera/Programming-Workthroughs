/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 5.15.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QAction *actionFreehand;
    QAction *actionCircles;
    QAction *actionSquares;
    QWidget *centralwidget;
    QVBoxLayout *verticalLayout;
    QWidget *widget;
    QMenuBar *menubar;
    QMenu *menuPaint;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(800, 600);
        actionFreehand = new QAction(MainWindow);
        actionFreehand->setObjectName(QString::fromUtf8("actionFreehand"));
        actionFreehand->setCheckable(true);
        actionFreehand->setChecked(true);
        actionCircles = new QAction(MainWindow);
        actionCircles->setObjectName(QString::fromUtf8("actionCircles"));
        actionCircles->setCheckable(true);
        actionSquares = new QAction(MainWindow);
        actionSquares->setObjectName(QString::fromUtf8("actionSquares"));
        actionSquares->setCheckable(true);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        verticalLayout = new QVBoxLayout(centralwidget);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        widget = new QWidget(centralwidget);
        widget->setObjectName(QString::fromUtf8("widget"));

        verticalLayout->addWidget(widget);

        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 800, 21));
        menuPaint = new QMenu(menubar);
        menuPaint->setObjectName(QString::fromUtf8("menuPaint"));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        menubar->addAction(menuPaint->menuAction());
        menuPaint->addAction(actionFreehand);
        menuPaint->addAction(actionCircles);
        menuPaint->addAction(actionSquares);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        actionFreehand->setText(QCoreApplication::translate("MainWindow", "Freehand", nullptr));
        actionCircles->setText(QCoreApplication::translate("MainWindow", "Circles", nullptr));
        actionSquares->setText(QCoreApplication::translate("MainWindow", "Squares", nullptr));
        menuPaint->setTitle(QCoreApplication::translate("MainWindow", "Paint", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
