package ru.job4j.tracker;

public class StartUI {

    private void showMenu(UserAction[] menu) {
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i].name());
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            run = actions[select].execute(input, tracker);
        }
    }

    private static UserAction[] createActions() {
        return new UserAction[]{
                new CreateItem(),
                new ShowAllItems(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindItemById(),
                new FindItemsByName(),
                new Exit()
        };
    }

    public static void main(String[] args) {
        Input scanner = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = createActions();
        new StartUI().init(scanner, tracker, actions);
    }
}