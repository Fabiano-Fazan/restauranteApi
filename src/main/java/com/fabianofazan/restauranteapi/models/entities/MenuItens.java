package com.fabianofazan.restauranteapi.models.entities;
import com.fabianofazan.restauranteapi.models.enums.MenuItem;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MenuItens {

    private MenuItem menuItem;
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
