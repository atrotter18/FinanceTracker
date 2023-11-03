package track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import track.Repository.ExpenseRepository;
import track.Repository.IncomeRepository;
import track.bean.Expense;
import track.bean.Income;

@Controller
@RequestMapping("/finances")
public class WebController {

	   @Autowired
	    private ExpenseRepository expenseRepository;

	    @Autowired
	    private IncomeRepository incomeRepository;

	    @GetMapping("/")
	    public String listTransactions(Model model) {
	       List<Expense> expenses = expenseRepository.findAll();
	       List<Income> incomes = incomeRepository.findAll();
	        model.addAttribute("expenses", expenses);
	        model.addAttribute("incomes", incomes);
	        return "finances/list";
	    }

	    @GetMapping("/add-expense")
	    public String addExpenseForm(Model model) {
	        model.addAttribute("expense", new Expense());
	        return "finances/expense";
	    }

	    @PostMapping("/add-expense")
	    public String addExpense(@ModelAttribute Expense expense) {
	        expenseRepository.save(expense);
	        return "redirect:/finances/";
	    }

	    @GetMapping("/add-income")
	    public String addIncomeForm(Model model) {
	        model.addAttribute("income", new Income());
	        return "finances/income";
	    }

	    @PostMapping("/add-income")
	    public String addIncome(@ModelAttribute Income income) {
	        incomeRepository.save(income);
	        return "redirect:/finances/";
	    }
}
