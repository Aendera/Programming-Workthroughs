
#include "book_library.h"
#include <algorithm>

book_library::book_library(const std::vector<book>& books)
	:books_(books)
{


}
book book_library::find_book_by_title(const std::string & title) 
	{
	//TODO
		return {"Title","Author","Genre"};
	}

std::vector<book> book_library::find_books_by_author(const std::string & author)
	{	
		//TODO
		return books_;
	}

std::vector<book> book_library::books() const
{
		//TODO
	return books_;
}

std::vector<book> book_library::sort_books()
{
	std::sort(books_.begin(), books_.end());
	return books_; 
}