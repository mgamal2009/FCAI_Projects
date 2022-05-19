#include <iostream>
using namespace std;

#ifndef USER_H
#define USER_H

class User
{
private:
    string name;
    int age;
    int id = 1; 
    string email;
    string password;
public:
    static int count;
    // Default Constructor that intializes name to an empty string, Tkes no parapeters and has no return value.
    User();
    // Constructor that intializes the name, age, email, and passowrd to the provided parameetrs, tkaes 4 parameters: string name, int age, string email, string password, and has no return value. 
    User(string name, int age, string email, string password);
    // Copy constructor that intializes and object with contnets of another object, takes one parameter: const User& user, and has no return value.
    User(const User& user);
    // Operator == overloading function, takes one parameter: const User& user, and has a bool return value.
    bool operator==(const User& user);
    // Mutator function that sets the name of the user, takes one parameter: string name, and has no return value.
    void setName(string name);
    // Mutator function that gets the name of the user, and has a string return value.
    string getName() const;
    // Mutator function that sets the password of the user, takes one parameter: string password, and has no return value.
    void setPassword(string password);
    // Mutator function that gets the password of the user, and has a string return value.
    string getPassword();
    // Mutator function that sets the email of the user, takes one parameter: string email, and has no return value.
    void setEmail(string email);
    // Mutator function that gets the email of the user, and has a string return value.
    string getEmail();
    // Mutator function that sets the age of the user, takes one parameter: int age, and has no return value.
    void setAge(int age);
    // Mutator function that gets the age of the user, and has an int return value.
    int getAge();
    // Mutator function that sets the id of the user, takes one parameter: int id, and has no return value.
    void setId(int id);
    // Mutator function that gets the id of the user, and has an int return value.
    int getId();
    // Operator << overloading, takes two parametrs: ostream& output, const User& user, and has an ostream& return value.
    friend ostream& operator<<(ostream& output, const User& user);
    // Operator >> overloading, takes two parametrs: istream& output, User& user, and has an istream& return value.
    friend istream& operator>>(istream& input, User& user);
};


#endif // !USER_H



