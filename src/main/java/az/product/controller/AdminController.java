package az.product.controller;

import az.product.model.db.Category;
import az.product.model.db.Photo;
import az.product.model.dto.ProductDto;
import az.product.model.dto.ProductForList;
import az.product.service.PhotoService;
import az.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/admin/")
@SessionAttributes(names = {"product"})
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("admin/index");
    }

    @GetMapping("/add-product")
    public ModelAndView getAddProduct() {
        ModelAndView mav = new ModelAndView("admin/addProduct");
        ProductDto productDto = new ProductDto();
        List<Category> categoryList = productService.getCategoryList();
        mav.addObject("productDto", productDto);
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    @PostMapping("save-product")
    public ModelAndView addProduct(
            @ModelAttribute(name = "productDto") @Valid ProductDto productDto,
            BindingResult br
    )  {
        ModelAndView mav = new ModelAndView("redirect:/admin/");
        if (br.hasErrors()) {
            mav.setViewName("admin/addProduct");
        } else {
            productService.addProduct(productDto);
        }
        return mav;

    }

    @Autowired
    private PhotoService photoService;

    @GetMapping("/get-product-list")
    public ModelAndView getProductList() {
        ModelAndView mav = new ModelAndView("admin/productList");
        List<ProductForList> productList = productService.getProductList();
        mav.addObject("productList", productList);
        return mav;
    }

    @GetMapping("/update-product")
    public ModelAndView updateProduct(
            @RequestParam(name = "id") long id
    ){
        ModelAndView mav = new ModelAndView("admin/updateProduct");
        Optional<ProductForList> optionalProductForList = productService.getProductById(id);
        ProductForList productForList = new ProductForList();
        if (optionalProductForList.isPresent()){
            productForList = optionalProductForList.get();
        }
        ProductDto productDto = new ProductDto();
        productDto.setName(productForList.getName());
        productDto.setDescription(productForList.getDescription());
        productDto.setCategoryId(productService.getCategoryIdByName(productForList.getCategoryName()));

        List<Category> categoryList = productService.getCategoryList();
        mav.addObject("productDto", productDto); // object for new data
        mav.addObject("categoryList", categoryList);
        mav.addObject("product" ,productForList);// current data

        return mav;
    }

    @PostMapping("save-updated-product")
    public ModelAndView saveUpdatedProduct(
            @ModelAttribute(name = "productDto") ProductDto productDto ,
            @ModelAttribute(name = "product") ProductForList productForList
    ){
        ModelAndView mav = new ModelAndView("redirect:/admin/get-product-list");
        productDto.setProductId(productForList.getId());
        productDto.setPhotoId(productForList.getPhotoId());
        productService.updateProduct(productDto);
        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProduct(
            @RequestParam(name = "id") long id
    ){
        ModelAndView mav = new ModelAndView("redirect:/admin/get-product-list");
        productService.deleteProductById(id);

        return mav;
    }


}


