package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            if (this.items[index] != null) {
                rsl[size] = this.items[index];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                rsl[size] = this.items[index];
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}