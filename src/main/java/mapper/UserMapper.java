package main.java.mapper;

import main.java.entity.User;

public interface UserMapper {
    public User queryUserByName(String userName);
}
