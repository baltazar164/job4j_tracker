package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        String name = "Item name";
        Input input = new StubInput(new String[]{"0", name, "1"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(name));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String id = Integer.toString(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", Integer.toString(id), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Item changed successfully." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output output =  new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllActionTestOutputIsFailed() {
        Output output =  new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Storage does not contain items" + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output =  new StubOutput();
        Input input = new StubInput(new String[]{"0", "Item2 name", "1"});
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1 name");
        tracker.add(item1);
        Item item2 = new Item("Item2 name");
        tracker.add(item2);
        Item item3 = new Item("Item3 name");
        tracker.add(item3);
        Item item4 = new Item("Item2 name");
        tracker.add(item4);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + item2 + ln
                        + item4 + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameActionTestOutputIsFailed() {
        String name = "Item4 name";
        Output output =  new StubOutput();
        Input input = new StubInput(new String[]{"0", name, "1"});
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1 name");
        tracker.add(item1);
        Item item2 = new Item("Item2 name");
        tracker.add(item2);
        Item item3 = new Item("Item3 name");
        tracker.add(item3);
        Item item4 = new Item("Item2 name");
        tracker.add(item4);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Items with name: " + name + " isn't found." + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output =  new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1 name");
        tracker.add(item1);
        Item item2 = new Item("Item2 name");
        tracker.add(item2);
        Item item3 = new Item("Item3 name");
        tracker.add(item3);
        Item item4 = new Item("Item2 name");
        tracker.add(item4);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        Input input = new StubInput(new String[]{"0", Integer.toString(item2.getId()), "1"});
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + item2 + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsFailed() {
        Output output =  new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1 name");
        tracker.add(item1);
        Item item2 = new Item("Item2 name");
        tracker.add(item2);
        Item item3 = new Item("Item3 name");
        tracker.add(item3);
        Item item4 = new Item("Item2 name");
        tracker.add(item4);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        Input input = new StubInput(new String[]{"0", "9", "1"});
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Item with with input id: 9 isn't found." + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }
}