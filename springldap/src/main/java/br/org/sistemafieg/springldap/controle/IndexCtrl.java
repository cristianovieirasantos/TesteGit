package br.org.sistemafieg.springldap.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.org.sistemafieg.springldap.ldap.ADAuthentication;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexCtrl {
	
	@Autowired
	ADAuthentication adAuth;

	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(@RequestParam("login")String login, @RequestParam("password") String password){
		return adAuth.autenticar(login, password)?"true":"false";
	}
}
