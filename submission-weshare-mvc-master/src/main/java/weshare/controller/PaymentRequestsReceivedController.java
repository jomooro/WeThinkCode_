package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Payment;
import weshare.model.PaymentRequest;
import weshare.model.Person;
import weshare.persistence.ExpenseDAO;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import javax.money.MonetaryAmount;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;


import static weshare.model.MoneyHelper.ZERO_RANDS;

public class PaymentRequestsReceivedController {
    
    public static final Handler view = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        Collection<PaymentRequest> paymentReceived = expensesDAO.findPaymentRequestsReceived(personLoggedIn);
        MonetaryAmount totalPaymentReceived = calculateTotalPaymentReceived(paymentReceived);

        context.render("paymentrequests_received.html", Map.of(
            "paymentRequestsReceived", paymentReceived,
            "totalPaid", totalPaymentReceived
        ));
    };

    public static final Handler payment = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);
        
        String paymentRequestId = context.formParam("paymentRequestId");
        Collection<PaymentRequest> paymentReceived = expensesDAO.findPaymentRequestsReceived(personLoggedIn);
        PaymentRequest paidPaymentRequest = findPaymentRequest(paymentRequestId, paymentReceived);
        Payment newPayment = paidPaymentRequest.pay(personLoggedIn, LocalDate.now());
        expensesDAO.save(newPayment.getExpenseForPersonPaying());
        context.redirect(Routes.REQUESTS_RECEIVED);
    };

    private static MonetaryAmount calculateTotalPaymentReceived(Collection<PaymentRequest> paymentRequests) {
        return paymentRequests.stream()
                .map(PaymentRequest::getAmountToPay)
                .reduce(ZERO_RANDS, MonetaryAmount::add);
    }    

    private static PaymentRequest findPaymentRequest(String targetPaymentRequestId, Collection<PaymentRequest> paymentReceived) {
        return paymentReceived.stream()
                .filter(paymentRequest -> paymentRequest.getId().toString().equals(targetPaymentRequestId))
                .findFirst()
                .orElse(null);
    }
}
