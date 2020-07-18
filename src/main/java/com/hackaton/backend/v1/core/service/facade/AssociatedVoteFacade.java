package com.hackaton.backend.v1.core.service.facade;

import com.hackaton.backend.v1.core.enums.AssociatedVoteApiEnum;
import com.hackaton.backend.v1.core.model.AssociatedVoteApi;
import com.hackaton.backend.v1.core.service.client.IAssociatedVoteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociatedVoteFacade {

    private final IAssociatedVoteClient associatedVoteClient;

    public boolean associatedCanVote(String cpf) {
        AssociatedVoteApi canVote = associatedVoteClient.ableToVote(cpf);
        return canVote.getStatus() == AssociatedVoteApiEnum.ABLE_TO_VOTE;
    }
}
