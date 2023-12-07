package com.info.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.info.model.Information;
import com.info.util.CommonConstants;
import com.info.util.CommonUtil;
import com.info.util.DBConnection;
import com.info.util.QueryUtil;

public class InfoServiceImpl implements IInfoService {
	
	private static Connection connection;
	private static Statement stmt;
	private static PreparedStatement prepstmt;
	
//	static {
		
//	createInfoTable();
//	}
	
	public static void createInfoTable() {
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			stmt = connection.createStatement();
			
			stmt.execute(QueryUtil.queryById(CommonConstants.QUERY_ID_CREATE_INFO_TABLE));
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Create Table Exception: " + e.getMessage());
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e.getMessage());
			}
		}
	}

	@Override
	public void addInformation(Information information) {
		
		//check if the location id exists
		
		String infoID = CommonUtil.generateInfoIds(getInformationIds());
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_INSERT_INFO));
			connection.setAutoCommit(false);
			
			information.setInfoID(infoID);
			
			prepstmt.setString(CommonConstants.COL_INDEX_ONE, information.getInfoID());
			prepstmt.setString(CommonConstants.COL_INDEX_TWO, information.getLocationID());
			prepstmt.setString(CommonConstants.COL_INDEX_THREE, information.getHeading());
			prepstmt.setString(CommonConstants.COL_INDEX_FOUR, information.getDescription());
			
			prepstmt.executeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Exception in Add Information method: " + e);
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(prepstmt != null) {
					prepstmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e);
			}
		}
		
	}

	@Override
	public ArrayList<Information> getInformation() {
		
		ArrayList<Information> informationList = new ArrayList<>();
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_ALL_INFO));
			
			//prepstmt.setString(CommonConstants.COL_INDEX_ONE, locationID);
			
			ResultSet rs = prepstmt.executeQuery();
			
			while(rs.next()) {
				
				Information inf = new Information();
				
				inf.setInfoID(rs.getString(CommonConstants.COL_INDEX_ONE));
				inf.setLocationID(rs.getString(CommonConstants.COL_INDEX_TWO));
				inf.setHeading(rs.getString(CommonConstants.COL_INDEX_THREE));
				inf.setDescription(rs.getString(CommonConstants.COL_INDEX_FOUR));
				
				informationList.add(inf);
			}
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Exception in Get Information method: " + e.getMessage());
			
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(prepstmt != null) {
					prepstmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e);
			}
			
		}
		
		return informationList;
	}

	@Override
	public ArrayList<Information> getInfoById(String infoID) {
		
		ArrayList<Information> informationList = new ArrayList<>();
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_INFO_BY_ID));
			
			prepstmt.setString(CommonConstants.COL_INDEX_ONE, infoID);
			
			ResultSet rs = prepstmt.executeQuery();
			
			while(rs.next()) {
				
				Information inf = new Information();
				
				inf.setInfoID(rs.getString(CommonConstants.COL_INDEX_ONE));
				inf.setLocationID(rs.getString(CommonConstants.COL_INDEX_TWO));
				inf.setHeading(rs.getString(CommonConstants.COL_INDEX_THREE));
				inf.setDescription(rs.getString(CommonConstants.COL_INDEX_FOUR));
				
				informationList.add(inf);
			}
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Exception in Get Information by ID method: " + e.getMessage());
			
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(prepstmt != null) {
					prepstmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e);
			}
		}
		
		return informationList;
	}

	@Override
	public void updateInformation(String infoID, Information information) {

		try {
			
			connection = DBConnection.getDBConnection();
			
			prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_UPDATE_INFO));
			connection.setAutoCommit(false);
			
			prepstmt.setString(CommonConstants.COL_INDEX_ONE, information.getLocationID());
			prepstmt.setString(CommonConstants.COL_INDEX_TWO, information.getHeading());
			prepstmt.setString(CommonConstants.COL_INDEX_THREE, information.getDescription());
			prepstmt.setString(CommonConstants.COL_INDEX_FOUR, information.getInfoID());
			
			prepstmt.executeLargeUpdate();
			connection.commit();
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Exception in Update Information method: " + e);
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(prepstmt != null) {
					prepstmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e);
			}
		}
	}

	@Override
	public void deleteInformation(String infoID) {

		if(infoID != null && !infoID.isEmpty()) {
			
			try {
				
				connection = DBConnection.getDBConnection();
				
				prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_DELETE_INFO));
				prepstmt.setString(CommonConstants.COL_INDEX_ONE, infoID);
				
				prepstmt.execute();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
				System.out.println("Exception in Delete Information method: " + e.getMessage());
			}finally {
				
				try {
					
					if(connection != null) {
						
						connection.close();
					}
					
					if(prepstmt != null) {
						prepstmt.close();
					}
				}catch(SQLException e) {
					
					System.out.println("Connection Close Exception: " + e);
				}
				
			}
		}
	}
	
	public ArrayList<String> getInformationIds(){
		
		ArrayList<String> ids = new ArrayList<>();
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			prepstmt = connection.prepareStatement(QueryUtil.queryById(CommonConstants.QUERY_ID_GET_INFORMATION_IDS));
			
			ResultSet rs = prepstmt.executeQuery();
			
			while(rs.next()) {
				ids.add(rs.getString(CommonConstants.COL_INDEX_ONE));
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println("Exception in Getting Information IDs method: " + e.getMessage());
		}finally {
			
			try {
				
				if(connection != null) {
					
					connection.close();
				}
				
				if(prepstmt != null) {
					prepstmt.close();
				}
			}catch(SQLException e) {
				
				System.out.println("Connection Close Exception: " + e.getMessage());
			}
		}
		
		return ids;
	}

}
