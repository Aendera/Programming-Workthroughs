
#include "book_library.h"
#include <algorithm>

book_library::book_library(const std::vector<book>& books)
	:books_(books)
{


}
book book_library::find_book_by_title(const std::string& title)
{
	//Return exact match [1]
	//iterate and return book for item.title==title
	for (auto item : books_) {
		if (item.title == title) {
			return item;
		}
	}
		return book{};
	//suggested solution made use of find_if and lambda.
	}

std::vector<book> book_library::find_books_by_author(const std::string & author)
	{	
	//Return all books by that Author
		//iterate and append to book list books with book.author==author
	std::vector<book> author_books;
	for (auto item : books_) {
		if (item.author == author) {
			author_books.push_back(item);
		}
	}
	return author_books;
	}

std::vector<book> book_library::books() const
{
	return books_;
}

std::vector<book> book_library::sort_books()
{
	std::sort(books_.begin(), books_.end());
	return books_; 
}