package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Expense;
import weshare.model.Person;
import weshare.persistence.ExpenseDAO;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import javax.money.MonetaryAmount;
import java.util.Collection;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static weshare.model.MoneyHelper.amountOf;

import static weshare.model.MoneyHelper.ZERO_RANDS;

public class newExpenseController {

    public static final Handler view = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        Collection<Expense> expenses = expensesDAO.findExpensesForPerson(personLoggedIn);
        MonetaryAmount totalExpense = calculateTotalExpenses(expenses);

        Map<String, Object> viewModel = Map.of("expenses", expenses, "totalExpense", totalExpense);
        context.render("newexpense.html", viewModel);
    };

    public static final Handler newExpense = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);
        String description = context.formParam("description");
        LocalDate date = convertToLocalDate(context.formParam("date"));
        String amount = context.formParam("amount");
        Expense expense = new Expense(personLoggedIn, description, amountOf(Integer.parseInt(amount)), date);
        expensesDAO.save(expense);
        context.redirect(Routes.EXPENSES);
    };

    private static MonetaryAmount calculateTotalExpenses(Collection<Expense> expenses) {
        return expenses.stream()
                .map(Expense::amountLessPaymentsReceived)
                .reduce(ZERO_RANDS, MonetaryAmount::add);
    }

    private static LocalDate convertToLocalDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}    