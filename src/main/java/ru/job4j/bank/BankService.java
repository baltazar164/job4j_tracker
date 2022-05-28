package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранит и обрабатывает данные клиентов банка и их счетов.
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового клиента банка.
     * @param user клиент для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет счет клиенту банка.
     * @param passport паспорт для поиска клиента
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет клиента банка.
     * @param passport паспорт для поиска клиента
     * @return клиент
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Ищет банковский счет.
     * @param passport паспорт для поиска
     * @param requisite реквизиты для поиска
     * @return банковский счет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Переводит деньги между счетами.
     * @param srcPassport паспорт клиента отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport паспорт клиента получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return выполнен ли перевод
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}