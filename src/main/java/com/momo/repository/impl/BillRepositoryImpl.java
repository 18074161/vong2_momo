package com.momo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.entity.BillEntity;
import com.momo.entity.ProductEntity;
import com.momo.entity.PromotionEntity;
import com.momo.entity.ResultOfBuiildEntity;
import com.momo.repository.BillRepository;

public class BillRepositoryImpl implements BillRepository {
	
	private final String DB_URL = "jdbc:mysql://localhost:3306/momo_machine";
	private final String USER = "root";
	private final String PASS = "sapassword";

	@Override
	public void createBillEntity(BillEntity billEntity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			if (conn != null) {

				StringBuilder sql = new StringBuilder("Insert into bill(customer_money, createddate) values(?,?)");
				stmt = conn.prepareStatement(sql.toString());
				stmt.setLong(1, billEntity.getCustomerMoney());
				stmt.setLong(2, billEntity.getCreatedDate());
				stmt.executeUpdate();
				conn.commit();
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();

				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

	}

	@Override
	public BillEntity getBillEntityByCreatedDateAndCustMoney(Long createdDate, Long custMoney) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		BillEntity billEntity = new BillEntity();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"Select * from bill where createddate = " + createdDate + " and customer_money = " + custMoney);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					billEntity.setId(rs.getLong("id"));
					billEntity.setCreatedDate(rs.getLong("createddate"));
					billEntity.setCustomerMoney(rs.getLong("customer_money"));
				}
				return billEntity;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new BillEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return new BillEntity();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return new BillEntity();

	}

	@Override
	public List<ResultOfBuiildEntity> getResultByBillId(Long billId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ResultOfBuiildEntity> resultOfBuiildEntities = new ArrayList<ResultOfBuiildEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"SELECT name, quantity, quantity_prize, (quantity * price) as 'price_product' FROM product as b  join detail_bill as d on b.id = d.product_id WHERE d.bill_id = "
								+ billId);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					ResultOfBuiildEntity resultOfBuiildEntity = new ResultOfBuiildEntity();
					resultOfBuiildEntity.setName(rs.getString("name"));
					resultOfBuiildEntity.setPriceProduct(rs.getLong("price_product"));
					resultOfBuiildEntity.setQuantity(rs.getInt("quantity"));
					resultOfBuiildEntity.setQuantityPrize(rs.getInt("quantity_prize"));
					resultOfBuiildEntities.add(resultOfBuiildEntity);
				}
				return resultOfBuiildEntities;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ArrayList<ResultOfBuiildEntity>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ResultOfBuiildEntity>();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return new ArrayList<ResultOfBuiildEntity>();
	}
}
