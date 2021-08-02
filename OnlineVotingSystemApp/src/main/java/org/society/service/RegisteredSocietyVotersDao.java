package org.society.service;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;

public interface RegisteredSocietyVotersDao {
	public int voterRegistration(RegisteredSocietyVoters voter);
	public int updateRegisteredVoterDetails(RegisteredSocietyVoters voter);
	public int deleteRegisteredVoter(int voterId);
	public List<RegisteredSocietyVoters> viewRegisteredVoterList();
	public RegisteredSocietyVoters searchByVoterID(int voterId) ;
	public RegisteredSocietyVoters loginValidate(String userid,String password) ;
}
