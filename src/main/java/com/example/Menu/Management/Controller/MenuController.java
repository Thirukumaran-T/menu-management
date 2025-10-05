package com.example.Menu.Management.Controller;

import com.example.Menu.Management.Service.MenuItem;
import com.example.Menu.Management.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return service.addMenuItem(item);
    }

    @GetMapping("/list")
    public List<MenuItem> getAllMenuItems() {
        return service.getAllMenuItems();
    }

    @GetMapping("/category/{category}")
    public List<MenuItem> getByCategory(@PathVariable String category) {
        return service.getMenuItemsByCategory(category);
    }

    @PutMapping("/update/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem item) {
        return service.updateMenuItem(id, item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        service.deleteMenuItem(id);
    }

    @PatchMapping("/toggle/{id}")
    public MenuItem toggleAvailability(@PathVariable Long id) {
        return service.toggleAvailability(id);
    }
}
