package com.chingu.stocks.controller;

import com.chingu.stocks.dao.UserDAO;
import com.chingu.stocks.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String homePage() {
    UserDAO userDao = new UserDAO();

    User user = new User("test","testpass","display","emailtest",100,100);
    userDao.saveUser(user);

    return "index";
  }
}
