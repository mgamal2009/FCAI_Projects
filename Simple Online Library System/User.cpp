#include "User.h"

User::User()
{
	name = "";
	id = count;
	count++;
}

User::User(string name, int age, string email, string password)
{
	this->name = name;
	this->age = age;
	this->email = email;
	this->password = password;
	id = count;
	count++;
}

User::User(const User& user)
{
	name = user.name;
	age = user.age;
	id = user.id;
	email = user.email;
	password = user.password;
}

bool User::operator==(const User& user)
{
	return (name == user.name && age == user.age && id == user.id && email == user.email);
}

void User::setName(string name)
{
	this->name = name;
}

string User::getName() const
{
	return name;
}

void User::setPassword(string password)
{
	this->password = password;
}

string User::getPassword()
{
	return password;
}

void User::setEmail(string email)
{
	this->email = email;
}

string User::getEmail()
{
	return email;
}

void User::setAge(int age)
{
	this->age = age;
}

int User::getAge()
{
	return age;
}

void User::setId(int id)
{
	this->id = id;
}

int User::getId()
{
	return id;
}

ostream& operator<<(ostream& output, const User& user)
{
	output << "Name: " << user.name << " |Age: " << user.age << " |Id: " << user.id << " |Email: " << user.email;
	return output;
}

istream& operator>>(istream& input, User& user)
{
	input >> user.name >> user.age >> user.email >> user.password;
	return input;
}

int User::count = 1;
