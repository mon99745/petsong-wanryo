package com.study.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    // DOG
    /**
     * DogMain
     */
    @GetMapping("/auth/MainMenu/DOG/DogMain")
    public String DogMain() {
        return "MainMenu/DOG/Dog_main.html";
    }

    /**
     * DogSS
     */
    @GetMapping("/auth/MainMenu/DOG/DogSS")
    public String DogSS() {
        return "MainMenu/DOG/Dog_SS.html";
    }

    /**
     * DogFW
     */
    @GetMapping("/auth/MainMenu/DOG/DogFW")
    public String DogFW() {
        return "MainMenu/DOG/Dog_FW.html";
    }

    //CAT
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

    // LIVING
    /**
     * Bag
     */
    @GetMapping("/auth/MainMenu/LIVING/Bag")
    public String Bag() {
        return "MainMenu/LIVING/Bag.html";
    }

    /**
     * House
     */
    @GetMapping("/auth/MainMenu/LIVING/House")
    public String House() {
        return "MainMenu/LIVING/House.html";
    }

    /**
     * Living_main
     */
    @GetMapping("/auth/MainMenu/LIVING/LivingMain")
    public String Living_main() {
        return "MainMenu/LIVING/Living_main.html";
    }
    /**
     * Toy
     */
    @GetMapping("/auth/MainMenu/LIVING/Toy")
    public String Toy() {
        return "MainMenu/LIVING/Toy.html";
    }

    //FOOD
    /**
     * Food_main
     */
    @GetMapping("/auth/MainMenu/FOOD/FoodMain")
    public String Food_main() {
        return "MainMenu/FOOD/Food_main.html";
    }

    /**
     * Dog_Feed
     */
    @GetMapping("/auth/MainMenu/FOOD/Dog_Feed")
    public String Dog_Feed() {
        return "MainMenu/FOOD/Dog_Feed.html";
    }

    /**
     * Cat_Feed
     */
    @GetMapping("/auth/MainMenu/FOOD/Cat_Feed")
    public String Cat_Feed() {
        return "MainMenu/FOOD/Cat_Feed.html";
    }

    /**
     * community1
     */
    @GetMapping("/auth/MainMenu/COMMUNITY/community1")
    public String community1() {
        return "MainMenu/COMMUNITY/community1.html";
    }

    /**
     * community2
     */
    @GetMapping("/auth/MainMenu/COMMUNITY/community2")
    public String community2() {
        return "MainMenu/COMMUNITY/community2.html";
    }

}
