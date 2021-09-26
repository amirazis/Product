package asia.fourtitude.java.sboot.Product.web.restcontroller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import asia.fourtitude.java.sboot.Product.entity.Product;
import asia.fourtitude.java.sboot.Product.service.ProductService;

@RestController 
@RequestMapping("/api/products")
public class ProductRestContoller {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}

//	@RequestMapping("/addEditProduct")
//	public ModelAndView addEditProduct () {
//	    ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("addEditProduct");
//	    return modelAndView;
//	}

//	@RequestMapping("/addEditProduct")
//	protected ResponseEntity handleFoo(HttpServletResponse response) throws IOException {
//		response.sendRedirect("addEditProduct");
//	return null;
//	}

//    @GetMapping("/addEditProduct")
//    public String addEditProduct() {
//    	System.out.println(("54"));
//        return "addEditProduct";
//    }
    
//	@RequestMapping("/addEditProduct")
//	void handleFoo(HttpServletResponse response) throws IOException {
//		response.sendRedirect("addEditProduct");
//	}

    @PostMapping(value = "/addEditProduct")
    public ResponseEntity<Void> redirect(){
 
        System.out.println("66");
 
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/addEditProduct")).build();
    }

//    @RequestMapping("/addEditProduct")
//    public RedirectView handleFoo() {
//        return new RedirectView("addEditProduct");
//    }
//    
	@RequestMapping(value = {"","/"})
	public List<Product> landingPage() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = {"/{code}"})
	public Product getProduct(@PathVariable String code) {
		return productService.getProduct(code);
	}
	
	@PostMapping(value = {"","/"})
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@PutMapping(value = {"/{code}"})
	public void updateProduct(@RequestBody Product product, @PathVariable String code) {
		productService.updateProduct(product, code);
	}
	
	@DeleteMapping(value = {"/{code}"})
	public void deleteProduct(@PathVariable String code) {
		productService.deleteProduct(code);
	}

}
