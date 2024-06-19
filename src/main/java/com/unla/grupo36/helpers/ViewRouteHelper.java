package com.unla.grupo36.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";

	//DEGREE
	public final static String DEGREE_INDEX = "degree/index";
	public final static String DEGREE_FORM = "degree/form";
	public final static String DEGREE_NEW = "degree/new";

	//PERSON
	public final static String PERSON_INDEX = "person/index";
	public final static String PERSON_NEW = "person/new";
	public final static String PERSON_UPDATE = "person/update";
	public final static String PERSON_PARTIAL_VIEW = "person/partialPersonView";

	
	//PRODUCT
	public final static String PRODUCT_VIEW = "/products/view";
	public static final String PRODUCTS_ADD = "/products/add";
	public static final String PRODUCT_INDEX = "products/index";
	public static final String PRODUCT_EDIT = "products/edit";

	
	//LOT
	public static final String LOT_ADD = "/lots/add";

	
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	public final static String USER_REGISTER = "user/register";


	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String DEGREE_ROOT = "/degrees/";
	public final static String PERSON_ROOT = "/person";
	public static final String PRODUCT_ROOT = "/products";

	

}
