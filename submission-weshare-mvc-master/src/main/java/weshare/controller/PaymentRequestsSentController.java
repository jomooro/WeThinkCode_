package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.PaymentRequest;
import weshare.model.Person;
import weshare.persistence.ExpenseDAO;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import javax.money.MonetaryAmount;
import java.util.Collection;
import java.util.Map;

import static weshare.model.MoneyHelper.ZERO_RANDS;

public class PaymentRequestsSentController {

    public static final Handler view = context -> {
        ExpenseDAO expensesDAO = ServiceRegistry.lookup(ExpenseDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        Collection<PaymentRequest> paymentRequests = expensesDAO.findPaymentRequestsSent(personLoggedIn);
        MonetaryAmount totalUnpaid = calculateTotalPaymentReceived(paymentRequests);

        Map<String, Object> viewModel = Map.of("paymentRequestsSent", paymentRequests, "totalUnpaid", totalUnpaid);
        context.render("paymentrequests_sent.html", viewModel);
    };

    private static MonetaryAmount calculateTotalPaymentReceived(Collection<PaymentRequest> paymentRequests) {
        return paymentRequests.stream()
                .map(PaymentRequest::getAmountToPay)
                .reduce(ZERO_RANDS, MonetaryAmount::add);
    }
}
