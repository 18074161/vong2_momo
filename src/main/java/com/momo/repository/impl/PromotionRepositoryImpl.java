package com.momo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.momo.entity.ProductEntity;
import com.momo.entity.PromotionEntity;
import com.momo.repository.PromotionRepository;

public class PromotionRepositoryImpl implements PromotionRepository {

	private final String DB_URL = "jdbc:mysql://localhost:3306/momo_machine";
	private final String USER = "root";
	private final String PASS = "sapassword";

	@Override
	public PromotionEntity getPromotion() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		PromotionEntity promotionEntity = new PromotionEntity();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder("Select * from promotion");
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					ProductEntity product = new ProductEntity();
					promotionEntity.setId(rs.getLong("id"));
					promotionEntity.setBudget(rs.getLong("budget"));
					promotionEntity.setDate(rs.getDate("date"));
					promotionEntity.setChace(rs.getInt("chance"));
				}
				return promotionEntity;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new PromotionEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return new PromotionEntity();
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
		return new PromotionEntity();

	}

	@Override
	public void updatePromotion(PromotionEntity promotionEntity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"UPDATE  promotion SET date = ?, budget = ?, chance = ?  WHERE id = ?");
				stmt = conn.prepareStatement(sql.toString());
				Date date = promotionEntity.getDate();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				stmt.setDate(1, sqlDate);
				stmt.setLong(2, promotionEntity.getBudget());
				stmt.setInt(3, promotionEntity.getChace());
				stmt.setLong(4, promotionEntity.getId());
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

}
