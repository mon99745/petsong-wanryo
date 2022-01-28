package com.study.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
        /**
         * CatMain
         */
        @GetMapping("/auth/MainMenu/CAT/CatMain")
        public String CatMain() {
            return "MainMenu/CAT/Cat_main.html";
        }

        /**
        * CatSS
        */
        @GetMapping("/auth/MainMenu/CAT/CatSS")
        public String CatSS() {
        return "MainMenu/CAT/Cat_SS.html";
    }

        /**
        * CatFW
        */
        @GetMapping("/auth/MainMenu/CAT/CatFW")
        public String CatFW() {
        return "MainMenu/CAT/Cat_FW.html";
    }
}
