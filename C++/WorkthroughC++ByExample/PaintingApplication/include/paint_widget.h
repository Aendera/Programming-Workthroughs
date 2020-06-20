#pragma once
#include <QWidget>
#include <QPainterPath>
enum  PaintStyle {
	Freehand,
	Circles,
	Squares
};
class PaintWidget : public QWidget
{
	Q_OBJECT

public:
	PaintWidget(QWidget* parent = Q_NULLPTR);
	void setPaintStyle(const PaintStyle& style);
	PaintStyle paintStyle() const;
protected:
	void paintEvent(QPaintEvent* event) override;

	void mousePressEvent(QMouseEvent* event) override;
	void mouseMoveEvent(QMouseEvent* event) override;
	void mouseReleaseEvent(QMouseEvent* event) override;

private:
	bool is_drawing_{ false };
	std::vector<QPainterPath> painter_paths_;
	QPainterPath current_path_;
	PaintStyle current_style_;
};