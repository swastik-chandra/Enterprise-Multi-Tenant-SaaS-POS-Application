package com.Business.Service;

import com.Business.Execptions.UserException;
import com.Business.Model.User;

import java.util.List;

public interface UserService {
    User getUserFromJwtToken(String Token ) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String email) throws UserException;
    User getUserById(Long Id) throws UserException, Exception;
    List<User> getAllUsers();

}
