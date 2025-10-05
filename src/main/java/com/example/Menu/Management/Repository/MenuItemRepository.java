package com.example.Menu.Management.Repository;

import com.example.Menu.Management.Service.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    // Find items by category
    List<MenuItem> findByCategory(String category);

    // Find items by availability
    List<MenuItem> findByAvailable(boolean available);
}
