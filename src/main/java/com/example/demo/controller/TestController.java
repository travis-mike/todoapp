package com.example.demo.controller;

import com.example.demo.data.Item;
import com.example.demo.data.ItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TestController {

    @Autowired
    private ItemList listOfItems;


    @GetMapping("/todoapp")
    public String formGet (Model model) {
        model.addAttribute("item", new Item());
        List<Item> allItems = listOfItems.getItemList();
        model.addAttribute("items", allItems);
        return "mainpage";
        }

    @PostMapping("/todoapp")
    public String formPost (@ModelAttribute Item item) {
        List<Item>itemList = new ArrayList<>();
        listOfItems.addItem(item);
        return "redirect:/todoapp";
        }

    }


