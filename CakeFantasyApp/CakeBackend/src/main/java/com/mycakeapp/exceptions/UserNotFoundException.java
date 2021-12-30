package com.mycakeapp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String error) { super(error);}
}
