package org.society.service;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;

public interface ElectionResultService {
	public int addElectionResult(ElectionResult result);
	public List<ElectionResult> viewElectionResultList();
	public ElectionResult viewCandidatewiseResult(int candidateId);
	public double viewVotingPercentage();
	public double viewCandidateVotingPercent(int candidateId);
	public void displayVotingStatistics();
	public NominatedCandidates viewHighestVotingPercentCandidate();
	public NominatedCandidates viewLowestVotingPercentCandidate();
	public int viewInvalidVotes();
	public List<NominatedCandidates> candidatewiseInvalidVotesList();
	public void displayPollingResult();
}
