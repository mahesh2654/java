package org.society.service;

import java.util.List;

import org.society.entities.CooperativeSociety;

public interface CooperativeSocietyService {
	public int addSocietyDetails(CooperativeSociety society);
	public int updateSocietyDetails(CooperativeSociety society);
	public int deleteSociety(int societyId) ;
	public List<CooperativeSociety> viewSocietiesList();
	public CooperativeSociety viewSocietyById(int societyId) ;
}
