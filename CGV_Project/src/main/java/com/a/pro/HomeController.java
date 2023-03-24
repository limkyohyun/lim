package com.a.pro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
   @RequestMapping(value="/")
   public String ko1() {
      return "main";
   }
   @RequestMapping(value="/main")
   public String ko2() {
      return "main";
   }
}