package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Expense;
import weshare.model.Person;
import weshare.persistence.ExpenseDAO;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import javax.money.MonetaryAmount;

import java.util.Collection;
import java.util.Map;


import static weshare.model.MoneyHelper.ZERO_RANDS;

public class ExpensesController {

    public static final Handler view = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        Collection<Expense> expenses = expensesDAO.findExpensesForPerson(personLoggedIn);
        MonetaryAmount total = calculateTotalExpenses(expenses);

        Map<String, Object> viewModel = Map.of("expenses", expenses, "total", total);
        context.render("expenses.html", viewModel);
    };

    private static MonetaryAmount calculateTotalExpenses(Collection<Expense> expenses) {
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(ZERO_RANDS, MonetaryAmount::add);
    }
}