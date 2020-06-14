#include <iostream>
#include "application.h"
#include "book_library_parser.h"
#include <iterator>

void print_books(const std::vector<book>& books)
{
	std::copy(books.begin(), books.end(),
		std::ostream_iterator<book>(std::cout, "\n"));
}
int main() {
	application app;
	std::cout << "-------- Book Library ---------" << std::endl;
	book_library_parser parser;
	const auto path = std::string(DATA_DIRECTORY) + "/books.csv";
	auto library = parser.load_book_library(path);

	do {
		//get user input
		auto input = app.get_action();
		auto action = app.get_action_input(input); 
		//do something with user input
		switch (action) {

		case application::app_action::none:
			if (input == '1')
			{
				print_books(library.books());
			}
			break;
		case application::app_action::sort:
		{
			auto sorted_books = library.sort_books();
			print_books(sorted_books);
		}
		break;
		case application::app_action::save_library:
		{
			parser.save_book_library(library, "books.csv");
			break;
		}
		}
	} while (app.continue_running());
	return 0;
}