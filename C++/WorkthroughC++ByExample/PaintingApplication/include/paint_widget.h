#pragma once
#include <QWidget>
#include <QPainterPath>
class PaintWidget : public QWidget
{
	Q_OBJECT

public:
	PaintWidget(QWidget* parent = Q_NULLPTR);

protected:
	void paintEvent(QPaintEvent* event) override;

	void mousePressEvent(QMouseEvent* event) override;
	void mouseMoveEvent(QMouseEvent* event) override;
	void mouseReleaseEvent(QMouseEvent* event) override;

private:
	bool is_drawing_{ false };
	std::vector<QPainterPath> painter_paths_;
	QPainterPath current_path_;
};