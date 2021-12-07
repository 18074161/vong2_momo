package com.momo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.momo.constance.MoneyConstance;
import com.momo.entity.BillEntity;
import com.momo.entity.DetailBillEntity;
import com.momo.entity.ProductEntity;
import com.momo.entity.PromotionEntity;
import com.momo.repository.BillRepository;
import com.momo.repository.ProductRepository;
import com.momo.repository.PromotionRepository;
import com.momo.repository.impl.BillRepositoryImpl;
import com.momo.repository.impl.DetailBillRepositoryImpl;
import com.momo.repository.impl.ProductRepositoryImpl;
import com.momo.repository.impl.PromotionRepositoryImpl;
import com.momo.service.DetailBillRepository;
import com.momo.service.PromotionService;
import com.momo.service.impl.PromotionServiceImpl;

public class Test {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ProductRepositoryImpl productImpl = new ProductRepository();
//		PromotionRepositoryImpl promotionRepositoryImpl = new PromotionRepository();
//		System.out.println(new Date()+"");
//		List<ProductEntity> entities = new ArrayList<ProductEntity>();
//		entities = productImpl.getAllProduct();
//		System.out.println(entities);
//		System.out.println(productImpl.getProductByCode("code"));
//		PromotionEntity promotionEntity = promotionRepositoryImpl.getPromotion();
//		promotionEntity.setChace(50);
//		promotionRepositoryImpl.updatePromotion(promotionEntity);
//		int random = (int) (Math.random() * (10 - 1 + 1) + 1);
//		int random1 = (int) (Math.random() * (2 - 1 + 1) + 1);
//		System.out.println(random(30));
		
//		PromotionService promotionService = new PromotionServiceImpl();
//		System.err.println(promotionService.getPromotion());
		
//		Long a = 70000l;
//		if(a.compareTo(MoneyConstance.VND_50) == 1) {
//			System.out.println("a");
//		}else {
//			System.out.println("b");
//		}
//		
//			Date datePro = parseDate("2021-12-06");
//			Date date = new Date();
//			int a = date.getDay();
//			int b = datePro.getDay();
//			System.out.println(compareDay(date, datePro));
////			System.out.println(date);
//			
//			DetailBillRepository detailBillRepository = new DetailBillRepositoryImpl();
//			DetailBillEntity detailBillEntity = new DetailBillEntity();
//			detailBillEntity.setBillId(1l);
//			detailBillEntity.setProductId(1l);;
//			detailBillEntity.setQuantity(0);
//			detailBillEntity.setQuantityPrize(1);
//			detailBillEntity.setId(1l);
////			detailBillRepository.updateDetailBill(detailBillEntity);
//			System.out.println(detailBillRepository.getDetailBillByBillIdAndProductId(1l, 1l));
		BillRepository billRepository = new BillRepositoryImpl();	
		System.out.println(billRepository.getResultByBillId(31l));
	}
	
	
	private static int random(int percent) {
		//random from min to max
		double max = Math.round(100/percent);
		int min = 1;
		return  (int) (Math.random() * (max - min + 1) + 1);
	}
	
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	public static boolean compareDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
		                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		return sameDay;
	}

}
