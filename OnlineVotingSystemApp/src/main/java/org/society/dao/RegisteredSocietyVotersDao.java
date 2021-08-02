package org.society.dao;

import java.util.List;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;

public interface RegisteredSocietyVotersDao {
	public int voterRegistration(RegisteredSocietyVoters voter);
	public int updateRegisteredVoterDetails(RegisteredSocietyVoters voter) throws VoterNotFoundException;
	public int deleteRegisteredVoter(int voterId) throws VoterNotFoundException;
	public List<RegisteredSocietyVoters> viewRegisteredVoterList();
	public RegisteredSocietyVoters searchByVoterID(int voterId) throws VoterNotFoundException;
	public RegisteredSocietyVoters loginValidate(String userid,String password) throws VoterNotFoundException;
}
