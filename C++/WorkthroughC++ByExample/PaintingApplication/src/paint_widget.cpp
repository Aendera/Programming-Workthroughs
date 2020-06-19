#include "paint_widget.h"
#include <iostream>
#include <QMouseEvent>
#include <QPainter>
PaintWidget::PaintWidget(QWidget* parent)
	: QWidget(parent)
{
	
}

void PaintWidget::paintEvent(QPaintEvent* event)
{
	QPainter painter(this);
	painter.setRenderHint(QPainter::Antialiasing);
	auto pen = painter.pen();
	pen.setBrush(QBrush(QColor(20,220,15)));
	pen.setJoinStyle(Qt::RoundJoin);
	pen.setCapStyle(Qt::RoundCap);
	pen.setWidth(10);
	painter.setPen(pen);
	//ToDo
	for (const auto& path : painter_paths_) {
		painter.drawPath(path);
	}
	if (!current_path_.isEmpty()) {
		painter.drawPath(current_path_);
	}
}


void PaintWidget::mousePressEvent(QMouseEvent* event)
{
	if (event->button() == Qt::LeftButton) {

		is_drawing_ = true;
		std::cout << "Mouse pressed" << std::endl;
		current_path_.moveTo(event->pos());
	}
}
void PaintWidget::mouseMoveEvent(QMouseEvent* event)
{
	if (is_drawing_) {
		std::cout << "Mouse moving at " << event->pos().x()

			<< ", " << event->pos().y() << std::endl;
		current_path_.lineTo(event->pos());
		update();
	}
}

void PaintWidget::mouseReleaseEvent(QMouseEvent* event)
{
	is_drawing_ = false;
	std::cout << "Mouse released" << std::endl;
	if (event->button() == Qt::LeftButton) {
		current_path_.lineTo(event->pos());
		painter_paths_.emplace_back(current_path_);
		current_path_ = QPainterPath();
	}
	else if (event->button() == Qt::RightButton) {
		current_path_ = QPainterPath();
		painter_paths_.erase(painter_paths_.begin(),painter_paths_.end());
	}
	update();
}