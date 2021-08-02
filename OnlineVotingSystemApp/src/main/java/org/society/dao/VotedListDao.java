package org.society.dao;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.exceptions.VoterNotFoundException;

public interface VotedListDao {
	public int castVotedList(VotedList votedList);
	public int updateVotedListDetails(VotedList votedList) throws CastedVoteNotFoundException;
	public int deletedVotedListDetails(int id) throws CastedVoteNotFoundException;
	public List<VotedList> viewVotedList();
	public VotedList searchByVoterId(int voterId) throws VoterNotFoundException;
	public List<VotedList> searchByNominatedCandidateId(int candidateId) throws NominatedCandidateNotFoundException;
}
