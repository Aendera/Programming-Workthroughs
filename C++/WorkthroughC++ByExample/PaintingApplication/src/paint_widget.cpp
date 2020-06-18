#include "paint_widget.h"
#include <iostream>
#include <QMouseEvent>
PaintWidget::PaintWidget(QWidget* parent)
	: QWidget(parent)
{

}

void PaintWidget::paintEvent(QPaintEvent* event)
{
	//ToDo
}


void PaintWidget::mousePressEvent(QMouseEvent* event)
{
	is_drawing_ = true;
	std::cout << "Mouse pressed" << std::endl;
}
void PaintWidget::mouseMoveEvent(QMouseEvent* event)
{
	if (is_drawing_) {
		std::cout << "Mouse moving at " << event->pos().x()

			<< ", " << event->pos().y() << std::endl;
	}
}

void PaintWidget::mouseReleaseEvent(QMouseEvent* event)
{
	is_drawing_ = false;
	std::cout << "Mouse released" << std::endl;
}