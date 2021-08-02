package org.society.service;

import java.util.List;

import org.society.entities.ElectionOfficer;

public interface ElectionOfficeService {
	public int addElectionOfficerDetails(ElectionOfficer officer);
	public int updateElectionOfficerDetails(ElectionOfficer officer);
	public int deleteElectionOfficer(int officerId);
	public ElectionOfficer viewElectionOfficerById(int officerId);
	public List<ElectionOfficer> viewElectionOfficerList();
}
