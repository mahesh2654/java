package org.society.service;

import java.util.List;

import org.society.entities.VotedList;

public interface VotedListService {
	public int castVotedList(VotedList votedList);
	public int updateVotedListDetails(VotedList votedList) ;
	public int deletedVotedListDetails(int id);
	public List<VotedList> viewVotedList();
	public VotedList searchByVoterId(int voterId);
	public List<VotedList> searchByNominatedCandidateId(int candidateId);
}
