package org.society.dao;

import java.util.List;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerNotFoundException;

public interface ElectionOfficerDao {
	public int addElectionOfficerDetails(ElectionOfficer officer);
	public int updateElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerNotFoundException;
	public int deleteElectionOfficer(int officerId) throws ElectionOfficerNotFoundException;
	public ElectionOfficer viewElectionOfficerById(int officerId) throws ElectionOfficerNotFoundException;
	public List<ElectionOfficer> viewElectionOfficerList();
}
