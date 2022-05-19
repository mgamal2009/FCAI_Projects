#include "Book.h"

Book::Book() {
	title = "";
	id = count;
	count++;
}

Book::Book(string title, string isbn, string category) {
	this->title = title;
	this->isbn = isbn;
	this->category = category;
	id = count;
	count++;
}

Book::Book(const Book& book) {
	title = book.title;
	isbn = book.isbn;
	category = book.category;
}

void Book::setTitle(string title) {
	this->title = title;
}

string Book::getTitle() {
	return title;
}

void Book::setISBN(string isbn) {
	this->isbn = isbn;
}

string Book::getISBN() {
	return isbn;
}

void Book::setId(int id) {
	this->id = id;
}

int Book::getId() {
	return id;
}

void Book::setCategory(string category) {
	this->category = category;
}

string Book::getCategory() {
	return category;
}

void Book::setAuthor(User user) {
	author = user;
}

User Book::getAuthor() {
	return author;
}

void Book::rateBook(double rating) {
	averageRating = averageRating * numRatings;
	numRatings++;
	averageRating = (averageRating + rating) / numRatings;
}

double Book::getRate() {
	return averageRating;
}

bool Book::operator==(const Book& book)
{
	return (title == book.title && isbn == book.isbn && category == book.category && id == book.id && author == book.author);
}

ostream& operator<<(ostream& output, const Book& book)
{
	output << "Title: " << book.title << " |ISBN: " << book.isbn << " |Id: " << book.id << " |Category: " << book.category << " |Avg Rating: " << book.averageRating;
	return output;
}

istream& operator>>(istream& input, Book& book)
{
	input >> book.title >> book.isbn >> book.category;
	return input;
}

int Book::count = 1;
