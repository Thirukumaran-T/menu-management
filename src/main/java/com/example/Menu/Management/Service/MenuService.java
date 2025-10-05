package com.example.Menu.Management.Service;

import com.example.Menu.Management.Repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuItemRepository menuItemRepository;

    public MenuService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem addMenuItem(MenuItem item) {
        return menuItemRepository.save(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getMenuItemsByCategory(String category) {
        return menuItemRepository.findByCategory(category);
    }

    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
        Optional<MenuItem> existing = menuItemRepository.findById(id);
        if (existing.isPresent()) {
            MenuItem item = existing.get();
            item.setName(updatedItem.getName());
            item.setDescription(updatedItem.getDescription());
            item.setPrice(updatedItem.getPrice());
            item.setCategory(updatedItem.getCategory());
            item.setAvailable(updatedItem.getAvailable());
            return menuItemRepository.save(item);
        }
        return null;
    }

    public String deleteMenuItem(Long id) {
        if (menuItemRepository.existsById(id)) {
            menuItemRepository.deleteById(id);
            return "Menu item deleted successfully!";
        }
        return "Menu item not found!";
    }

    public MenuItem toggleAvailability(Long id) {
        Optional<MenuItem> item = menuItemRepository.findById(id);
        if (item.isPresent()) {
            MenuItem menuItem = item.get();
            menuItem.setAvailable(!menuItem.getAvailable());
            return menuItemRepository.save(menuItem);
        }
        return null;
    }
}
