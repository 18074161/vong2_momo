package com.momo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.momo.constance.MoneyConstance;
import com.momo.entity.DetailBillEntity;
import com.momo.entity.PromotionEntity;
import com.momo.entity.ResultOfBuiildEntity;
import com.momo.model.BillModel;
import com.momo.model.ProductModel;
import com.momo.model.PromotionModel;
import com.momo.repository.BillRepository;
import com.momo.repository.DetailBillRepository;
import com.momo.repository.PromotionRepository;
import com.momo.repository.impl.BillRepositoryImpl;
import com.momo.repository.impl.DetailBillRepositoryImpl;
import com.momo.repository.impl.PromotionRepositoryImpl;
import com.momo.service.DetailBillService;
import com.momo.service.PromotionService;
import com.momo.service.Service;

public class ServiceImpl implements Service {

	private PromotionService promotionService = new PromotionServiceImpl();
	private DetailBillRepository detailBillRepository = new DetailBillRepositoryImpl();
	private PromotionRepository promotionRepository = new PromotionRepositoryImpl();
	private BillRepository billRepository = new BillRepositoryImpl();
	private DetailBillService detailBillService = new DetailBillServiceImpl();

	@Override
	public boolean checkInputMoney(Long money) {
		if (money.equals(MoneyConstance.VND_10) || money.equals(MoneyConstance.VND_20)
				|| money.equals(MoneyConstance.VND_50) || money.equals(MoneyConstance.VND_100)
				|| money.equals(MoneyConstance.VND_200)) {
			return true;
		}
		return false;
	}

	@Override
	public void print(List<ProductModel> productModels, Map<ProductModel, Integer> mapProducts) {
		StringBuilder stringBuilder = new StringBuilder();
		for (ProductModel productModel : productModels) {
			stringBuilder.append(productModel + " [" + mapProducts.get(productModel) + "] \n");
		}
		System.out.println(stringBuilder);
	}

	@Override
	public Map<ProductModel, Integer> selectProduct(List<ProductModel> productModels,
			Map<ProductModel, Integer> mapProducts, Scanner scanner, int quantity) {
		for (ProductModel productModel : productModels) {
			System.out.println("Nhập số lượng " + productModel.getName() + " bạn muốn mua");
			quantity = scanner.nextInt();
			scanner.nextLine();
			mapProducts.put(productModel, quantity);
		}
		return mapProducts;
	}

	@Override
	public boolean isWinThePrice(int chance, Long price) {
		PromotionModel promotionModel = promotionService.getPromotion();
		if (price.compareTo(promotionModel.getBudget()) > 0) {
			return false;
		}
		// random from min to max
		double max = Math.round(100 / chance);
		int min = 1;
		int number = (int) (Math.random() * (max - min + 1) + 1);
		if (number == MoneyConstance.WIN_NUMBER) {
//			promotionModel.setBudget(promotionModel.getBudget() - price);
//			promotionService.updatePromotion(promotionModel);
			return true;
		}
		return false;
	}

	// set Percent and money if qua ngay
	@Override
	public Integer getPercent() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PromotionModel promotionModel = promotionService.getPromotion();
		Date date = new Date();
		Date datePromotion = null;
		try {
			datePromotion = sdf.parse(promotionModel.getDate().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date.compareTo(datePromotion) > 0 && compareDay(date, datePromotion) == false) {
			promotionModel.setDate(date);
			if (promotionModel.getBudget().compareTo(MoneyConstance.VND_0) > 0) {
				promotionModel.setChace(MoneyConstance.PERCENT_50);
				promotionModel.setBudget(MoneyConstance.VND_50);
				promotionService.updatePromotion(promotionModel);
				return MoneyConstance.PERCENT_50;
			} else {
				promotionModel.setChace(MoneyConstance.PERCENT_10);
				promotionModel.setBudget(MoneyConstance.VND_50);
				promotionService.updatePromotion(promotionModel);
				return MoneyConstance.PERCENT_10;
			}
		}
		return promotionModel.getChace();
	}

	@Override
	public Map<ProductModel, Integer> getMapCheckPrize(List<ProductModel> productModels,
			Map<ProductModel, Integer> mapProducts) {
		for (ProductModel productModel : productModels) {
			if (mapProducts.get(productModel) >= 3) {
				// get percent
				int percent = getPercent();
				if (isWinThePrice(percent, productModel.getPrice())) {
					mapProducts.put(productModel, mapProducts.get(productModel) + 1);
				}
			}
		}
		return mapProducts;
	}

	public boolean compareDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		return sameDay;
	}

	@Override
	public Map<ProductModel, Integer> getMapCombo(ProductModel model, List<ProductModel> productModels,
			Map<ProductModel, Integer> mapProducts) {
		for (ProductModel productModel : productModels) {
			// Những product khác không chọn thì set lại từ đầu combo = 0
			if (!productModel.getCode().equals(model.getCode())) {
				mapProducts.put(productModel, 0);
			} else {
				// combo + 1
				mapProducts.put(productModel, mapProducts.get(productModel) + 1);
			}

		}
		return mapProducts;
	}

	@Override
	public Map<ProductModel, Integer> checkPrize(Map<ProductModel, Integer> mapProducts, ProductModel productModel,
			List<ProductModel> productModels, BillModel billModel) {
		// check thuong
		int percent = getPercent();
		if (isWinThePrice(percent, productModel.getPrice())) {
			// update quantity_prize + 1
			DetailBillEntity detailBillEntity = detailBillRepository.getByBillIdAndProductId(billModel.getId(),
					productModel.getId());
			detailBillEntity.setQuantityPrize(detailBillEntity.getQuantityPrize() + 1);
			detailBillRepository.updateDetailBill(detailBillEntity);
			// update Promotion budget
			PromotionEntity promotionEntity = new PromotionEntity();
			promotionEntity = promotionRepository.getPromotion();
			promotionEntity.setBudget(promotionEntity.getBudget() - 1 * productModel.getPrice());
			promotionRepository.updatePromotion(promotionEntity);
			// thong bao trung giai
			System.out.println("Chúc mừng bạn được tặng miễn phí 1 chai: " + productModel.getName());
		}
		// set lai combo
		for (ProductModel model : productModels) {
			mapProducts.put(productModel, 0);
		}
		return mapProducts;
	}

	@Override
	public void printBillByBillId(BillModel billModel, ProductModel productModel) {
		List<ResultOfBuiildEntity> resultOfBuiildEntities = new ArrayList<ResultOfBuiildEntity>();
		resultOfBuiildEntities = billRepository.getResultByBillId(billModel.getId());
		Long sum = 0l;
		StringBuilder str = new StringBuilder();
		for (ResultOfBuiildEntity resultOfBuiildEntity : resultOfBuiildEntities) {
			sum += resultOfBuiildEntity.getPriceProduct();
			int quantity = resultOfBuiildEntity.getQuantity() + resultOfBuiildEntity.getQuantityPrize();
			str.append(resultOfBuiildEntity.getName() + " số lượng: " + quantity + " thành tiền: "
					+ resultOfBuiildEntity.getPriceProduct());
			if (resultOfBuiildEntity.getQuantityPrize() != 0) {
				str.append(" được khuyến mãi " + resultOfBuiildEntity.getQuantityPrize() + " chai "
						+ resultOfBuiildEntity.getName());
			}
			str.append(". \n");
		}
		System.out.println("\n===============Hóa đơn===============");
		System.out.println("");
		System.out.println("Các sản phẩm quí khách đã mua: ");
		System.out.println(str);
		System.out.println("");
		System.out.println("Số tiền quý khách đưa: " + billModel.getCustomerMoney());
		System.out.println("Tổng tiền sản phẩm: " + sum);
		Long moneyRefund = detailBillService.getRefundOfBill(billModel, productModel);
		System.out.println("Tiền thừa của quý khách: " + moneyRefund);
		System.out.println("==================================\n");
	}

}
