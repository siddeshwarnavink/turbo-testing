package sidd33.turbotesting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import jakarta.validation.Valid;
import sidd33.turboengine.forms.annotation.WithForm;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/form")
    @WithForm(TestForm.class)
    public String getTestRoot(Model model) {
        model.addAttribute("formData", new TestForm());
        return "form";
    }

    @PostMapping(value = "/form")
    @WithForm(TestForm.class)
    public ModelAndView postTestRoot(@Valid TestForm formData, BindingResult result) {
        System.out.println(formData);

        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("form");
            modelAndView.addObject("formData", formData);
            return modelAndView;
        }

        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    private List<ProductDto> getProducts() {
        String sql = "SELECT * FROM products";
        List<ProductDto> products = jdbcTemplate.query(sql, new ProductRowMapper());
        return products;
    }

    @GetMapping(value = "/datatable")
    public String getTable(Model model) {
        List<ProductDto> products = getProducts();
        model.addAttribute("products", products);

        return "table";
    }
}
