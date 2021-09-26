package asia.fourtitude.java.sboot.Product.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import asia.fourtitude.java.sboot.Product.dto.ProductDto;
import asia.fourtitude.java.sboot.Product.entity.Product;
import asia.fourtitude.java.sboot.Product.service.ProductService;

//@Controller
public class ProductController {

	private static final String TEMPLATE_LIST_PRODUCT = "ProductLandingPage";
	private static final String TEMPLATE_ADD_PRODUCT = "addProduct";
	private static final String TEMPLATE_UPDATE_PRODUCT = "updateProduct";

	private static final String ATT_PRODUCT = "Products";
	private static final String ATT_ADD_PRODUCT_PAGE = "addProductPage";
	private static final String ATT_UPDATE_PRODUCT_PAGE = "updateProductPage";
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String landingPage(@ModelAttribute(ATT_PRODUCT)ProductDto ProductDto,Model model){
		model.addAttribute(ATT_PRODUCT,ProductService.getAllProducts());
		return TEMPLATE_LIST_PRODUCT;
	} 
	
    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.GET)
	public String getAddProduct(@ModelAttribute(ATT_ADD_PRODUCT_PAGE)ProductDto ProductDto,Model model){
		if (!model.containsAttribute(ATT_ADD_PRODUCT_PAGE)) {
			model.addAttribute(ATT_ADD_PRODUCT_PAGE,ProductDto);
		} 
		return TEMPLATE_ADD_PRODUCT; 
	} 
    
	@PostMapping(value = { "/addProduct" })
	public String getAddProduct(@ModelAttribute(ATT_ADD_PRODUCT_PAGE)ProductDto ProductDto, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, Locale locale, @RequestParam(required = false) String _eventId_mode) {
		if (_eventId_mode.equalsIgnoreCase("save")) {
			Product Product = new Product();
			if (ProductDto.getCode() != null){
				if (!ProductDto.getCode().isEmpty()){
					Product.setCode(ProductDto.getCode());
				}
			}
			if (ProductDto.getName() != null){
				if (!ProductDto.getName().isEmpty()){
					Product.setName(ProductDto.getName());
				}
			}
			if (ProductDto.getCategory() != null){
				if (!ProductDto.getCategory().isEmpty()){
					Product.setCategory(ProductDto.getCategory());
				}
			}
			if (ProductDto.getBrand() != null){
				if (!ProductDto.getBrand().isEmpty()){
					Product.setBrand(ProductDto.getBrand());
				}
			}
			if (ProductDto.getType() != null){
				if (!ProductDto.getType().isEmpty()){
					Product.setType(ProductDto.getType());
				}
			}
			if (ProductDto.getDescription() != null){
				if (!ProductDto.getDescription().isEmpty()){
					Product.setDescription(ProductDto.getDescription());
				}
			}
			ProductService.addProduct(Product);
		}
		return "redirect:/";
	}
	
    @GetMapping(value = {"/updateProduct/{code}"})
	public String getUpdateProduct(@RequestParam(value="id", required = false) Long id,@ModelAttribute(ATT_UPDATE_PRODUCT_PAGE)ProductDto ProductDto,Model model){
		Product ProductEntity = ProductService.getProductbyCode(ProductDto.getCode());
		if (ProductEntity != null) {
			ProductDto.setCode(ProductEntity.getCode());
			ProductDto.setName(ProductEntity.getName());
			ProductDto.setCategory(ProductEntity.getCategory());
			ProductDto.setBrand(ProductEntity.getBrand());
			ProductDto.setType(ProductEntity.getType());
			ProductDto.setDescription(ProductEntity.getDescription());
		}
		if (!model.containsAttribute(ATT_UPDATE_PRODUCT_PAGE)) {
			model.addAttribute(ATT_UPDATE_PRODUCT_PAGE,ProductDto);
		}
		model.addAttribute("code", ProductDto.getCode());
		return TEMPLATE_UPDATE_PRODUCT; 
	} 
    
    @RequestMapping(value = { "/updateProduct/{id}" }, method = RequestMethod.POST)
	public String getUpdateProduct(@ModelAttribute(ATT_UPDATE_PRODUCT_PAGE)ProductDto ProductDto, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, Locale locale, @RequestParam(required = false) String _eventId_mode) {
		if (_eventId_mode.equalsIgnoreCase("update")) {
			Product Product = new Product();
			if (ProductDto.getCode() != null){
				if (!ProductDto.getCode().isEmpty()){
					Product.setCode(ProductDto.getCode());
				}
			}
			if (ProductDto.getName() != null){
				if (!ProductDto.getName().isEmpty()){
					Product.setName(ProductDto.getName());
				}
			}
			if (ProductDto.getCategory() != null){
				if (!ProductDto.getCategory().isEmpty()){
					Product.setCategory(ProductDto.getCategory());
				}
			}
			if (ProductDto.getBrand() != null){
				if (!ProductDto.getBrand().isEmpty()){
					Product.setBrand(ProductDto.getBrand());
				}
			}
			if (ProductDto.getType() != null){
				if (!ProductDto.getType().isEmpty()){
					Product.setType(ProductDto.getType());
				}
			}
			if (ProductDto.getDescription() != null){
				if (!ProductDto.getDescription().isEmpty()){
					Product.setDescription(ProductDto.getDescription());
				}
			}
			ProductService.addProduct(Product);
		}
		return "redirect:/";
	}

	@GetMapping(value = {"/delete/{code}"})
	public String getDeleteProduct(@PathVariable(name = "code") String code,@ModelAttribute(ATT_PRODUCT)ProductDto ProductDto,Model model){
		Product ProductEntity = ProductService.getProductbyCode(ProductDto.getCode());
		if (ProductEntity != null) {
			model.addAttribute("code", code); 
			ProductService.deleteProduct(ProductDto.getCode());
		}
		return "redirect:/Product";
	} 
}
