package top.faruxue.controller;


import org.mockito.internal.util.StringUtil;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.faruxue.domain.AppCode;
import top.faruxue.domain.Product;
import top.faruxue.handler.ApiException;
import top.faruxue.vo.ResultVo;

/**
 * @author: Frank
 * @date: 2022/8/16 22:27
 */
@RestController
@RequestMapping("test")
public class UserController {

    @RequestMapping("/findByVo")
    public Product findByVo(Product product) throws ApiException {
//        Product product = new Product();
//        product.setProductId(1);
//        product.setProductName("泡椒");
//        product.setProductPrice(100.00);
//        product.setProductDescription("中药泡脚加按摩");
//        product.setProductStatus(0);
//        if (StringUtils.isEmpty(product.getProductName())) {
//            throw new RuntimeException();
//        }
//        int length = product.getProductDescription().length();
//        test
        if (product.getProductDescription() == null) {
            throw new ApiException(AppCode.APP_ERROR, "商品描述为空");
        }
        return product;
    }


}
