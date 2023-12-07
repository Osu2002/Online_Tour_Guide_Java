package com.info.service;

import java.util.ArrayList;

import com.info.model.Information;

public interface IInfoService {
	
	public void addInformation(Information information);
	
	public ArrayList<Information> getInformation();
	
	public ArrayList<Information> getInfoById(String infoID);
	
	public void updateInformation(String infoID, Information information);
	
	public void deleteInformation(String infoID);

}
