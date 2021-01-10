package az.product.controller.rest;

import az.product.model.dto.ProductDto;
import az.product.model.dto.ProductForList;
import az.product.service.PhotoService;
import az.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AdminControllerRest {

    @Autowired
    private ProductService productService;


    @PostMapping("/add-product")
    public void addProduct(
            @ModelAttribute ProductDto productDto
    ){
        productService.addProduct(productDto);
    }

    @GetMapping("/product-list")
    public List<ProductForList> getProductList(){
        return productService.getProductList();
    }

    @PutMapping("/update-product/{productId}")
    public ProductForList updateProduct(
            @ModelAttribute ProductDto productDto
    ){
        Optional<ProductForList> optionalProductForList =
                productService.getProductById(productDto.getProductId());
        if (optionalProductForList.isPresent()){
            productDto.setPhotoId(optionalProductForList.get().getPhotoId());
            productService.updateProduct(productDto);
        }

        return  optionalProductForList.get();
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(
            @PathVariable(name = "id") long id
    ){
        productService.deleteProductById(id);
    }

}
