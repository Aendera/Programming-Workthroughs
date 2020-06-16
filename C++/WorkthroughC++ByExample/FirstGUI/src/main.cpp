#include <QApplication>
#include <QMainWindow>


int main(int argc, char* argv[])
{
	QApplication app(argc, argv);

	QMainWindow main_window;

	main_window.setMinimumSize(800, 450);
	main_window.setWindowTitle("Hello World");
	main_window.show();
	return app.exec();
}