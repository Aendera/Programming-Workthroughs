#include "paint_widget.h"
#include <iostream>
#include <QMouseEvent>
#include <QPainter>
PaintWidget::PaintWidget(QWidget* parent)
	: QWidget(parent)
{
	current_style_ = Freehand;
}
void PaintWidget::setPaintStyle(const PaintStyle& style) {
	current_style_ = style;
}

PaintStyle PaintWidget::paintStyle() const
	{
		return current_style_;
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
		switch (current_style_)
		{
		case Freehand:

			is_drawing_ = true;
			current_path_.moveTo(event->pos());
			break;
		case Circles:
			break;
		case Squares:
			break;
		}
	}
}
void PaintWidget::mouseMoveEvent(QMouseEvent* event)
{
	if (is_drawing_) {
		switch (current_style_)
		{
		case Freehand:

			current_path_.lineTo(event->pos());
			update();
			break;
		case Circles:
			break;
		case Squares:
			break;
		}
	}
}

void PaintWidget::mouseReleaseEvent(QMouseEvent* event)
{
	is_drawing_ = false;
	if (event->button() == Qt::LeftButton) {
		switch (current_style_)
		{
		case Freehand:

			current_path_.lineTo(event->pos());
			break;
		case Circles:
			current_path_.addEllipse(event->pos(), 20.0, 20.0);
			break;
		case Squares:
			current_path_.addRect(event->x(), event->y(), 40.0, 40.0);
			break;
		}
		painter_paths_.emplace_back(current_path_);
		current_path_ = QPainterPath();
	}
	else if (event->button() == Qt::RightButton) {
		current_path_ = QPainterPath();
		painter_paths_.erase(painter_paths_.begin(),painter_paths_.end());
	}
	update();
}