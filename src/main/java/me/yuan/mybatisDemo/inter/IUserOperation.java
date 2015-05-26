package me.yuan.mybatisDemo.inter;

import me.yuan.mybatisDemo.model.User;

public interface IUserOperation {    
    public User selectUserByID(int id);
}
