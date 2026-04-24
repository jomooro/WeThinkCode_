package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Expense;
import weshare.model.PaymentRequest;
import weshare.model.Person;
import weshare.persistence.ExpenseDAO;
import weshare.persistence.PersonDAO;
import weshare.server.ServiceRegistry;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

import static weshare.model.MoneyHelper.amountOf;
import static weshare.model.MoneyHelper.ZERO_RANDS;

public class PaymentRequestController {

    public static final Handler view = context -> {
        ExpenseDAO expenseDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        String expenseId = context.queryParam("expenseId");
        Expense expense = expenseDAO.get(UUID.fromString(expenseId)).get();
        MonetaryAmount totalPaymentRequests = calculateTotalPaymentReceived(expense);

        int netExpense = expense.getAmount().getNumber().intValue() - totalPaymentRequests.getNumber().intValue();
        MonetaryAmount maxMoney = amountOf(netExpense);

        context.render("paymentrequests.html", Map.of("expense", expense,
                "paymentRequests", expense.listOfPaymentRequests(),
                "grandTotal", totalPaymentRequests,
                "maximumAmount", netExpense,
                "maximumMoney", maxMoney));
    };

    public static final Handler request = context -> {
        ExpenseDAO expenseDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        String expenseId = context.formParam("expenseId");
        Expense expense = expenseDAO.get(UUID.fromString(expenseId)).get();
        String email = context.formParam("email");
        Person person = ServiceRegistry.lookup(PersonDAO.class).findPersonByEmail(email).get();
        LocalDate date = convertToLocalDate(context.formParam("due_date"));
        int amount = Integer.parseInt(context.formParam("amount"));

        expense.requestPayment(person, amountOf(amount), date);

        String redirectionURL = "paymentrequest?expenseId=" + expenseId;
        context.redirect(redirectionURL);
    };

    private static LocalDate convertToLocalDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static MonetaryAmount calculateTotalPaymentReceived(Expense expense) {
        return expense.listOfPaymentRequests().stream()
                .map(PaymentRequest::getAmountToPay)
                .reduce(ZERO_RANDS, MonetaryAmount::add);
    }
}
