package weshare.server;

import weshare.controller.*;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Routes {
    public static final String LOGIN_PAGE = "/";
    public static final String LOGIN_ACTION = "/login.action";
    public static final String LOGOUT = "/logout";
    public static final String EXPENSES = "/expenses";
    public static final String REQUESTS_RECEIVED = "/paymentrequests_received";
    public static final String REQUESTS_SENT = "/paymentrequests_sent";
    public static final String NEW_EXPENSE = "/newexpense";
    public static final String EXPENSE_ACTION = "/expense.action";
    public static final String PAYMENT_ACTION = "/payment.action";
    public static final String PAYMENT_REQUEST_ACTION = "/paymentrequest.action";
    public static final String PAYMENT_REQUEST = "/paymentrequest";

    public static void configure(WeShareServer server) {
        server.routes(() -> {
            post(LOGIN_ACTION,  PersonController.login);
            get(LOGOUT,         PersonController.logout);
            get(EXPENSES,           ExpensesController.view);
            get(REQUESTS_SENT,           PaymentRequestsSentController.view);
            get(REQUESTS_RECEIVED,           PaymentRequestsReceivedController.view);
            post(PAYMENT_ACTION,    PaymentRequestsReceivedController.payment);
            get(NEW_EXPENSE,           newExpenseController.view);
            post(EXPENSE_ACTION,  newExpenseController.newExpense);
            get(PAYMENT_REQUEST, PaymentRequestController.view);
            post(PAYMENT_REQUEST_ACTION, PaymentRequestController.request);
        });
    }
}
