package main.com.mapper;

import main.com.entity.User;

public interface UserMapper {
    public User queryUserByName(String userName);
}
