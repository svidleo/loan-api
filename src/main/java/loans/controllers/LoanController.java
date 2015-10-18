package loans.controllers;

import loans.beans.request.Customer;
import loans.beans.response.Loan;
import loans.exceptions.ExceedLoanLimitException;
import loans.exceptions.MonthlyPaymentException;
import loans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanController extends BaseController {

    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/get-loan", method = RequestMethod.POST)
        public Loan getLoan(@Valid @RequestBody Customer customer) throws MonthlyPaymentException, ExceedLoanLimitException {
        return loanService.getLoan(customer);
    }

}
