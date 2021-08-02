package org.society.dao;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;

public interface NominatedCandidatesDao {
	public int addNominatedCandidate(NominatedCandidates candidate);
	public int updateNominatedCandidateDetails(NominatedCandidates candidate) throws NominatedCandidateNotFoundException;
	public int deleteNominatedCandididate(int candidateId) throws NominatedCandidateNotFoundException;
	public List<NominatedCandidates> viewNominatedCandidatesList();
	public NominatedCandidates searchByCandidateId(int id)throws NominatedCandidateNotFoundException;
}
