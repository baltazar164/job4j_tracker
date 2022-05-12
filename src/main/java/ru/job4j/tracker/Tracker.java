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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item bugWithDesc) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            bugWithDesc.setId(id);
            items[index] = bugWithDesc;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            if (index == size - 1) {
                items[index] = null;
            } else {
                int length = size - 1 - index;
                System.arraycopy(items, index + 1, items, index, length);
                items[size - 1] = null;
            }
            size--;
        }
        return rsl;
    }
}