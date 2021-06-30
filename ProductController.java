package jp.co.internous.origami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.origami.model.domain.MstProduct;
import jp.co.internous.origami.model.mapper.MstProductMapper;
import jp.co.internous.origami.model.session.LoginSession;

@Controller
@RequestMapping("/origami/product")
public class ProductController {
	//商品IDの受け取り、MstProductMapperへの指示
	@Autowired
	private MstProductMapper mstProductMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/{id}")
	public String productDetail(Model m, @PathVariable("id") int id) {
		MstProduct MstProduct = mstProductMapper.findById(id);
		
		m.addAttribute("MstProduct",MstProduct);
		m.addAttribute("loginSession",loginSession);
		
		return "product_detail";
	}
	
}
