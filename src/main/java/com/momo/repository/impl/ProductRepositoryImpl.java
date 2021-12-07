package com.momo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.entity.ProductEntity;
import com.momo.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private final String DB_URL = "jdbc:mysql://localhost:3306/momo_machine";
	private final String USER = "root";
	private final String PASS = "sapassword";

	@Override
	public List<ProductEntity> getAllProduct() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ProductEntity> products = new ArrayList<ProductEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder("Select * from product");
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					ProductEntity product = new ProductEntity();
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setCode(rs.getString("code"));
					product.setPrice(rs.getLong("price"));
					products.add(product);
				}
				return products;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ArrayList<ProductEntity>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ProductEntity>();
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
		return new ArrayList<ProductEntity>();

	}

	@Override
	public ProductEntity getProductByCode(String code) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ProductEntity product = new ProductEntity();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder("Select * from product where code = " + code);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setCode(rs.getString("code"));
					product.setPrice(rs.getLong("price"));
				}
				return product;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ProductEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return new ProductEntity();
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
		return new ProductEntity();
	}

	@Override
	public ProductEntity getProductById(Long productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ProductEntity product = new ProductEntity();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder("Select * from product where id = " + productId);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					product.setId(rs.getLong("id"));
					product.setName(rs.getString("name"));
					product.setCode(rs.getString("code"));
					product.setPrice(rs.getLong("price"));
				}
				return product;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ProductEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return new ProductEntity();
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
		return new ProductEntity();
	}

}
