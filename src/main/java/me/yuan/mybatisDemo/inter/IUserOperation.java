package me.yuan.mybatisDemo.inter;

import java.util.List;

import me.yuan.mybatisDemo.model.User;

public interface IUserOperation {    
    public User selectUserByID(int id);
    public List<User> selectUsers(String userName);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
