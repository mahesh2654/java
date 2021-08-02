package org.society.dao;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.exceptions.SocietyNotFoundException;

public interface CooperativeSocietyDao {
	public int addSocietyDetails(CooperativeSociety society);
	public int updateSocietyDetails(CooperativeSociety society) throws SocietyNotFoundException;
	public int deleteSociety(int societyId) throws SocietyNotFoundException;
	public List<CooperativeSociety> viewSocietiesList();
	public CooperativeSociety viewSocietyById(int societyId) throws SocietyNotFoundException;
}
