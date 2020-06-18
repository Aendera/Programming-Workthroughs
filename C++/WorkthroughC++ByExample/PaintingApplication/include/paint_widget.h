#pragma once
#include <QWidget>

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
};