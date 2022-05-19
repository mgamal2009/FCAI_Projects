//This application is made by Visual Studio 2019 IDE
//This program purpose is to be an online library system.
//This system can store the data of the users and each book with details and set the author of each book and its rate.


#include "Book.h"
#include "User.h"



void userOutput() {
	cout << "Enter the user information in this order" << endl;
	cout << "Name Age Email Password (Space separated)" << endl;
}
void bookOutput() {
	cout << "Enter the book information in this order" << endl;
	cout << "Title ISBN Category (Space separated)" << endl;
}
void lineBreak() {
	cout << "========================================" << endl << endl;
}
void userInfo(int id) {
	cout << endl << "========== User " << id << " info==========" << endl;
}
void bookInfo(int id) {
	cout << endl << "========== Book " << id << " info==========" << endl;
}

int main()
{
	cout << "Let's add a user" << endl;
	userOutput();
	User u1;
	cin >> u1;
	userInfo(u1.getId());
	cout << u1 << endl;
	lineBreak();
	cout << "Let's add another user" << endl;
	userOutput();
	User u2;
	cin >> u2;
	userInfo(u2.getId());
	cout << u2 << endl;
	lineBreak();
	cout << "Let's add a book" << endl;
	bookOutput();
	Book b1;
	cin >> b1;
	bookInfo(b1.getId());
	cout << b1 << endl;
	lineBreak();
	cout << "Let's add another book" << endl;
	bookOutput();
	Book b2;
	cin >> b2;
	bookInfo(b2.getId());
	cout << b2 << endl;
	lineBreak();
	cout << "Let's assign an author for the first book, set the first user as an author" << endl;
	cout << "Let's rate the first book with 3 and 4 ratings and print the book info" << endl;
	b1.setAuthor(u1);
	b1.rateBook(3);
	b1.rateBook(4);
	bookInfo(b1.getId());
	cout << b1 << endl;
	userInfo(b1.getAuthor().getId());
	cout << b1.getAuthor() << endl;
	cout << "Let's add a new rating for b1 with 5 and print the book info" << endl;
	b1.rateBook(5);
	bookInfo(b1.getId());
	cout << b1 << endl;
	userInfo(b1.getAuthor().getId());
	cout << b1.getAuthor() << endl;
	lineBreak();

}
