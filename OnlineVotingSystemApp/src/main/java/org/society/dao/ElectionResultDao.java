package org.society.dao;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface ElectionResultDao {
	public int addElectionResult(ElectionResult result);
	public List<ElectionResult> viewElectionResultList();
	public ElectionResult viewCandidatewiseResult(int candidateId) throws NominatedCandidateNotFoundException;
	public double viewVotingPercentage();
	public double viewCandidateVotingPercent(int candidateId);
	public void displayVotingStatistics();
	public NominatedCandidates viewHighestVotingPercentCandidate();
	public NominatedCandidates viewLowestVotingPercentCandidate();
	public int viewInvalidVotes();
	public List<NominatedCandidates> candidatewiseInvalidVotesList();
	public void displayPollingResult();
	
}
