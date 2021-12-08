package com.momo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.entity.DetailBillEntity;
import com.momo.repository.DetailBillRepository;

public class DetailBillRepositoryImpl implements DetailBillRepository {

	private final String DB_URL = "jdbc:mysql://localhost:3306/momo_machine";
	private final String USER = "root";
	private final String PASS = "sapassword";

	@Override
	public void updateDetailBill(DetailBillEntity detailBillEntity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"UPDATE detail_bill SET product_id = ?, bill_id = ?, quantity = ?, quantity_prize = ?  WHERE id = ?");
				stmt = conn.prepareStatement(sql.toString());
				stmt.setLong(1, detailBillEntity.getProductId());
				stmt.setLong(2, detailBillEntity.getBillId());
				stmt.setInt(3, detailBillEntity.getQuantity());
				stmt.setInt(4, detailBillEntity.getQuantityPrize());
				stmt.setLong(5, detailBillEntity.getId());
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
	public void createDetailBillEntity(DetailBillEntity detailBillEntity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			if (conn != null) {

				StringBuilder sql = new StringBuilder(
						"Insert into detail_bill(product_id, bill_id, quantity, quantity_prize) values(?,?,?,?)");
				stmt = conn.prepareStatement(sql.toString());
				stmt.setLong(1, detailBillEntity.getProductId());
				stmt.setLong(2, detailBillEntity.getBillId());
				stmt.setInt(3, detailBillEntity.getQuantity());
				stmt.setInt(4, detailBillEntity.getQuantityPrize());
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
	public List<DetailBillEntity> getDetailBillByBillIdAndProductId(Long billId, Long productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<DetailBillEntity> deBillEntities = new ArrayList<DetailBillEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"Select * from detail_bill where bill_id = " + billId + " and product_id = " + productId);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					DetailBillEntity detailBillEntity = new DetailBillEntity();
					detailBillEntity.setId(rs.getLong("id"));
					detailBillEntity.setBillId(rs.getLong("bill_id"));
					detailBillEntity.setProductId(rs.getLong("product_id"));
					detailBillEntity.setQuantity(rs.getInt("quantity"));
					detailBillEntity.setQuantityPrize(rs.getInt("quantity_prize"));
					deBillEntities.add(detailBillEntity);
				}
				return deBillEntities;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ArrayList<DetailBillEntity>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<DetailBillEntity>();
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
		return new ArrayList<DetailBillEntity>();
	}

	@Override
	public List<DetailBillEntity> getDetailBillsByBillIdAndProductId(Long billId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<DetailBillEntity> deBillEntities = new ArrayList<DetailBillEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder("Select * from detail_bill where bill_id = " + billId);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					DetailBillEntity detailBillEntity = new DetailBillEntity();
					detailBillEntity.setId(rs.getLong("id"));
					detailBillEntity.setBillId(rs.getLong("bill_id"));
					detailBillEntity.setProductId(rs.getLong("product_id"));
					detailBillEntity.setQuantity(rs.getInt("quantity"));
					detailBillEntity.setQuantityPrize(rs.getInt("quantity_prize"));
					deBillEntities.add(detailBillEntity);
				}
				return deBillEntities;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new ArrayList<DetailBillEntity>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<DetailBillEntity>();
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
		return new ArrayList<DetailBillEntity>();
	}

	@Override
	public DetailBillEntity getByBillIdAndProductId(Long billId, Long productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		DetailBillEntity detailBillEntity = new DetailBillEntity();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				StringBuilder sql = new StringBuilder(
						"Select * from detail_bill where bill_id = " + billId + " and product_id = " + productId);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				while (rs.next()) {
					detailBillEntity.setId(rs.getLong("id"));
					detailBillEntity.setBillId(rs.getLong("bill_id"));
					detailBillEntity.setProductId(rs.getLong("product_id"));
					detailBillEntity.setQuantity(rs.getInt("quantity"));
					detailBillEntity.setQuantityPrize(rs.getInt("quantity_prize"));
				}
				return detailBillEntity;
			}
		} catch (ClassNotFoundException | SQLException | ArithmeticException e) {
			e.printStackTrace();
			return new DetailBillEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return new DetailBillEntity();
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
		return new DetailBillEntity();
	}

}
