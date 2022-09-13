package com.momen.khanno.real_state;

import com.momen.khanno.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RealStateServiceImpl implements RealStateService {

    private RealStateRepository repository;

    @Override
    public RealState save(RealState realState) {
        return repository.save(realState);
    }

    @Override
    public RealState update(RealState realState) {
        RealState savedBefore = getById(realState.getId());
        savedBefore.setName(realState.getName());
        savedBefore.setOwnerName(realState.getOwnerName());
        savedBefore.setActivityRegion(realState.getActivityRegion());
        savedBefore.setAddress(realState.getAddress());
        savedBefore.setNumber(realState.getNumber());
        savedBefore.setDetails(realState.getDetails());
        savedBefore.setLocation(realState.getLocation());
        savedBefore.setLogo(realState.getLogo());

        return repository.save(savedBefore);
    }

    @Override
    public RealState getById(long id) {
        Optional<RealState> optionalRealState = repository.findById(id);

        if (optionalRealState.isEmpty())
            throw new NotFoundException("Real State Not Found");

        return optionalRealState.get();
    }

    @Override
    public void delete(Long id) {
        RealState realState = getById(id);
        repository.delete(realState);
    }

    @Override
    public Page<RealState> getRealStates(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page, count, Sort.by("id").ascending()));
    }
}
