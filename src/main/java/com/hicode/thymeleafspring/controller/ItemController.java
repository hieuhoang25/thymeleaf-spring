package com.hicode.thymeleafspring.controller;

import com.hicode.thymeleafspring.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("items")
public class ItemController {
    private static final List<Item> ITEMS = List.of(
            new Item(1, "Code", LocalDateTime.now() ),
            new Item(2, "Eat", LocalDateTime.now() ),
            new Item(3, "Sleep", LocalDateTime.now() ),
            new Item(4, "Reset", LocalDateTime.now() )

            );

    @GetMapping
    public String item(@RequestParam("index")Optional<Integer> index, Model model){
        model.addAttribute("index", index.orElse(0));
        model.addAttribute("item", ITEMS.get(index.orElse(0)));
        return "home/item";
    }

}
