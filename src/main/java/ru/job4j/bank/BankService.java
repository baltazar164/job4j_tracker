package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Ищет банковский счет.
     * @param passport паспорт для поиска
     * @param requisite реквизиты для поиска
     * @return банковский счет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.isEmpty() ? Optional.empty() : users.get(user.get()).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty() || srcAccount.get().getBalance() < amount) {
            return false;
        }
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}