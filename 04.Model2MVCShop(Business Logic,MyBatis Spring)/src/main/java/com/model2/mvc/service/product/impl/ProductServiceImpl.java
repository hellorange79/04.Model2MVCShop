package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;


@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	//Field
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	public void setProductDao() {
		this.productDao = productDao;
	}
	public ProductServiceImpl() {
		System.out.println(this.getClass()); 
	}
	

	//상품등록
	public void addProduct(Product product) throws Exception {
		
		productDao.insertProduct(product);
		
	}

	//상세정보
	public Product getProduct(int prodNo) throws Exception {
		//System.out.println(prodNo);
		return productDao.findProduct(prodNo);
	}

	//상품목록
	public Map<String, Object> getProductList(Search search) throws Exception {
		List<Product> list = productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);
		
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;	
		}

	//상품수정
	public void updateProduct(Product product) throws Exception {
		System.out.println(product);
		productDao.updateProduct(product);
		
	}
	
	

}
