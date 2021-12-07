package com.momo.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.momo.constance.MoneyConstance;
import com.momo.controller.BillController;
import com.momo.controller.DetailBillController;
import com.momo.controller.ServiceController;
import com.momo.model.BillModel;
import com.momo.model.ProductModel;
import com.momo.service.ProductService;
import com.momo.service.Service;
import com.momo.service.impl.ProductServiceImpl;
import com.momo.service.impl.ServiceImpl;
import com.momo.utils.PromotionUtils;

public class MomoMachine {

	public static void main(String[] args) {
		Service service = new ServiceImpl();
		ServiceController serviceController = new ServiceController();
		BillController billController = new BillController();
		DetailBillController detailBillController = new DetailBillController();
		ProductService productService = new ProductServiceImpl();

		Scanner scanner = new Scanner(System.in);
		Long custMoney = 0l;
		// Enter the money
		String next = "Y";
		while (next.equals("Y")) {
			System.out.println("Nhập số tiền để mua sản phẩm");
			Long money = scanner.nextLong();
			scanner.nextLine();
			// check money valid
			if (service.checkInputMoney(money)) {
				custMoney += money;
			} else {
				System.out.println(
						"Tiền không hợp lệ, tiền phải nằm trong một trong các giá trị (10000, 20000, 50000, 100000, 200000)");
			}
			System.out.println("Quý khách có muốn tiếp tục nhập thêm tiền (Y/N)");
			next = scanner.nextLine();
		}

		// create Bill table with date and money
		Date date = new Date();
		billController.createBillController(custMoney, date.getTime());
		BillModel billModel = billController.getBillEntityByCreatedDateAndCustMoney(date.getTime(), custMoney);
		// create list and map
		Map<ProductModel, Integer> mapProducts = new HashMap<ProductModel, Integer>();
		List<ProductModel> productModels = productService.getAllProducts();
		//createCasemap
		Map<Integer, ProductModel> mapCaseProducts = new HashMap<Integer, ProductModel>();
		mapCaseProducts = PromotionUtils.getCaseMap(productModels);
		// get promotion
		mapProducts = PromotionUtils.resetPromotion(productModels);

		boolean cancer = true;
		while (cancer) {
			int key = 0;
			System.out.println("===============================");
			System.out.println("Xin mời quý khách chọn sản phẩm");
			System.out.println("1. Coke");
			System.out.println("2. Pepsi");
			System.out.println("3. Soda");
			System.out.println("4. Tôi không muốn mua nữa");
			System.out.println("===============================");
			key = scanner.nextInt();
			scanner.nextLine();

			ProductModel productModel = new ProductModel();
			switch (key) {
			case 1:

				productModel = mapCaseProducts.get(key);

				// Check if do not have enough money
				if (!detailBillController.checkMoney(billModel, productModel)) {
					System.out.println("Không đủ tiền để mua " + productModel.getName());
					break;
				} else {
					// quantity + 1
					detailBillController.addQuantityOfDetailBill(billModel, productModel);
				}

				// return mapCombo, use to set to get 3 times
				mapProducts = service.getMapCombo(productModel, productModels, mapProducts);

				// get time of buying product
				int combo = mapProducts.get(productModel);
				if (combo == 3) {
					mapProducts = service.checkPrize(mapProducts, productModel, productModels, billModel);
				}
				System.out.println(mapProducts);
				break;
			case 2:
				productModel = mapCaseProducts.get(key);
				if (!detailBillController.checkMoney(billModel, productModel)) {
					System.out.println("Không đủ tiền để mua " + productModel.getName());
					break;
				} else {
					detailBillController.addQuantityOfDetailBill(billModel, productModel);
				}
				mapProducts = service.getMapCombo(productModel, productModels, mapProducts);
				int combo1 = mapProducts.get(productModel);
				if (combo1 == 3) {
					mapProducts = service.checkPrize(mapProducts, productModel, productModels, billModel);
				}
				break;
			case 3:
				productModel = mapCaseProducts.get(key);
				if (!detailBillController.checkMoney(billModel, productModel)) {
					System.out.println("Không đủ tiền để mua " + productModel.getName());
					break;
				} else {
					detailBillController.addQuantityOfDetailBill(billModel, productModel);
				}
				mapProducts = service.getMapCombo(productModel, productModels, mapProducts);
				int combo2 = mapProducts.get(productModel);
				if (combo2 == 3) {
					mapProducts = service.checkPrize(mapProducts, productModel, productModels, billModel);
				}
				break;
			default:
				serviceController.printBill(billModel, productModel);
				cancer = false;
				break;
			}
		}

	}

}
