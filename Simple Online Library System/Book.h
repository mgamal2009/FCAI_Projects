#include "User.h"
using namespace std;
#ifndef BOOK_H
#define BOOK_H

class Book
{
private:
	string title;
	string isbn;
	int id = 1;
	string category;
	double averageRating = 0.0;
	int numRatings = 0;
	User author;
public:
	static int count;
	// Default Constructor.
	Book();
	// Constructor that intializes the title, isbn, category, has threee parametrs: (string title, string isbn, string category, and has no return value.
	Book(string title, string isbn, string category);
	// Copy constructor that intializes and object with contnets of another object, takes one parameter: const Book& book, and has no return value.
	Book(const Book& book);
	// Mutator function that sets the title of the book, takes one parameter: string title, and has no return value.
	void setTitle(string title);
	// Mutator function that gets the title of the book, takes no parameters, has a string return value.
	string getTitle();
	// Mutator function that sets the isbn of the book, takes one parameter: string isbn, and has no return value.
	void setISBN(string isbn);
	// Mutator function that gets the isbn of the book, takes no parameters, has a string return value.
	string getISBN();
	// Mutator function that sets the id of the book, takes one parameter: int id, and has no return value.
	void setId(int id);
	// Mutator function that gets the id of the book, takes no parameters, has an int return value.
	int getId();
	// Mutator function that sets the category of the book, takes one parameter: string category, and has no return value.
	void setCategory(string category);
	// Mutator function that gets the category of the book, takes no parameters, has a string return value.
	string getCategory();
	// Mutator function that sets the author of the book, takes one parameter: User user, and has no return value.
	void setAuthor(User user);
	// Mutator function that gets the author of the book, takes no parameters, has a User return value.
	User getAuthor();
	// This function should update averageRating attribute as a new rating is introduced to the book so the average rating should be affected.
	void rateBook(double rating);
	// Mutator function that gets the  of the book, takes no parameters, has a double return value.
	double getRate();
	// Operator == overloading function, takes one parameter: const User& user, and has a bool return value.
	bool operator==(const Book& book);
	// Operator << overloading, takes two parametrs: ostream& output, const User& user, and has an ostream& return value.
	friend ostream& operator<<(ostream& output, const Book& book);
	// Operator >> overloading, takes two parametrs: istream& output, User& user, and has an istream& return value.   
	friend istream& operator>>(istream& input, Book& book);

};
#endif // !BOOK_H
