package com.ECommerce.DAO;

import java.util.List;

import com.ECommerce.entity.Cart;

public class CartDAO {
	
	public void saveCart(Cart cart){
	
	}
	public void updateCart(Cart cart){
		
	}
	public void deleteCartById(int id){
		
	}
	public Cart removeAllItemsFromCart(int id){
		return null;
		
	}
//	public Cart removeItemFromCartByID(int id){
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		ItemDAO itemDao = new ItemDAO();
//	
//		Cart cart = em.find(Cart.class, id);
//		List<Item> allItems = cart.getItems();
//		for(Item item : allItems) {
//			itemDao.deleteItemById(item.getId());
//		}
//		return cart;
//		
//	}
	public Cart findCartById(int id){
		return null;
		
	}
	
}
