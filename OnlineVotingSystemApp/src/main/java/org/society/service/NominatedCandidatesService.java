package org.society.service;

import java.util.List;

import org.society.entities.NominatedCandidates;

public interface NominatedCandidatesService {
	public int addNominatedCandidate(NominatedCandidates candidate);
	public int updateNominatedCandidateDetails(NominatedCandidates candidate);
	public int deleteNominatedCandididate(int candidateId) ;
	public List<NominatedCandidates> viewNominatedCandidatesList();
	public NominatedCandidates searchByCandidateId(int id);
}
